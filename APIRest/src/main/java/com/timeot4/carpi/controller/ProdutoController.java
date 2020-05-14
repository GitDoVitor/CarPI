package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

<<<<<<< HEAD
=======
    @ApiOperation(value = "Adiciona um novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto adicionado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
>>>>>>> stefanbranch
    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produto = produtoService.salvar(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    @ApiOperation(value = "Retorna uma lista de produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de produtos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(produces="application/json")
=======
    @ApiOperation(value = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos listados com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
>>>>>>> stefanbranch
    public List<Produto> listarTodos() {
        return produtoService.listar();
    }

<<<<<<< HEAD
    @ApiOperation(value = "Retorna um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um produto"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}", produces="application/json")
=======
    @ApiOperation(value = "Lista um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto listado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}")
>>>>>>> stefanbranch
    public Produto listaUm(@PathVariable(value = "id") long id) {
        return produtoService.listaUm(id);
    }

<<<<<<< HEAD
=======
    @ApiOperation(value = "Deleta um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
>>>>>>> stefanbranch
    @DeleteMapping("/{id}")
    public void deletaUm(@PathVariable(value = "id") long id) {
        produtoService.deletaProduto(id);
    }

<<<<<<< HEAD
=======
    @ApiOperation(value = "Edita um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto editado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
>>>>>>> stefanbranch
    @PutMapping("/{id}")
    public Produto editaProduto(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
}
