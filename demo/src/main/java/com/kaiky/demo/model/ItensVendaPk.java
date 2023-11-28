package com.kaiky.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
@Embeddable
public class ItensVendaPk implements Serializable {
    @ManyToOne()
    @JoinColumn(name = "venda_id", referencedColumnName = "ID_VENDA")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties(value = {"itensVenda"})
    private Venda venda;
    @ManyToOne()
    @JoinColumn(name = "produto_id", referencedColumnName = "CODIGO")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties(value = {"classificacao","quantidade","valor","itensVendas"})
    private Produto produto;

    public ItensVendaPk() {
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
