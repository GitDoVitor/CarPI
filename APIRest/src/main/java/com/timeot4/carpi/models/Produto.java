package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Produtos")
@Getter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String urlFoto;

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
