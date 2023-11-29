package com.trabalho.demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplina_id")
    private com.trabalho.demo.model.Disciplina disciplina;
    private Double nota;



    public Nota() {
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
