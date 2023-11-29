package com.trabalho.demo.controller;

import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.model.Curso;
import com.trabalho.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Object> gravarAlunos(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.gravarCurso(curso));
    }
    @GetMapping
    public ResponseEntity<List<Curso>> buscarCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.buscarCurso());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>>buscarId (@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.buscarId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCurso (@PathVariable(value = "id") Long id, @RequestBody Curso curso){
        Optional<Curso> c = cursoService.buscarId(id);
        if(c == null){
            System.out.println("test");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado!");
        }
        Curso curso1 =c.get();
        curso1.setNomeCurso(curso.getNomeCurso());

        return ResponseEntity.status(HttpStatus.OK).body(cursoService.gravarCurso(curso1));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCurso (@PathVariable(value = "id") Long id){
        Optional<Curso> a = cursoService.buscarId(id);

        if(a == null){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }
        cursoService.deletarCurso(a);
        return ResponseEntity.status(HttpStatus.OK).body("Curso DELETADO!");
    }

}
