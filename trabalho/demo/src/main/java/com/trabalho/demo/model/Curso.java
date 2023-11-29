package com.trabalho.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCurso;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<com.trabalho.demo.model.Disciplina> disciplinas = new ArrayList<>();

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<com.trabalho.demo.model.Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<com.trabalho.demo.model.Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
