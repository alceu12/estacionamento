package com.carros.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.entity.Fabricante;
import com.carros.estacionamento.repository.FabricanteRepository;
import com.carros.estacionamento.util.FabricanteMapper;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteDTO criarFabricante(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = FabricanteMapper.toEntity(fabricanteDTO);
        fabricante = fabricanteRepository.save(fabricante);
        return fabricanteDTO;
    }
}
