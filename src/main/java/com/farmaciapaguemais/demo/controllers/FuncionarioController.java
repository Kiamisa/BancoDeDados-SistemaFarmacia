package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.Funcionario;
import com.farmaciapaguemais.demo.repositories.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/funcionarios"})
public class FuncionarioController {
    private FuncionarioRepository funcionarioRepository;

    FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List findAll(){
        return funcionarioRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return funcionarioRepository.findById(id)
                .map(record ->
                        ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") Long id, @RequestBody Funcionario funcionario){
        return funcionarioRepository.findById(id)
                .map(record ->{
                    record.setNome(funcionario.getNome());
                    record.setCargo(funcionario.getCargo());
                    record.setSalario(funcionario.getSalario());
                    record.setDataAdmissao(funcionario.getDataAdmissao());
                    record.setQuantidadeVendas(funcionario.getQuantidadeVendas());
                    Funcionario updated = funcionarioRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        return funcionarioRepository.findById(id)
                .map(record ->{
                    funcionarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
        })
                .orElse(ResponseEntity.notFound().build());
    }


}
