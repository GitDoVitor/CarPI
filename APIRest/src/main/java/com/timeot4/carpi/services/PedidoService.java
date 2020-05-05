package com.timeot4.carpi.services;

import com.timeot4.carpi.models.Pedido;
import com.timeot4.carpi.models.Produto;
import com.timeot4.carpi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) { this.pedidoRepository = pedidoRepository;}

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido listaUm(@PathVariable(value = "id") long id) {
        return pedidoRepository.findById(id);
    }

    public void deletaPedido(@PathVariable(value = "id") long id) {
        pedidoRepository.deleteById(id);
    }



}
