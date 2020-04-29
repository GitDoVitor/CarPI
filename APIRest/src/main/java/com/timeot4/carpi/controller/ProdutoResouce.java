package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carburguer")
public class ProdutoResouce {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/novoprodutos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }
}
