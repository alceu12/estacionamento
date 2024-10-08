package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.ModeloDTO;
import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.dto.TipoDTO;
import com.carros.estacionamento.entity.Modelo;
import com.carros.estacionamento.entity.Fabricante;
import com.carros.estacionamento.entity.Tipo;

public class ModeloMapper {

    public static ModeloDTO toDTO(Modelo modelo) {
        if (modelo == null) {
            return null;
        }

        FabricanteDTO fabricanteDTO = FabricanteMapper.toDTO(modelo.getFabricante());
        TipoDTO tipoDTO = TipoMapper.toDTO(modelo.getTipo());

        return new ModeloDTO(
            modelo.getId(),
            modelo.getNome(),
            fabricanteDTO,
            tipoDTO
        );
    }

    public static Modelo toEntity(ModeloDTO dto) {
        if (dto == null) {
            return null;
        }

        Modelo modelo = new Modelo();
        modelo.setId(dto.getId());
        modelo.setNome(dto.getNome());

        if (dto.getFabricanteDTO() != null && dto.getFabricanteDTO().getId() != null) {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(dto.getFabricanteDTO().getId());
            modelo.setFabricante(fabricante);
        }

        if (dto.getTipoDTO() != null && dto.getTipoDTO().getId() != null) {
            Tipo tipo = new Tipo();
            tipo.setId(dto.getTipoDTO().getId());
            modelo.setTipo(tipo);
        }

        return modelo;
    }
}
