package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "prescricoes")
public class Prescricoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Clientes_id", nullable = false)
    private Clientes cliente;

    @Column(name = "data_presc", nullable = false)
    private LocalDate dataPrescricao;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "medicamentos_id", nullable = false)
    private Medicamentos medicamento;
}
