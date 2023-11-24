package com.kaiky.demo.facede;

import com.kaiky.demo.dto.CepDto;
import com.kaiky.demo.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CepFacede {

    @Autowired
    CepService service;

    public CepDto buscaCep(String cep){
        return service.buscaCep(cep);
    }
}
