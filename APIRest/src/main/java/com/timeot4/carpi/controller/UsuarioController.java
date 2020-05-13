package com.timeot4.carpi.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.timeot4.carpi.dto.PerfilDTO;
import com.timeot4.carpi.dto.UsuarioDTO;
import com.timeot4.carpi.dto.UsuarioRespostaDTO;
import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    public final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO dto) {
        Usuario usuarioTeste = dto.transformaObjeto();
        String senha = usuarioTeste.getSenha();
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        usuarioTeste.setSenha(bcryptHashString);
        usuarioTeste = usuarioService.salvar(usuarioTeste);
        return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuarioTeste), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(produces="application/json")
    public List<Usuario> listarTodos() {
//        List<Usuario> usuario = new ArrayList<>();
//        usuario = usuarioService.listar();
//        return PerfilDTO.transformaPerfil(usuario);
        return usuarioService.listar();
    }

    @ApiOperation(value = "Lista um usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário listado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public PerfilDTO mostraPerfil(@PathVariable(value = "id") long id) {
        Usuario usuario = usuarioService.listaUm(id);
        return PerfilDTO.transformaPerfil(usuario);
    }

    // TODO: 13/05/2020
    @GetMapping(value = "{id}/logar")
    public void verificaSenha(@PathVariable(value = "id") long id) {
        Scanner entrada = new Scanner(System.in);
        Usuario usuario = usuarioService.listaUm(id);
        String bcryptHashString = usuario.getSenha();
        System.out.println("Digite a Senha:");
        String senhaTop = entrada.nextLine();
        BCrypt.Result result = BCrypt.verifyer().verify(senhaTop.toCharArray(), bcryptHashString);
        System.out.println(result);
    }

    @ApiOperation(value = "Deleta usuário pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(value = "/{id}", consumes="application/json")
    public void deletaUm(@PathVariable(value = "id") long id) {
        usuarioService.deletaUsuario(id);
    }

    @ApiOperation(value = "Edita usuário pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário editado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(value = "/{id}", produces="application/json", consumes = "application/json")
    public Usuario editaUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }
}
