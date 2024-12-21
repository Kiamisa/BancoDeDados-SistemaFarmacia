package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
