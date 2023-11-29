package com.trabalho.demo.controller;

import com.trabalho.demo.model.Curso;
import com.trabalho.demo.model.Disciplina;
import com.trabalho.demo.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

        @PostMapping
    public ResponseEntity<Object> gravarDisciplina(@RequestBody Disciplina disciplina) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.gravarDisciplina(disciplina));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao gravar disciplina: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> buscarDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.bucarDisciplina());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Disciplina>>buscarId (@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.buscarId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDisciplina (@PathVariable(value = "id") Long id, @RequestBody Disciplina disciplina){
        Optional<Disciplina> d = disciplinaService.buscarId(id);
        if(d == null){
            System.out.println("test");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado!");
        }
        Disciplina disciplina1 =d.get();
        disciplina1.setNomeDisciplina(disciplina.getNomeDisciplina());

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.gravarDisciplina(disciplina1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDisciplina (@PathVariable(value = "id") Long id){
        Optional<Disciplina> a = disciplinaService.buscarId(id);

        if(a == null){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }
        disciplinaService.deltarDisciplina(a);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina DELETADO!");
    }
}
