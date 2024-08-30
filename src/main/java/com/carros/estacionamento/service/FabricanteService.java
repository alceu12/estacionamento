package com.carros.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.entity.Fabricante;
import com.carros.estacionamento.entity.Status;
import com.carros.estacionamento.repository.FabricanteRepository;
import com.carros.estacionamento.repository.StatusRepository;
import com.carros.estacionamento.util.FabricanteMapper;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private StatusRepository statusRepository;

    public FabricanteDTO criarFabricante(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = FabricanteMapper.toEntity(fabricanteDTO);

        // Verificar se o Status está presente e associar corretamente
        if (fabricanteDTO.getStatusDTO() != null && fabricanteDTO.getStatusDTO().getId() != null) {
            Optional<Status> statusOptional = statusRepository.findById(fabricanteDTO.getStatusDTO().getId());
            if (statusOptional.isPresent()) {
                fabricante.setStatus(statusOptional.get());
            } else {
                throw new RuntimeException(
                        "Status com ID " + fabricanteDTO.getStatusDTO().getId() + " não encontrado.");
            }
        }

        fabricante = fabricanteRepository.save(fabricante);
        return FabricanteMapper.toDTO(fabricante);
    }

    public List<FabricanteDTO> listarFabricantes() {
        return fabricanteRepository.findAll().stream()
                .map(FabricanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FabricanteDTO buscarFabricantePorId(Long id) {
        return fabricanteRepository.findById(id)
                .map(FabricanteMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));
    }

    public FabricanteDTO atualizarFabricante(Long id, FabricanteDTO fabricanteDTO) {
        Fabricante fabricanteExistente = fabricanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));

        fabricanteExistente.setNome(fabricanteDTO.getNome());
        fabricanteExistente.setNacionalidade(fabricanteDTO.getNacionalidade());

        if (fabricanteDTO.getStatusDTO() != null && fabricanteDTO.getStatusDTO().getId() != null) {
            Optional<Status> statusOptional = statusRepository.findById(fabricanteDTO.getStatusDTO().getId());
            statusOptional.ifPresent(fabricanteExistente::setStatus);
        }

        Fabricante fabricanteAtualizado = fabricanteRepository.save(fabricanteExistente);
        return FabricanteMapper.toDTO(fabricanteAtualizado);
    }
}
