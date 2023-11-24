package com.kaiky.demo.controller;

import com.kaiky.demo.model.Endereco;
import com.kaiky.demo.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final List<Pessoa> listaPessoas = new ArrayList<>();
    private final List<Endereco> listaEndereco = new ArrayList<>();
    private Long idPessoa = Long.valueOf(1);
    private Long idEndereco = Long.valueOf(1);

    @PostMapping()
    public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody Pessoa pessoa) {
        pessoa.setId(idPessoa++);
        for (Endereco end : pessoa.getEnderecos()) {
            end.setId(idEndereco++);
        }
        pessoa.setEnderecos(pessoa.getEnderecos());
        listaPessoas.add(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @PostMapping("/endereco")
    public ResponseEntity<Endereco> adicinarEndereco(@RequestBody Endereco endereco, @RequestParam Long id) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getId().equals(id)) {
                endereco.setId(idEndereco++);
                pessoa.getEnderecos().add(endereco);
                return new ResponseEntity<>(endereco, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Pessoa>> listarPessoa() {
        return new ResponseEntity<>(this.listaPessoas, HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> consultarPorCpf(@PathVariable String cpf) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return new ResponseEntity<>(pessoa, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaPessoas.get(i).getId().equals(id)) {
                listaPessoas.set(i, pessoa);
                return new ResponseEntity<>(pessoa, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/endereco/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {
        for (Pessoa pessoa : listaPessoas) {
            for (Endereco enderecoPessoa : pessoa.getEnderecos()) {
                if (enderecoPessoa.getId().equals(id)) {
                    enderecoPessoa.setCep(endereco.getCep());
                    enderecoPessoa.setBairro(endereco.getBairro());
                    enderecoPessoa.setDdd(endereco.getDdd());
                    enderecoPessoa.setComplemento(endereco.getComplemento());
                    enderecoPessoa.setLocalidade(endereco.getLocalidade());
                    enderecoPessoa.setIbge(endereco.getIbge());
                    enderecoPessoa.setLogradouro(endereco.getLogradouro());
                    enderecoPessoa.setUf(endereco.getUf());
                    return new ResponseEntity<>(endereco, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getId().equals(id)) {
                listaPessoas.remove(pessoa);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
