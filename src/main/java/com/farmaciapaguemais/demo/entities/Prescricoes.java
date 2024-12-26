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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Medicamentos getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamentos medicamento) {
        this.medicamento = medicamento;
    }
}
