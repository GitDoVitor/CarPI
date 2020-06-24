package com.timeot4.carpi.dto;

import com.timeot4.carpi.models.Endereco;
import com.timeot4.carpi.models.Telefone;
import com.timeot4.carpi.models.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
		private Boolean ativo = true;

    public Usuario transformaObjeto() {
				return new Usuario(nome, email, senha, endereco, telefone, cpf, ativo);
    }


}
