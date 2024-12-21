package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamentos, Long> {
}
