package com.trabalho.demo.service;

import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.model.Curso;
import com.trabalho.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso gravarCurso(Curso curso){
        if (curso == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo CURSO não pode ser nulo");
        }
        if (curso.getNomeCurso() == null || curso.getNomeCurso().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome não pode ser nulo");
        }

        return cursoRepository.save(curso);
    }
    public List<Curso> buscarCurso(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarId(Long id) {
        return cursoRepository.findById(id);
    }
    public void deletarCurso(Optional<Curso>curso){
        cursoRepository.delete(curso.get());
    }
}
