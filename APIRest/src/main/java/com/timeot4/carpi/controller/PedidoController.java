package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Pedido;
import com.timeot4.carpi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        pedido = pedidoService.salvar(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido listaUm(@PathVariable(value = "id") long id) {
        return pedidoService.listaUm(id);
    }

    @DeleteMapping("/{id}")
    public void deletaUm(@PathVariable(value = "id") long id) {
        pedidoService.deletaPedido(id);
    }
}
