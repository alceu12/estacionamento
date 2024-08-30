package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Status;

public class StatusMapper {

    public static StatusDTO toDTO(Status status) {
        if (status == null) {
            return null;
        }

        return new StatusDTO(
                status.getId(),
                status.getNome(),
                status.getCodigo());
    }

    public static Status toEntity(StatusDTO dto) {
        if (dto == null) {
            return null;
        }

        Status status = new Status();
        status.setId(dto.getId());
        status.setNome(dto.getNome());
        status.setCodigo(dto.getCodigo());

        return status;
    }
}
