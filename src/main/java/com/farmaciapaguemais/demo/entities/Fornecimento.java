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

    //possivel alteração
    @ManyToOne
    @JoinColumn(name = "medicamentos_id", nullable = false)
    private Medicamentos medicamento;



    //Get e Set
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDate getDataFornecimento() { return dataFornecimento; }

    public void setDataFornecimento(LocalDate dataFornecimento) { this.dataFornecimento = dataFornecimento; }

    public Integer getQuantidade() { return quantidade; }

    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public BigDecimal getValorTotal() { return valorTotal; }

    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getFabricacao() { return fabricacao; }

    public void setFabricacao(LocalDate fabricacao) { this.fabricacao = fabricacao; }

    public LocalDate getVencimento() { return vencimento; }

    public void setVencimento(LocalDate vencimento) { this.vencimento = vencimento; }

    public Fornecedor getFornecedor() { return fornecedor; }

    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public Medicamentos getMedicamento() { return medicamento; }

    public void setMedicamento(Medicamentos medicamento) { this.medicamento = medicamento; }
}
