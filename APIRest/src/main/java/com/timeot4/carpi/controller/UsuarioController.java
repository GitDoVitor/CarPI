package com.timeot4.carpi.controller;


import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.repository.UsuarioRepository;
import com.timeot4.carpi.services.UsuarioService;
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

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
         usuario = usuarioService.salvar(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listar();
    }

}
