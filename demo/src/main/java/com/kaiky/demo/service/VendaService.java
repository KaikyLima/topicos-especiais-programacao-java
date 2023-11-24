package com.kaiky.demo.service;

import com.kaiky.demo.model.Venda;
import com.kaiky.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;

    public List<Venda> listaVenda(){
        return repository.findAll();
    }

}
