package com.betacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.models.Moto;

public interface IMotoRepositories extends JpaRepository<Moto, Integer> {

	boolean existsByTarga(String targa);

}
