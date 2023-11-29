package com.trabalho.demo.controller;

import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.repository.AlunoRepository;
import com.trabalho.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Object> gravarAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarAluno(aluno));
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> buscarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAluno());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>>buscarId (@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno (@PathVariable(value = "id") Long id, @RequestBody Aluno aluno){
        Optional<Aluno> a = service.buscarId(id);
        if(a == null){
            System.out.println("test");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado!");
        }
        Aluno aluno1 =a.get();
        aluno1.setNome(aluno.getNome());
        aluno1.setCpf(aluno.getCpf());
        aluno1.setSexo(aluno.getSexo());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravarAluno(aluno1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno (@PathVariable(value = "id") Long id){
        Optional<Aluno> a = service.buscarId(id);

        if(a == null){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }
        service.deletarAluno(a);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno DELETADO!");
    }
}
