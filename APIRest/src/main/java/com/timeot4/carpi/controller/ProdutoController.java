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

    @ApiOperation(value = "Adiciona um novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto adicionado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produto = produtoService.salvar(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos listados com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listar();
    }

    @ApiOperation(value = "Lista um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto listado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}")
    public Produto listaUm(@PathVariable(value = "id") long id) {
        return produtoService.listaUm(id);
    }

    @ApiOperation(value = "Deleta um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void deletaUm(@PathVariable(value = "id") long id) {
        produtoService.deletaProduto(id);
    }

    @ApiOperation(value = "Edita um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto editado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public Produto editaProduto(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
}
