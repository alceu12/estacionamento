package com.carros.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {
    private Long id;
    private String nome;
    private FabricanteDTO fabricanteDTO;  
    private TipoDTO tipoDTO;  
}
