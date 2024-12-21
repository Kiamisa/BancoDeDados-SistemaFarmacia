package com.farmaciapaguemais.demo.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 80)
    private String endereco;

    @Column(length = 45)
    private String complemento;

    @Column(nullable = false, length = 10)
    private String bairro;

    @Column(nullable = false)
    private Integer numero;

    @Column(name = "cidades_id", nullable = false)
    private Integer cidadesId;

    @Column(nullable = false, length = 16)
    private String telefone1;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(length = 16)
    private String telefone2;

    @Column(nullable = false, unique = true, length = 11)
    private Long cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nome_pai", length = 60)
    private String nomePai;

    @Column(name = "nome_mae", nullable = false, length = 60)
    private String nomeMae;
}
