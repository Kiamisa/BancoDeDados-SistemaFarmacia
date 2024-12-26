package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.ItemVenda;
import com.farmaciapaguemais.demo.repositories.ItemVendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/item_venda"})
public class ItemVendaController {
    private ItemVendaRepository itemVendaRepository;

    ItemVendaController(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    @GetMapping
    public List findAll(){
        return itemVendaRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return itemVendaRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ItemVenda create(@RequestBody ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") long id, @RequestBody ItemVenda itemVenda){
        return itemVendaRepository.findById(id)
                .map(record ->{
                    record.setQuantidade(itemVenda.getQuantidade());
                    record.setPrecoUnitario(itemVenda.getPrecoUnitario());
                    record.setQuantidade(itemVenda.getQuantidade());
                    record.setVenda(itemVenda.getVenda());
                    record.setMedicamento(itemVenda.getMedicamento());
                    ItemVenda updated = itemVendaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return itemVendaRepository.findById(id)
                .map(record ->{
                    itemVendaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
