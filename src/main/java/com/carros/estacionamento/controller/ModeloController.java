package com.carros.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carros.estacionamento.dto.ModeloDTO;
import com.carros.estacionamento.service.ModeloService;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ModeloDTO criarModelo(@RequestBody ModeloDTO modeloDTO) {
        return modeloService.criarModelo(modeloDTO);

    }

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> listarModelos() {
        List<ModeloDTO> modelos = modeloService.listarModelos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> buscarModeloPorId(@PathVariable Long id) {
        ModeloDTO modelo = modeloService.buscarModeloPorId(id);
        return ResponseEntity.ok(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> atualizarModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO modeloAtualizado = modeloService.atualizarModelo(id, modeloDTO);
        return ResponseEntity.ok(modeloAtualizado);
    }

}
