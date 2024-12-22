package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.Clientes;
import com.farmaciapaguemais.demo.repositories.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clientes"})
public class ClientesController {

    private ClienteRepository clienteRepository;

    ClientesController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id){
        return clienteRepository.findById(Long.valueOf(id))
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clientes create(@RequestBody Clientes cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Clientes cliente){
        return clienteRepository.findById(Long.valueOf(id))
                .map(record -> {
                    record.setNome(cliente.getNome());
                    record.setEndereco(cliente.getEndereco());
                    record.setComplemento(cliente.getComplemento());
                    record.setBairro(cliente.getBairro());
                    record.setNumero(cliente.getNumero());
                    record.setTelefone1(cliente.getTelefone1());
                    record.setTelefone2(cliente.getTelefone2());
                    record.setCpf(cliente.getCpf());
                    record.setEmail(cliente.getEmail());
                    record.setDataNascimento(cliente.getDataNascimento());
                    record.setNomePai(cliente.getNomePai());
                    record.setNomeMae(cliente.getNomeMae());

                    Clientes atualizado = clienteRepository.save(record);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity delete(@PathVariable Integer id){
        return clienteRepository.findById(Long.valueOf(id))
                .map(record -> {
                    clienteRepository.deleteById(Long.valueOf(id));
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
