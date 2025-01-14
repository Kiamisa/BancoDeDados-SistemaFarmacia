package com.farmaciapaguemais.demo.controllers;

import com.farmaciapaguemais.demo.entities.TipoMedicamento;
import com.farmaciapaguemais.demo.repositories.TipoMedicamentoRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_medicamentos")
public class TipoMedicamentoController {

    @Autowired
    private TipoMedicamentoRepository repository;

    @GetMapping
    public List<TipoMedicamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public TipoMedicamento criar(@RequestBody TipoMedicamento tipoMedicamento) {
        return repository.save(tipoMedicamento);
    }
}

