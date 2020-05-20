package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "Produtos")
@Getter
@Setter
public class Produto {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private String urlFoto;

    public Produto(String nome, String descricao, double preco, String urlFoto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
