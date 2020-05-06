package com.timeot4.carpi.controller;


import com.timeot4.carpi.dto.UsuarioDTO;
import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    public final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO dto) {
         Usuario usuario = usuarioService.salvar(dto.transformaObjeto());
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(produces="application/json")
    public List<Usuario> listarTodos() {
        return usuarioService.listar();
    }

    @ApiOperation(value = "Retorna um Usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um usuário"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public Usuario listaUm(@PathVariable(value = "id") long id) {
        return usuarioService.listaUm(id);
    }

    @DeleteMapping(value = "/{id}", consumes="application/json")
    public void deletaUm(@PathVariable(value = "id") long id) {
        usuarioService.deletaUsuario(id);
    }

    @PutMapping(value = "/{id}", produces="application/json", consumes = "application/json")
    public Usuario editaUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }
}
