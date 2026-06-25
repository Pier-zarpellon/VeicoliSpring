package com.betacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.models.Bici;

public interface IBiciRepositories extends JpaRepository<Bici, Integer> {

}