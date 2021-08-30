package com.lucasmurilo.cursospringboot.resources;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import com.lucasmurilo.cursospringboot.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {


    @Autowired
    private CategoriaServices services;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria cat = services.findById(id);
        return ResponseEntity.ok().body(cat);
    }
    
}
