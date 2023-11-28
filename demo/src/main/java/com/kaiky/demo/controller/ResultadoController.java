package com.kaiky.demo.controller;

import com.kaiky.demo.model.Aluno;
import com.kaiky.demo.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping("/{alunoId}")
    public ResponseEntity<String> obterNotas (@PathVariable Long alunoId){
        String resultado = resultadoService.resultadoStatus(alunoId);
        return ResponseEntity.ok(resultado);
    }
}
