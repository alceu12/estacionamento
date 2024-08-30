package com.carros.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.carros.estacionamento.dto.TipoDTO;
import com.carros.estacionamento.service.TipoService;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping
    public TipoDTO criarTipo(@RequestBody TipoDTO tipoDTO) {
        return tipoService.criarTipo(tipoDTO);

    }

    @GetMapping
    public ResponseEntity<List<TipoDTO>> listarTipos() {
        List<TipoDTO> tipos = tipoService.listarTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> buscarTipoPorId(@PathVariable Long id) {
        TipoDTO tipo = tipoService.buscarTipoPorId(id);
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> atualizarTipo(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
        TipoDTO tipoAtualizado = tipoService.atualizarTipo(id, tipoDTO);
        return ResponseEntity.ok(tipoAtualizado);
    }
}
