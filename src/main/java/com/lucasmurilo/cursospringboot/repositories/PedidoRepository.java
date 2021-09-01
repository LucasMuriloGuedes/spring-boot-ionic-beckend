package com.lucasmurilo.cursospringboot.repositories;

import com.lucasmurilo.cursospringboot.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
