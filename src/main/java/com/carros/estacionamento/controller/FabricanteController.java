package com.carros.estacionamento.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.estacionamento.dto.FabricanteDTO;
import com.carros.estacionamento.service.FabricanteService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public FabricanteDTO criarFabricante(@RequestBody FabricanteDTO fabricanteDTO) {
        return fabricanteService.criarFabricante(fabricanteDTO);

    }

    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> listarFabricantes() {
        List<FabricanteDTO> fabricantes = fabricanteService.listarFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> buscarFabricantePorId(@PathVariable Long id) {
        FabricanteDTO fabricante = fabricanteService.buscarFabricantePorId(id);
        return ResponseEntity.ok(fabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> atualizarFabricante(@PathVariable Long id,
            @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO fabricanteAtualizado = fabricanteService.atualizarFabricante(id, fabricanteDTO);
        return ResponseEntity.ok(fabricanteAtualizado);
    }
}
