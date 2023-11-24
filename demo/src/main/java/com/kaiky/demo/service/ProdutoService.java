package com.kaiky.demo.service;

import com.kaiky.demo.model.PessoaTde;
import com.kaiky.demo.model.Produto;
import com.kaiky.demo.repository.ProdutoRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository respository;

    public List<Produto> buscarTodos(){
        return respository.findAll();
    }
    public Optional<Produto> buscarId(Long id){
        return respository.findById(id);
    }

}
