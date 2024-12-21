package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 45)
    private String cargo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(name = "data_adimissao", nullable = false)
    private LocalDate dataAdmissao;

    @Column(name = "qtd_vendas", nullable = false)
    private Long quantidadeVendas;
}
