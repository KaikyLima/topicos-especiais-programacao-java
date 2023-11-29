package com.trabalho.demo.service;

import com.trabalho.demo.model.Aluno;
import com.trabalho.demo.model.Nota;
import com.trabalho.demo.repository.AlunoRepository;
import com.trabalho.demo.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public Nota gravarNota(Nota nota){
        if (nota == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo NOTA não pode ser nulo");
        }

        return notaRepository.save(nota);
    }

    public List<Nota> buscarNota(){
        return notaRepository.findAll();
    }

    public Optional<Nota> buscarId(Long id) {
        return notaRepository.findById(id);
    }
    public void deletarNota(Optional<Nota>nota){
        notaRepository.delete(nota.get());
    }
}
