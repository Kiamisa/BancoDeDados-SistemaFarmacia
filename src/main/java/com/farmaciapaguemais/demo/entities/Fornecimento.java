package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "fornecimento")
public class Fornecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_fornecimento", nullable = false)
    private LocalDate dataFornecimento;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private LocalDate fabricacao;

    @Column(nullable = false)
    private LocalDate vencimento;

    @ManyToOne
    @JoinColumn(name = "fornecedores_id", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id", nullable = false)
    private Medicamentos medicamento;
}
