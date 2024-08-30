package com.carros.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.entity.Status;
import com.carros.estacionamento.repository.StatusRepository;
import com.carros.estacionamento.util.StatusMapper;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public StatusDTO criarStatus(StatusDTO statusDTO) {
        Status status = StatusMapper.toEntity(statusDTO);
        status = statusRepository.save(status);
        return StatusMapper.toDTO(status);
    }
}
