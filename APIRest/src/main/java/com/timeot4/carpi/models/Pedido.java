package com.timeot4.carpi.models;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Pedidos")
@Getter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    private double preco;
    private LocalDate data;
    private String metodoPagamento;
    private Boolean entrega;
    @OneToMany
    private List<Item> item = new ArrayList<>();

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
