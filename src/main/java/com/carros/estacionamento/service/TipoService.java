package com.carros.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.estacionamento.dto.TipoDTO;
import com.carros.estacionamento.entity.Tipo;
import com.carros.estacionamento.repository.TipoRepository;
import com.carros.estacionamento.util.TipoMapper;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public TipoDTO criarTipo(TipoDTO tipoDTO) {
        Tipo tipo = TipoMapper.toEntity(tipoDTO);
        tipo = tipoRepository.save(tipo);
        return TipoMapper.toDTO(tipo);
    }

    public List<TipoDTO> listarTipos() {
        return tipoRepository.findAll().stream()
                .map(TipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TipoDTO buscarTipoPorId(Long id) {
        return tipoRepository.findById(id)
                .map(TipoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }

    public TipoDTO atualizarTipo(Long id, TipoDTO tipoDTO) {
        Tipo tipoExistente = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));

        tipoExistente.setNome(tipoDTO.getNome());
        Tipo tipoAtualizado = tipoRepository.save(tipoExistente);
        return TipoMapper.toDTO(tipoAtualizado);
    }
}
