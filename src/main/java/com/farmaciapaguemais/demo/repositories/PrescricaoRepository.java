package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Prescricoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescricaoRepository extends JpaRepository<Prescricoes, Long> {
}
