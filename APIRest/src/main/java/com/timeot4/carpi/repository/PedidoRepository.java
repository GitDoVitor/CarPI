package com.timeot4.carpi.repository;

import com.timeot4.carpi.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findById(String id);
}
