package com.timeot4.carpi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Produto> produto = new ArrayList<>();
    private Integer qtdProdutos;
    private double preco;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Integer getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(Integer qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", produto=" + produto +
                ", qtdProdutos=" + qtdProdutos +
                ", preco=" + preco +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
