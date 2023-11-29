package com.trabalho.demo.controller;

import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.model.Nota;
import com.trabalho.demo.service.AlunoService;
import com.trabalho.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    private NotaService service;

    @PostMapping
    public ResponseEntity<Object> gravarNota(@RequestBody Nota nota){
        if (nota.getNota() >= 7) {
            nota.setStatus("Aprovado");
        } else if (nota.getNota() < 7 && nota.getNota() > 0) {
            nota.setStatus("Reprovado");
        } else {
            nota.setStatus("Ativo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarNota(nota));
    }

    @GetMapping
    public ResponseEntity<List<Nota>> buscarNotas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarNota());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Nota>> buscarId(@PathVariable(value = "id") Long id){
        Optional<Nota> optionalNota = service.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarNota(@PathVariable(value = "id") Long id, @RequestBody Nota nota){
        Optional<Nota> optionalNota = service.buscarId(id);

        if (optionalNota.isPresent()) {
            Nota notaToUpdate = optionalNota.get();
            notaToUpdate.setNota(nota.getNota());
            notaToUpdate.setStatus(nota.getStatus());
            return ResponseEntity.status(HttpStatus.OK).body(service.gravarNota(notaToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarNota(@PathVariable(value = "id") Long id){
        Optional<Nota> optionalNota = service.buscarId(id);

        if (optionalNota.isPresent()) {
            service.deletarNota(optionalNota);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nota DELETADA!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota não encontrada");
        }
    }
}

