package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.TipoMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMedicamentoRepository extends JpaRepository<TipoMedicamento, Long> {
}

