package com.timeot4.carpi.repository;

import com.timeot4.carpi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findById(long id);
}
