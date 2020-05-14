package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;
import lombok.Getter;
import lombok.Setter;

// DTO DE CRIAÇÃO DE PERFIL
@Getter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;

    public Usuario transformaObjeto() {
        return new Usuario(nome, email, senha, endereco, telefone, cpf);
    }


}
