package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.Fornecedor;
import com.farmaciapaguemais.demo.entities.Fornecimento;
import com.farmaciapaguemais.demo.repositories.FornecedorRepository;
import com.farmaciapaguemais.demo.repositories.FornecimentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/fornecedores"})
public class FornecedorController {

    private final FornecimentoRepository fornecimentoRepository;
    private final FornecedorRepository fornecedorRepository;

    FornecedorController(FornecedorRepository fornecedorRepository, FornecimentoRepository fornecimentoRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecimentoRepository = fornecimentoRepository;
    }

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id) {
        return fornecedorRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/fornecimentos")
    public List<Fornecimento> getFornecimentosByFornecedor(@PathVariable Long id) {
        return fornecimentoRepository.findByFornecedorId(id);
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.findById(id)
                .map(record -> {
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFornecedor(@PathVariable Long id) {
        if (fornecimentoRepository.existsByFornecedorId(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Fornecedor Possui Fornecimentos Associados e Não Pode Ser Excluído.");
        }

        return fornecedorRepository.findById(id)
                .map(record -> {
                    fornecedorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
