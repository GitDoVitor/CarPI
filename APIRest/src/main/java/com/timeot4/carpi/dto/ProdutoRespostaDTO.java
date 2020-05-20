package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Produto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProdutoRespostaDTO {
    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private String urlFoto;

    public static ProdutoRespostaDTO transformaEmDTO(Produto produto) {
        return new ProdutoRespostaDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getUrlFoto());
    }
}
