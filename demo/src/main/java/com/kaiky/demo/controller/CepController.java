package com.kaiky.demo.controller;

import com.kaiky.demo.dto.CepDto;
import com.kaiky.demo.facede.CepFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

    @Autowired
    private CepFacede cepFacede;

    @GetMapping(value = "/{cep}")
    public CepDto buscaCep(@PathVariable String cep){
        return cepFacede.buscaCep(cep);
    }
}
