package com.lucasmurilo.cursospringboot.repositories;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
