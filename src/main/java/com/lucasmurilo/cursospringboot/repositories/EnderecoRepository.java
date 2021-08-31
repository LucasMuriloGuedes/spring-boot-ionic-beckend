package com.lucasmurilo.cursospringboot.repositories;

import com.lucasmurilo.cursospringboot.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
