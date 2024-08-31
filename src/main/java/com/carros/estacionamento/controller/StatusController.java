package com.carros.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carros.estacionamento.dto.StatusDTO;
import com.carros.estacionamento.service.StatusService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity <List<StatusDTO>> listarStatus() {
        List<StatusDTO> statusDTO = statusService.listarStatus();
        return ResponseEntity.ok(statusDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> buscarStatusPorId(@PathVariable Long id) {
        StatusDTO status = statusService.buscarStatusPorId(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> atualizarStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        StatusDTO statusAtualizado = statusService.atualizarStatus(id, statusDTO);
        return ResponseEntity.ok(statusAtualizado);
    }
}
