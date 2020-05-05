package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produto = produtoService.salvar(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto listaUm(@PathVariable(value = "id") long id) {
        return produtoService.listaUm(id);
    }

    @DeleteMapping("/{id}")
    public void deletaUm(@PathVariable(value = "id") long id) {
        produtoService.deletaProduto(id);
    }

    @PutMapping("/{id}")
    public Produto editaProduto(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
}
