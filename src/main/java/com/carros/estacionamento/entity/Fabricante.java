package com.carros.estacionamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private Status status;  // Associação com Status
}
