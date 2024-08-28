package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Status;

public class StatusMapper {
    public static StatusDTO toDTO(Status status) {
        return new StatusDTO(status.getId(), status.getNome());
    }

    public static Status toEntity(StatusDTO dto) {
        Status status = new Status();
        status.setId(dto.getId());
        status.setNome(dto.getNome());
        return status;
    }
}
