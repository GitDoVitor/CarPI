package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDTO {
    private long id;
    private String nome;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
    private Boolean adm;

    public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getEndereco(), usuario.getTelefone(), usuario.getCpf(), usuario.isAdm());
    }
}
