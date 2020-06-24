package com.timeot4.carpi.controller;

import com.timeot4.carpi.dto.ProdutoCardapioDTO;
import com.timeot4.carpi.dto.ProdutoDTO;
import com.timeot4.carpi.dto.ProdutoRespostaDTO;
import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<ProdutoRespostaDTO> salvar(@RequestBody ProdutoDTO dto) {
        Produto produto = dto.transformaObjeto();
        String uniqueID = UUID.randomUUID().toString();
        produto.setId(uniqueID);
        produto = produtoService.salvar(produto);
        return new ResponseEntity<>(ProdutoRespostaDTO.transformaEmDTO(produto), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos listados com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<ProdutoCardapioDTO>> listarTodos() {
        List<Produto> produtosList = produtoService.listar();
        List<ProdutoCardapioDTO> produtoDTOList = new ArrayList<>();
        produtosList.forEach(produto -> {
						System.out.println(produto);
        		produtoDTOList.add(ProdutoCardapioDTO.transformaProduto(produto));
				});
        return new ResponseEntity<>(produtoDTOList, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto listado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}")
    public Produto listaUm(@PathVariable(value = "id") String id) {
        return produtoService.listaUm(id);
    }

    @ApiOperation(value = "Desativa um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto desativado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public void voceFoiCanceladah(@PathVariable(value = "id") String id) {
				Produto produto = produtoService.listaUm(id);
				produto.setAtivo(false);
				produtoService.salvar(produto);
    }

    //todo
//    @ApiOperation(value = "Edita um produto pelo id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Produto editado com sucesso"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
//    })
//    @PutMapping("/{id}")
//    public Produto editaProduto(@RequestBody Produto produto) {
//        return produtoService.salvar(produto);
//    }
}
