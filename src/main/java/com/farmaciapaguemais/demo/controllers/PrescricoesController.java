package com.farmaciapaguemais.demo.controllers;


import com.farmaciapaguemais.demo.entities.Prescricoes;
import com.farmaciapaguemais.demo.repositories.PrescricaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/prescricoes"})
public class PrescricoesController {
    private PrescricaoRepository prescricaoRepository;

    PrescricoesController(PrescricaoRepository prescricaoRepository) {
        this.prescricaoRepository = prescricaoRepository;
    }

    @GetMapping
    public List findAll(){
        return prescricaoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return prescricaoRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prescricoes create(@RequestBody Prescricoes prescricoes){
        return prescricaoRepository.save(prescricoes);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") long id, @RequestBody Prescricoes prescricoes){
        return prescricaoRepository.findById(id)
                .map(record ->{
                    record.setCliente(prescricoes.getCliente());
                    record.setDataPrescricao(prescricoes.getDataPrescricao());
                    record.setDescricao(prescricoes.getDescricao());
                    record.setMedicamento(prescricoes.getMedicamento());
                    Prescricoes updated = prescricaoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return prescricaoRepository.findById(id)
                .map(record ->{
                    prescricaoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
