package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "uso_indicado", nullable = false, length = 255)
    private String usoIndicado;

    @Column(nullable = false)
    private LocalDate fabricacao;

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false)
    private Integer estoque;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
}

