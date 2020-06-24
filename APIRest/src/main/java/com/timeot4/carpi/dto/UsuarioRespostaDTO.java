package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioRespostaDTO {
    private String id;
    private String nome;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
    private Boolean adm;
    private Boolean ativo;

    public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getEndereco(), usuario.getTelefone(), usuario.getCpf(), usuario.getAdm(), usuario.getAtivo());
    }
}
