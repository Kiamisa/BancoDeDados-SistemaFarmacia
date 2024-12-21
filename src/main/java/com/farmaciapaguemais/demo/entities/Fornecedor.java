package com.farmaciapaguemais.demo.entities;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 16)
    private String telefone;

    @Column(nullable = false, length = 120)
    private String email;
}

