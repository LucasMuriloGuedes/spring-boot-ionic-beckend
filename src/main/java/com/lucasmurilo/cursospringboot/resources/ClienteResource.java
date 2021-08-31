package com.lucasmurilo.cursospringboot.resources;


import ch.qos.logback.core.net.server.Client;
import com.lucasmurilo.cursospringboot.domain.Cliente;
import com.lucasmurilo.cursospringboot.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteServices services;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = services.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
}
