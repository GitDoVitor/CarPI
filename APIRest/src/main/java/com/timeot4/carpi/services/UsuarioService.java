package com.timeot4.carpi.services;

import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listar() { return usuarioRepository.findAll(); }
    public void deletaUsuario(@PathVariable(value = "id") long id) { usuarioRepository.deleteById(id); }
}
