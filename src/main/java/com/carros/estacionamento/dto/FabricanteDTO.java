package com.carros.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteDTO {
    private Long id;
    private String nome;
    private String nacionalidade;
    private StatusDTO statusDTO;  
}
