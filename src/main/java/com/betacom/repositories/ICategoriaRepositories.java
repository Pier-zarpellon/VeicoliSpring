package com.betacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.models.Categoria;

public interface ICategoriaRepositories extends JpaRepository <Categoria, Integer> {

}

