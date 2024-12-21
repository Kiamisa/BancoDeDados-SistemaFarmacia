package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "preco_uni", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "vendas_id", nullable = false)
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id", nullable = false)
    private Medicamentos medicamento;
}
