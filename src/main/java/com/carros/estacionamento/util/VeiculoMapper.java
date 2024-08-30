package com.carros.estacionamento.util;

import com.carros.estacionamento.dto.VeiculoDTO;
import com.carros.estacionamento.dto.ModeloDTO;
import com.carros.estacionamento.entity.Veiculo;
import com.carros.estacionamento.entity.Modelo;

public class VeiculoMapper {

    public static VeiculoDTO toDTO(Veiculo veiculo) {
        if (veiculo == null) {
            return null;
        }

        ModeloDTO modeloDTO = ModeloMapper.toDTO(veiculo.getModelo());

        return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getPlaca(),
            veiculo.getCor(),
            veiculo.getAno(),
            modeloDTO
        );
    }

    public static Veiculo toEntity(VeiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setId(dto.getId());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setCor(dto.getCor());
        veiculo.setAno(dto.getAno());

        if (dto.getModeloDTO() != null && dto.getModeloDTO().getId() != null) {
            Modelo modelo = new Modelo();
            modelo.setId(dto.getModeloDTO().getId());
            veiculo.setModelo(modelo);
        }

        return veiculo;
    }
}
