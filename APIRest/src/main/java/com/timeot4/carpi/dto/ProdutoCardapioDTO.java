package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProdutoCardapioDTO {
		private String nome;
		private String descricao;
		private double preco;
		private String urlFoto;

		public static ProdutoCardapioDTO transformaProduto(Produto produto) {
				return new ProdutoCardapioDTO(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getUrlFoto());
		}
}
