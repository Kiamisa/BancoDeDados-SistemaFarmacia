package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.Fornecedor;
import com.farmaciapaguemais.demo.entities.Fornecimento;
import com.farmaciapaguemais.demo.repositories.FornecedorRepository;
import com.farmaciapaguemais.demo.repositories.FornecimentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/fornecimento"})
public class FornecimentoController {

    private final FornecimentoRepository fornecimentoRepository;

    FornecimentoController(FornecimentoRepository fornecimentoRepository) {
        this.fornecimentoRepository = fornecimentoRepository;
    }

    @GetMapping
    public List<Fornecimento> findAll() {
        return fornecimentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecimento> findById(@PathVariable Long id){
        Optional<Fornecimento> fornecimento = fornecimentoRepository.findById(id);
        return fornecimento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fornecimento create(@RequestBody Fornecimento fornecimento){
        return fornecimentoRepository.save(fornecimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecimento> upadate(@PathVariable Long id, @RequestBody Fornecimento fornecimento){
        return fornecimentoRepository.findById(id)
                .map(record -> {
                    record.setDataFornecimento(fornecimento.getDataFornecimento());
                    record.setQuantidade(fornecimento.getQuantidade());
                    record.setValorTotal(fornecimento.getValorTotal());
                    record.setFabricacao(fornecimento.getFabricacao());
                    record.setVencimento(fornecimento.getVencimento());
                    record.setFornecedor(fornecimento.getFornecedor());
                    record.setMedicamento(fornecimento.getMedicamento());
                    Fornecimento atualizado = fornecimentoRepository.save(record);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return fornecimentoRepository.findById(id)
                .map( record -> {
                    fornecimentoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
