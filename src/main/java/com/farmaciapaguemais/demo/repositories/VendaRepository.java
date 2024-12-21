package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Vendas, Long> {
}
