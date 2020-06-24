package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Itens")
@Getter
@Setter
public class Item {
		@Id
		private String id;
		@OneToMany
		private Set<Produto> produto = new HashSet<Produto>();
		private Long qtdProdutos;
		private double preco;
    private String observacao;
}
