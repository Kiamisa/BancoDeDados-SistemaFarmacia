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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Medicamentos getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamentos medicamento) {
        this.medicamento = medicamento;
    }
}
