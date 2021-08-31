package com.lucasmurilo.cursospringboot.config;

import com.lucasmurilo.cursospringboot.domain.*;
import com.lucasmurilo.cursospringboot.domain.emuns.TipoCliente;
import com.lucasmurilo.cursospringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "impressora", 800.00);
        Produto p3 = new Produto(null, "mouse", 80.00);

        p1.getCategoria().add(cat1);
        p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
        p3.getCategoria().add(cat1);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Sao Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Sao Paulo", est2);

        est1.getCidades().add(c1);
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));

        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));


        Cliente cli1 = new Cliente(null, "Maria Silvia", "maria@gmail.com", "32455255254", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("1198989555", "11545454545"));
        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "388844848", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));


        clienteRepository.saveAll(Arrays.asList(cli1));

        enderecoRepository.saveAll(Arrays.asList(e1, e2));



    }
}
