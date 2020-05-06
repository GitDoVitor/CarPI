package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Endereco {
    private String rua;
    private String bairro;
    private String CEP;
    private Long numeroDaCasa;

}
