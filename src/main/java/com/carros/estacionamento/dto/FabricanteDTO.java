package com.carros.estacionamento.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FabricanteDTO {

    private Long id;
    private String nome;
    private String nacionalidade;
    private StatusDTO statusDTO;

    public FabricanteDTO() {

    }
}
