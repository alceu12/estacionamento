package com.carros.estacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.ModeloDTO;
import com.carros.estacionamento.entity.Fabricante;
import com.carros.estacionamento.entity.Modelo;
import com.carros.estacionamento.entity.Tipo;
import com.carros.estacionamento.repository.FabricanteRepository;
import com.carros.estacionamento.repository.ModeloRepository;
import com.carros.estacionamento.repository.TipoRepository;
import com.carros.estacionamento.util.ModeloMapper;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public ModeloDTO criarModelo(ModeloDTO modeloDTO) {
        // Converter DTO para entidade Modelo
        Modelo modelo = ModeloMapper.toEntity(modeloDTO);

        // Buscar e associar o Fabricante usando o ID
        if (modelo.getFabricante() != null && modelo.getFabricante().getId() != null) {
            Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(modelo.getFabricante().getId());
            if (fabricanteOptional.isPresent()) {
                modelo.setFabricante(fabricanteOptional.get());
            } else {
                throw new RuntimeException("Fabricante com ID " + modelo.getFabricante().getId() + " não encontrado.");
            }
        }
        if (modelo.getTipo() != null && modelo.getTipo().getId() != null) {
            Optional<Tipo> tipoOptional = tipoRepository.findById(modelo.getTipo().getId());
            if (tipoOptional.isPresent()) {
                modelo.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo com ID " + modelo.getTipo().getId() + " não encontrado.");
            }
        }
        modelo = modeloRepository.save(modelo);
        return ModeloMapper.toDTO(modelo);
    }
}
