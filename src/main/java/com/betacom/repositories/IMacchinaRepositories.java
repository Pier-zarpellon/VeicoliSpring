package com.betacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.models.Macchina;

public interface IMacchinaRepositories extends JpaRepository<Macchina, Integer> {

	boolean existsByTarga(String targa);

}

