package com.carros.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    private Long id;
    private String placa;
    private String cor;
    private String ano;
    private ModeloDTO modeloDTO;

}
