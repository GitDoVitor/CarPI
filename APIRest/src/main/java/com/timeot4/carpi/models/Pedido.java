package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Pedidos")
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private double preco;
    private LocalDate data;
    private String metodoPagamento;
    private Boolean entrega;
    @OneToMany
    private Set<Item> item = new HashSet<Item>();

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", preco=" + preco +
                ", data=" + data +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", entrega=" + entrega +
                ", item=" + item +
                '}';
    }
}
