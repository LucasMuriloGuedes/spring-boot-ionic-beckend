package com.lucasmurilo.cursospringboot.resources;


import com.lucasmurilo.cursospringboot.domain.Produto;
import com.lucasmurilo.cursospringboot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = produtoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> findByid(@PathVariable Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return ResponseEntity.ok().body(produto);

    }
}
