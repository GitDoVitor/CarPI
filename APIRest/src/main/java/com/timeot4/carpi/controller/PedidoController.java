package com.timeot4.carpi.controller;

import com.timeot4.carpi.models.Pedido;
import com.timeot4.carpi.services.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @ApiOperation(value = "Adiciona um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedido adicionado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
        String uniqueID = UUID.randomUUID().toString();
        pedido.setId(uniqueID);
        pedido = pedidoService.salvar(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Lista todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedidos listados com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listar();
    }

    @ApiOperation(value = "Lista um pedido pelo id")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Pedido listado com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@GetMapping("/{id}")
		public Pedido listaUm(@PathVariable(value = "id") String id) {
				return pedidoService.listaUm(id);
		}

		@ApiOperation(value = "Deleta um pedido pelo id")
		@ApiResponses(value = {
						@ApiResponse(code = 200, message = "Pedido deletado com sucesso"),
						@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
						@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
		@PutMapping("/{id}")
		public void deletaUm(@PathVariable(value = "id") String id) {
				Pedido pedido = pedidoService.listaUm(id);
				pedido.setEstado(Pedido.Estado.CANCELADO);
				pedidoService.salvar(pedido);
		}
}
