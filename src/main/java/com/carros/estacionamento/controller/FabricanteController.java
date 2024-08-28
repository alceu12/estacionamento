package com.carros.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
