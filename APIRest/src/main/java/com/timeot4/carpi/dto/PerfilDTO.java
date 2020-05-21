package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PerfilDTO {
    private String nome;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
    
    public static PerfilDTO transformaPerfil(Usuario usuario) {
        return new PerfilDTO(usuario.getNome(), usuario.getEmail(), usuario.getEndereco(), usuario.getTelefone(), usuario.getCpf());
    }

}
