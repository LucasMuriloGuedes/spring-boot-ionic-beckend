package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import com.lucasmurilo.cursospringboot.domain.Pedido;
import com.lucasmurilo.cursospringboot.domain.Produto;
import com.lucasmurilo.cursospringboot.repositories.CategoriaRepository;
import com.lucasmurilo.cursospringboot.repositories.PedidoRepository;
import com.lucasmurilo.cursospringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

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
