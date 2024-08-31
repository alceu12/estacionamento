package com.carros.estacionamento.service;

import com.carros.estacionamento.util.TipoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Status;
import com.carros.estacionamento.repository.StatusRepository;
import com.carros.estacionamento.util.StatusMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public StatusDTO criarStatus(StatusDTO statusDTO) {
        Status status = StatusMapper.toEntity(statusDTO);
        status = statusRepository.save(status);
        return StatusMapper.toDTO(status);
    }

    public List<StatusDTO> listarStatus() {
        return statusRepository.findAll().stream()
                .map(StatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StatusDTO buscarStatusPorId(Long id) {
        return statusRepository.findById(id)
                .map(StatusMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));
    }

    public StatusDTO atualizarStatus(Long id, StatusDTO statusDTO) {
        Status statusExistente = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));
        statusExistente.setNome(statusDTO.getNome());
        statusExistente.setCodigo(statusDTO.getCodigo());
        Status statusAtualizado = statusRepository.save(statusExistente);
        return StatusMapper.toDTO(statusAtualizado);
    }
}
