package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;

public class UsuarioDTO {

    private String nome;
    private String email;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
    private Boolean adm;

    public Usuario transformaParaObjeto(){
        return new Usuario(nome, email, endereco, telefone, cpf, adm);
    }
}
