package com.timeot4.carpi.services;

import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return produtoRepository.findAll();
    }

    public Produto listaUm(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    public void deletaProduto(@PathVariable(value = "id") long id) {
        produtoRepository.deleteById(id);
    }
}
