package com.farmaciapaguemais.demo.controllers;


import com.farmaciapaguemais.demo.entities.Vendas;
import com.farmaciapaguemais.demo.repositories.VendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/vendas"})
public class VendasController {
    private VendaRepository vendaRepository;

    VendasController(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @GetMapping
    public List findAll(){
        return vendaRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return vendaRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vendas create(@RequestBody Vendas vendas){
        return vendaRepository.save(vendas);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") long id, @RequestBody Vendas vendas){
        return vendaRepository.findById(id)
                .map(record ->{
                    record.setDataVenda(vendas.getDataVenda());
                    record.setValorTotal(vendas.getValorTotal());
                    record.setCliente(vendas.getCliente());
                    record.setFuncionario(vendas.getFuncionario());
                    Vendas updated = vendaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return vendaRepository.findById(id)
                .map(record ->{
                    vendaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
