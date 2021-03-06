package com.timeot4.carpi.services;

import com.timeot4.carpi.models.Usuario;
import com.timeot4.carpi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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

    public List<Usuario> listar() {
				List<Usuario> usuarios = usuarioRepository.findAll();
				List usuariosAtivos = new ArrayList();
				usuarios.forEach(usuario -> {
						if (usuario.getAtivo() == true) {
								usuariosAtivos.add(usuario);
						}
				});
				return usuariosAtivos;
		}

		public Usuario listaUm(@PathVariable(value = "id") String id) {
				Usuario usuario = usuarioRepository.findById(id);
				Usuario usuarioAtivo = new Usuario();
				if (usuario.getAtivo() == true) {
						usuarioAtivo = usuario;
				}
				return usuarioAtivo;
		}

}
