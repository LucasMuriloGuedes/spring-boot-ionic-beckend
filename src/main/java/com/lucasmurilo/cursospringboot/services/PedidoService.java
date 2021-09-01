package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Pedido;
import com.lucasmurilo.cursospringboot.repositories.PedidoRepository;
import com.lucasmurilo.cursospringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public Pedido findById(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado: Id: " + id + ", tipo " + Pedido.class.getName()));
    }
}
