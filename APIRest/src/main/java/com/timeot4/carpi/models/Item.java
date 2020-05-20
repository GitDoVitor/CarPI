package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Itens")
@Getter
public class Item {
    @Id
    private Long id;
    @OneToMany
    private Set<Produto> produto = new HashSet<Produto>();
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
