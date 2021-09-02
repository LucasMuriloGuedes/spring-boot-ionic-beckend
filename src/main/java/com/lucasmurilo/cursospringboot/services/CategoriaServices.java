package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import com.lucasmurilo.cursospringboot.domain.dto.CategoriaDto;
import com.lucasmurilo.cursospringboot.repositories.CategoriaRepository;
import com.lucasmurilo.cursospringboot.services.exception.DataIntegrityException;
import com.lucasmurilo.cursospringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return cat.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria categoria = findById(obj.getId());
        updateData(categoria, obj);
        return repository.save(categoria);
    }

    private void updateData(Categoria categoria, Categoria obj) {
        categoria.setNome(obj.getNome());
    }

    public void delete(Integer id){
        findById(id);
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos!");
        }
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDto objDTO){
        return new Categoria(objDTO.getId(), objDTO.getNome());
    }
}
