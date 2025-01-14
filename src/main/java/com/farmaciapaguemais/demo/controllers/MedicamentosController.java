package com.farmaciapaguemais.demo.controllers;


import com.farmaciapaguemais.demo.entities.Medicamentos;
import com.farmaciapaguemais.demo.entities.TipoMedicamento;
import com.farmaciapaguemais.demo.repositories.MedicamentoRepository;
import com.farmaciapaguemais.demo.repositories.TipoMedicamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/medicamentos"})
public class MedicamentosController {
    private final TipoMedicamentoRepository tipoMedicamentoRepository;
    private MedicamentoRepository medicamentoRepository;

    MedicamentosController(MedicamentoRepository medicamentoRepository, TipoMedicamentoRepository tipoMedicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.tipoMedicamentoRepository = tipoMedicamentoRepository;
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
    public ResponseEntity<?> create(@RequestBody Medicamentos medicamento) {
        // Validar se o tipoMedicamento está presente
        if (medicamento.getTipoMedicamento() == null || medicamento.getTipoMedicamento().getId() == null) {
            return ResponseEntity.badRequest().body("O campo 'tipoMedicamento' é obrigatório.");
        }

        // Buscar o tipoMedicamento no banco
        TipoMedicamento tipoMedicamento = tipoMedicamentoRepository
                .findById(medicamento.getTipoMedicamento().getId())
                .orElse(null);

        if (tipoMedicamento == null) {
            return ResponseEntity.badRequest().body("TipoMedicamento inválido ou não encontrado.");
        }

        // Associar o tipoMedicamento ao medicamento
        medicamento.setTipoMedicamento(tipoMedicamento);

        // Salvar o medicamento
        Medicamentos savedMedicamento = medicamentoRepository.save(medicamento);
        return ResponseEntity.ok(savedMedicamento);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable ("id") long id, @RequestBody Medicamentos medicamento){
        return medicamentoRepository.findById(id)
                .map(record ->{
                    record.setNome(medicamento.getNome());
                    record.setNome(medicamento.getDescricao());
                    record.setFabricacao(medicamento.getFabricacao());
                    record.setFabricante(medicamento.getFabricante());
                    record.setValidade(medicamento.getValidade());
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
