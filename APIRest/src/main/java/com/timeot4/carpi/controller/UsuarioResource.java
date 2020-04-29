package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/carburguer")
public class UsuarioResource {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario salvaUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void deletaUsuario(@PathVariable(value = "id") long id) { usuarioRepository.deleteById(id); }

    @PutMapping("/usuario")
    public Usuario editaUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
