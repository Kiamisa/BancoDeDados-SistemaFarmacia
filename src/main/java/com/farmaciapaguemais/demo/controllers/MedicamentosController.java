package com.farmaciapaguemais.demo.controllers;


import com.farmaciapaguemais.demo.entities.Medicamentos;
import com.farmaciapaguemais.demo.repositories.MedicamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/medicamentos"})
public class MedicamentosController {
    private MedicamentoRepository medicamentoRepository;

    MedicamentosController(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @GetMapping
    public List findAll(){
        return medicamentoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return medicamentoRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicamentos create(@RequestBody Medicamentos medicamento){
        return medicamentoRepository.save(medicamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") long id, @RequestBody Medicamentos medicamento){
        return medicamentoRepository.findById(id)
                .map(record ->{
                    record.setNome(medicamento.getNome());
                    record.setNome(medicamento.getDescricao());
                    record.setFabricacao(medicamento.getFabricacao());
                    record.setFabricante(medicamento.getFabricante());
                    record.setFabricante(medicamento.getFabricante());
                    record.setEstoque(medicamento.getEstoque());
                    record.setPreco(medicamento.getPreco());
                    Medicamentos updated = medicamentoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return medicamentoRepository.findById(id)
                .map(record ->{
                    medicamentoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
