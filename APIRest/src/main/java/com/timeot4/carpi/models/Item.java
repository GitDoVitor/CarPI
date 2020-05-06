package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Itens")
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Produto> produto = new ArrayList<>();
    private Integer qtdProdutos;
    private double preco;
    private String observacao;


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
