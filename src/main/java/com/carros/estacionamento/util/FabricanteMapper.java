package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Fabricante;
import com.carros.estacionamento.entity.Status;

public class FabricanteMapper {

    public static FabricanteDTO toDTO(Fabricante fabricante) {
        StatusDTO statusDTO = StatusMapper.toDTO(fabricante.getStatus());
        return new FabricanteDTO(fabricante.getId(), fabricante.getNome(),fabricante.getNacionalidade(), statusDTO);

    }

    public static Fabricante toEntity(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(dto.getId());
        fabricante.setNome(dto.getNome());
        fabricante.setNacionalidade(dto.getNacionalidade());
        if (dto.getStatusDTO() != null) {
            Status status = StatusMapper.toEntity(dto.getStatusDTO());
            fabricante.setStatus(status);
        }
        return fabricante;
    }
}
