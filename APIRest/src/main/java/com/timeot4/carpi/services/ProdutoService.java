package com.timeot4.carpi.services;

import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
		 List<Produto> produtos = produtoRepository.findAll();
		 List produtosAtivos = new ArrayList();
		 produtos.forEach(produto -> {
		 		if (produto.getAtivo() == true) {
		 				produtosAtivos.add(produto);
				}
		 });
		 return produtosAtivos;
    }

    public Produto listaUm(@PathVariable(value = "id") String id) {
        Produto produto = produtoRepository.findById(id);
        Produto produtoAtivo = new Produto();
        if (produto.getAtivo() == true) {
						produtoAtivo = produto;
				}
        return produtoAtivo;
    }

//    public void deletaProduto(@PathVariable(value = "id") String id) {
//        produtoRepository.deleteById(id);
//    }
}
