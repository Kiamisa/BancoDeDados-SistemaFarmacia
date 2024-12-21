package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {
}
