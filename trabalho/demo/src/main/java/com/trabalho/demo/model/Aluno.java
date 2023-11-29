package com.trabalho.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String sexo;
    @OneToMany(mappedBy = "aluno", fetch =FetchType.LAZY)
    private List<AlunoHasCurso> alunosCursos = new ArrayList<>();
    @OneToMany(mappedBy = "nota", fetch =FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AlunoHasCurso> getAlunosCursos() {
        return alunosCursos;
    }

    public void setCursos(List<AlunoHasCurso> alunosCursos) {
        this.alunosCursos = alunosCursos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
