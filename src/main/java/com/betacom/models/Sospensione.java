package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sospensione")
@Getter
@Setter
public class Sospensione {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "descrizione", unique = true, nullable = false)
	private String descrizioneSospensione;
}
