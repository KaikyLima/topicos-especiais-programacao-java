package com.kaiky.demo.service;

import com.kaiky.demo.model.PessoaTde;
import com.kaiky.demo.model.Veiculo;
import com.kaiky.demo.repository.PessoaTdeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaTdeService {

    @Autowired
    private PessoaTdeRepository repository;

    public PessoaTde gravarPessoaTde(PessoaTde pessoaTde){
        if (!pessoaTde.getVeiculos().isEmpty()){
               for(Veiculo v : pessoaTde.getVeiculos()){
                   v.setPessoaTde(pessoaTde);
               }
           }
        return repository.save(pessoaTde);
    }

    public List<PessoaTde> buscarTodos(){
        return repository.findAll();
    }
    public Optional<PessoaTde> buscarId(Long id){
        return repository.findById(id);
    }

    public void deletarPessoaTde(Optional<PessoaTde>pessoaTde){
        repository.delete(pessoaTde.get());
    }

}
