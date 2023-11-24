package com.kaiky.demo.controller;

import com.kaiky.demo.model.PessoaTde;
import com.kaiky.demo.model.Veiculo;
import com.kaiky.demo.service.PessoaTdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/pessoaTde")
public class PessoaTdeController    {

    @Autowired
    private PessoaTdeService service;

    @PostMapping
    public ResponseEntity<Object> gravarPessoaTde(@RequestBody PessoaTde pessoaTde){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarPessoaTde(pessoaTde));
    }
    @GetMapping
    public ResponseEntity<List<PessoaTde>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PessoaTde>>buscarId (@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoaTde (@PathVariable(value = "id") Long id, @RequestBody PessoaTde pessoaTde){
        Optional<PessoaTde> p = service.buscarId(id);
        if(p.isEmpty()){
            System.out.println("teste");
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Não Localizado !");
        }
        PessoaTde pessoaTde1 = p.get();
        pessoaTde1.setNome(pessoaTde.getNome());
        pessoaTde1.setCpf(pessoaTde.getCpf());
        pessoaTde1.setSexo(pessoaTde.getSexo());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravarPessoaTde(pessoaTde1));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Object> deletarPessoaTde (@PathVariable(value = "id") Long id){
        Optional<PessoaTde> p = service.buscarId(id);

        if(p.isEmpty()){
            return ResponseEntity.status((HttpStatus.OK)).body("Não localizado !");
        }

        service.deletarPessoaTde(p);

        return ResponseEntity.status(HttpStatus.OK).body("Pessoa Deletado");
    }

}
