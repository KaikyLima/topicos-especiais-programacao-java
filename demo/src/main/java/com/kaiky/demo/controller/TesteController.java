package com.kaiky.demo.controller;

import com.kaiky.demo.model.ProdutoAula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")

public class TesteController {

    private final List<ProdutoAula> listaProdutoAula = new ArrayList<>();
    private ProdutoAula p;
    int id = 1;
    private Long codigo = Long.valueOf(1);  

    @GetMapping
    public ResponseEntity<List<ProdutoAula>> Listar(){
        return new ResponseEntity<List<ProdutoAula>>(this.listaProdutoAula, HttpStatus.OK);
    }

    @PostMapping

    public ResponseEntity<ProdutoAula> adicionar(@RequestBody ProdutoAula produtoAula) {
        p = new ProdutoAula();
        p.setCodigo(Long.valueOf(id++));
        p.setDescricao(produtoAula.getDescricao());
        p.setValor(produtoAula.getValor());

        listaProdutoAula.add(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoAula> atualizar(@RequestBody ProdutoAula produtoAula, @PathVariable int codigo) {
        ProdutoAula produtoAulaNovo = listaProdutoAula.get(codigo);
        produtoAulaNovo.setValor(produtoAula.getValor());
        produtoAulaNovo.setDescricao(produtoAula.getDescricao());
        return new ResponseEntity<>(produtoAula, HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
        public ResponseEntity<ProdutoAula> deletar(@PathVariable int codigo) {
            listaProdutoAula.remove(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
             }

        }


