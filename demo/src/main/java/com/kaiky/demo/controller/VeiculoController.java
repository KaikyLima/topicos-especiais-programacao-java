package com.kaiky.demo.controller;

import com.kaiky.demo.model.Veiculo;
import com.kaiky.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService service;
    @PostMapping
    public ResponseEntity<Object> gravarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaVeiculo(veiculo));
    }
    @GetMapping
    public ResponseEntity<List<Veiculo>> buscarTudo (){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTudo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> buscaId (@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVeiculo(@PathVariable(value = "id") Long id, @RequestBody Veiculo veiculo){
            Optional<Veiculo> v = service.buscaId(id);

            if(v.isEmpty()){
                return ResponseEntity.status((HttpStatus.OK)).body("Não localizado !");
            }
            Veiculo veiculo1 = v.get();
            veiculo1.setModelo(veiculo.getModelo());
            veiculo1.setMarca(veiculo.getMarca());
            veiculo1.setCor(veiculo.getCor());

            return ResponseEntity.status(HttpStatus.OK).body(service.gravaVeiculo(veiculo1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaVeiculo (@PathVariable(value = "id") Long id){
        Optional<Veiculo> v = service.buscaId(id);

        if(v.isEmpty()){
            return ResponseEntity.status((HttpStatus.OK)).body("Não localizado !");
        }

        service.deletaVeiculo(v);

        return ResponseEntity.status(HttpStatus.OK).body("Veiculo Deletado");
    }


}
