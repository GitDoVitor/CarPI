package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Usuarios")
public class Usuario {

		private enum Role {USER, ADMIN, USER_MANAGER}

		@Id
		private String id;
		private String nome;
		@Email
		@NotEmpty
		private String email;
		private String senha;
		private Endereco endereco;
		private Telefone telefone;
		@CPF
		private String cpf;
		private Boolean ativo;
		private Boolean adm = false;
		private Role role = Role.USER;

		public Usuario(String nome, String email, String senha, Endereco endereco, Telefone telefone, String cpf, Boolean ativo) {
				this.nome = nome;
				this.email = email;
				this.senha = senha;
				this.endereco = endereco;
				this.telefone = telefone;
				this.cpf = cpf;
				this.ativo = ativo;
		}

}
