package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Fornecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecimentoRepository extends JpaRepository<Fornecimento, Long> {
    List<Fornecimento> findByFornecedorId(Long fornecedorId);
    List<Fornecimento> findByMedicamentoId(Long medicamentoId);
}
