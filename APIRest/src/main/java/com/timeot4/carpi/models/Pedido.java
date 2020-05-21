package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private double preco;
    private LocalDate data;
    private String metodoPagamento;
    private Boolean entrega;
    private enum Estado {
        ATIVO,
        PREPARANDO,
        PRONTO,
        CANCELADO,
        FINALIZADO
    }
    @OneToMany
    private Set<Item> item = new HashSet<Item>();

}
