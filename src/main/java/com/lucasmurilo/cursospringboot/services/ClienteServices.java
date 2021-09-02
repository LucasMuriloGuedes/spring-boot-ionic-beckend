package com.lucasmurilo.cursospringboot.services;

import com.lucasmurilo.cursospringboot.domain.Categoria;
import com.lucasmurilo.cursospringboot.domain.Cliente;
import com.lucasmurilo.cursospringboot.domain.dto.ClienteDto;
import com.lucasmurilo.cursospringboot.repositories.ClienteRepository;
import com.lucasmurilo.cursospringboot.services.exception.DataIntegrityException;
import com.lucasmurilo.cursospringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        List<Cliente> list = repository.findAll();
        return list;
    }

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
    }

    public Cliente insert(Cliente cliente){
        cliente.setId(null);
        return repository.save(cliente);

    }

    public Cliente update(Cliente cliente){
        Cliente obj = findById(cliente.getId());
        updateData(obj, cliente);
        return repository.save(obj);
    }

    private void updateData(Cliente obj, Cliente cliente) {
        obj.setNome(cliente.getNome());
        obj.setEmail(obj.getEmail());
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir um cliente que tem pedidos!");
        }
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDto objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }


}
