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
    private Boolean ativo;

    public Produto(String nome, String descricao, double preco, String urlFoto, Boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.urlFoto = urlFoto;
        this.ativo = ativo;
    }

}
