package com.carros.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.estacionamento.entity.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
