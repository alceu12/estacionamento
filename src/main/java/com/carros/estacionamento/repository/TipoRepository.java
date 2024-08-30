package com.carros.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.estacionamento.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
