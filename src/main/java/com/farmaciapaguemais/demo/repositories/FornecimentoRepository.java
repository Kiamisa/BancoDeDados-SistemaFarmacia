package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Fornecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecimentoRepository extends JpaRepository<Fornecimento, Long> {
}
