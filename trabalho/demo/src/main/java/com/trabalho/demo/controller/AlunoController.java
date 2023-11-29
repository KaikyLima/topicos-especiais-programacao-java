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
}
