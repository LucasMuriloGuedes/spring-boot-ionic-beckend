package com.lucasmurilo.cursospringboot.domain.dto;

import com.lucasmurilo.cursospringboot.domain.Categoria;

import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private Integer id;
    private String nome;

    public CategoriaDto(){

    }

    public CategoriaDto(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
