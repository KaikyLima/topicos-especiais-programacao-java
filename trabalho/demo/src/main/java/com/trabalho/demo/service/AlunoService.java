package com.trabalho.demo.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno gravarAluno(Aluno aluno){
        if (aluno == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo Aluno não pode ser nulo");
        }
        if (aluno.getNome() == null || aluno.getNome().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome não pode ser nulo");
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarAluno(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarId(Long id) {
        return alunoRepository.findById(id);
    }
}
