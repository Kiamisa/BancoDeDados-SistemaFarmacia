package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Fornecedor;
import com.farmaciapaguemais.demo.entities.Fornecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecimento> findByFornecedorId(Integer id);
}
