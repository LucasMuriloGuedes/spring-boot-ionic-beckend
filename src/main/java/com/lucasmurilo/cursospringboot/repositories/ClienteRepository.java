package com.lucasmurilo.cursospringboot.repositories;

import com.lucasmurilo.cursospringboot.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
