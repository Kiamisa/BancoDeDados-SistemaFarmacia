package com.farmaciapaguemais.demo.repositories;

import com.farmaciapaguemais.demo.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
