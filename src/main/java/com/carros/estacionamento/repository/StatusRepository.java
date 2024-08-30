package com.carros.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.estacionamento.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
