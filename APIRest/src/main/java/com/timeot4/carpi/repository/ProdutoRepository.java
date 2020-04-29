package com.timeot4.carpi.repository;

import com.timeot4.carpi.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
