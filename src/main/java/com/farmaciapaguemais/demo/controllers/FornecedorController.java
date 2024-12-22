package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.Fornecedor;
import com.farmaciapaguemais.demo.repositories.FornecedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/fornecedor"})
public class FornecedorController {

    private FornecedorRepository fornecedorRepository;

    FornecedorController(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping
    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return fornecedorRepository.findById(Long.valueOf(id))
                .map(record->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        return fornecedorRepository.findById(Long.valueOf(id))
                .map(record ->{
                    record.setNome(fornecedor.getNome());
                    record.setTelefone(fornecedor.getTelefone());
                    record.setEmail(fornecedor.getEmail());
                    record.setEndereco(fornecedor.getEndereco());
                    record.setComplemento(fornecedor.getComplemento());
                    record.setBairro(fornecedor.getBairro());
                    record.setNumero(fornecedor.getNumero());
                    record.setCnpj(fornecedor.getCnpj());

                    Fornecedor atualizado = fornecedorRepository.save(record);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity delete(@PathVariable Long id){
        return fornecedorRepository.findById(Long.valueOf(id))
                .map(record->{
                    fornecedorRepository.deleteById(Long.valueOf(id));
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
