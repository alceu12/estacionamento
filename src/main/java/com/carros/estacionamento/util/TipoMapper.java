package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.TipoDTO;
import com.carros.estacionamento.entity.Tipo;

public class TipoMapper {

    public static TipoDTO toDTO(Tipo tipo) {
        return new TipoDTO(tipo.getId(), tipo.getNome());
    }

    public static Tipo toEntity(TipoDTO dto) {
        Tipo tipo = new Tipo();
        tipo.setId(dto.getId());
        tipo.setNome(dto.getNome());
        return tipo;
    }
}
