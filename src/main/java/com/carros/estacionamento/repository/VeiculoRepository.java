package com.carros.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.estacionamento.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
