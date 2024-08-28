package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Fabricante;

public class FabricanteMapper {

    public static FabricanteDTO toDTO(Fabricante fabricante) {
        StatusDTO statusDTO = StatusMapper.toDTO(fabricante.getStatus());
        return new FabricanteDTO(fabricante.getId(), fabricante.getNome(), statusDTO);

    }

    public static Fabricante toEntity(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(dto.getId());
        fabricante.setNome(dto.getNome());
        if (dto.getStatusDTO() != null) {
            fabricante.setStatus(StatusMapper.toEntity(dto.getStatusDTO()));
        }
        return fabricante;
    }
}
