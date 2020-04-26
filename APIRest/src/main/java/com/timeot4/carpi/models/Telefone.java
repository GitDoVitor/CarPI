package com.timeot4.carpi.models;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
    private Long telefonePrimario;
    private Long telefoneSecundario;

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public void setTelefonePrimario(Long telefonePrimario) {
        this.telefonePrimario = telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(Long telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "telefonePrimario=" + telefonePrimario +
                ", telefoneSecundario=" + telefoneSecundario +
                '}';
    }
}
