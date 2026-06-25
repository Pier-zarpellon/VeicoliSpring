package com.betacom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.models.Veicolo;

@Repository
public interface IVeicoloRepositories extends JpaRepository<Veicolo, Integer> {
	
	@Query (name = "veicolo.selectByFilter")
	List<Veicolo> searchByFilter (
			@Param("tipoVeicolo")String TipoVeicolo, 
			@Param("colore")String colore,
			@Param("alimentazione")String alimentazione,
			@Param("categoria")String categoria,
			@Param("targa")String targa,
			@Param("idVeicolo")Integer idVeicolo
			);
}