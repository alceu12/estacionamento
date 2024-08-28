package com.carros.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDTO {

    private Long id;
    private String nome;
    private int codigo;

    public StatusDTO() {

    }
}
