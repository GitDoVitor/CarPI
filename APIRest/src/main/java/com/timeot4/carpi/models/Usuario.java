package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private Telefone telefone;
    private String cpf;
<<<<<<< HEAD
    private Boolean adm;
=======
    private Boolean adm = false;
>>>>>>> stefanbranch

    public Usuario(String nome, String email, String senha, Endereco endereco, Telefone telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

<<<<<<< HEAD
    public Usuario(String nome, String email, Endereco endereco, Telefone telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

=======
>>>>>>> stefanbranch
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", adm=" + adm +
                '}';
    }
}
