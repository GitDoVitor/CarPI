package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Produto;
import lombok.Getter;

@Getter
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private double preco;
    private String urlFoto;
    private Boolean ativo = true;

		public Produto transformaObjeto() {
        return new Produto(nome, descricao, preco, urlFoto, ativo);
    }


}
