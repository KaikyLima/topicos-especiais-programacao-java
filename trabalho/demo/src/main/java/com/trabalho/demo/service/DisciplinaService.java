package com.trabalho.demo.service;

import com.trabalho.demo.model.Curso;
import com.trabalho.demo.model.Disciplina;
import com.trabalho.demo.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina gravarDisciplina(Disciplina disciplina){
        if (disciplina == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo DISCIPLINA não pode ser nulo");
        }
        if (disciplina.getNomeDisciplina() == null || disciplina.getNomeDisciplina().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome não pode ser nulo");
        }

        return disciplinaRepository.save(disciplina);
    }
    public List<Disciplina> bucarDisciplina(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarId(Long id) {
        return disciplinaRepository.findById(id);
    }
    public void deltarDisciplina(Optional<Disciplina>disciplina){
        disciplinaRepository.delete(disciplina.get());
    }
}
