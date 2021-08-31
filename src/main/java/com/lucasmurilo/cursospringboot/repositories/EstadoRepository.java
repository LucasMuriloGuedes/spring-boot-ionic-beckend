package com.lucasmurilo.cursospringboot.repositories;

import com.lucasmurilo.cursospringboot.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
