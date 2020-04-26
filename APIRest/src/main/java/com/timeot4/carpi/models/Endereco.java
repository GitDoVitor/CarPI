package com.timeot4.carpi.models;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private String bairro;
    private String CEP;
    private Long numeroDaCasa;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Long getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(Long numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }
}
