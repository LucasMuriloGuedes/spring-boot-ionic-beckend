package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Produto;
import com.lucasmurilo.cursospringboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        List<Produto> list = repository.findAll();
        return list;
    }

    public Produto findById(Integer id){
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }
}
