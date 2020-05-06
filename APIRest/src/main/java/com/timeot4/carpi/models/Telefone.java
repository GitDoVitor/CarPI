package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Telefone {
    private Long telefonePrimario;
    private Long telefoneSecundario;

    @Override
    public String toString() {
        return "Telefone{" +
                "telefonePrimario=" + telefonePrimario +
                ", telefoneSecundario=" + telefoneSecundario +
                '}';
    }
}
