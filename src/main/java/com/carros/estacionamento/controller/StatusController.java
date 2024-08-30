package com.carros.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusDTO> criarStatus(@RequestBody StatusDTO statusDTO) {
        StatusDTO novoStatus = statusService.criarStatus(statusDTO);
        return ResponseEntity.ok(novoStatus);
    }
}
