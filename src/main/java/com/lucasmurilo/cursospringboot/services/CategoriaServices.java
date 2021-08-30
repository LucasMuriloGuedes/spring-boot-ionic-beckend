package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import com.lucasmurilo.cursospringboot.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        List<Categoria> list = repository.findAll();
        return list;
    }

    public Categoria findById(Integer id){
        Optional<Categoria> cat = repository.findById(id);
        return cat.orElse(null);
    }
}
