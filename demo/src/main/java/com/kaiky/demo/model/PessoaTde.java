package com.kaiky.demo.model;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pessoaTde")
public class PessoaTde implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String nome;
    private String cpf;
    private String sexo;

    @OneToMany(mappedBy = "pessoaTde")
    @Cascade(CascadeType.ALL)
    private List<Veiculo> veiculos;

    public PessoaTde() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
