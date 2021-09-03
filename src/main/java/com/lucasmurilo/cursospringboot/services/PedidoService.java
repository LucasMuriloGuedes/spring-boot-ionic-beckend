package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.*;
import com.lucasmurilo.cursospringboot.domain.emuns.EstadoPagamento;
import com.lucasmurilo.cursospringboot.repositories.CategoriaRepository;
import com.lucasmurilo.cursospringboot.repositories.PagamentoRepository;
import com.lucasmurilo.cursospringboot.repositories.PedidoRepository;
import com.lucasmurilo.cursospringboot.repositories.ProdutoRepository;
import com.lucasmurilo.cursospringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private BoletoService boletoService;

    public List<Pedido> findAll(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public Pedido findById(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado: Id: " + id + ", tipo " + Pedido.class.getName()));
    }

    public Pedido insert(Pedido pedido) {
        pedido.setId(null);
        pedido.setData(new Date());
        pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);
        if(pedido.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pgto = (PagamentoComBoleto) pedido.getPagamento();
            boletoService.preencherPagamentoComBoleto(pgto, pedido.getData());
         }
        pedido = pedidoRepository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());
        return pedido;
    }
}
