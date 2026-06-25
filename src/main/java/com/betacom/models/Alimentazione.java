package com.betacom.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alimentazione")
@Getter
@Setter
public class Alimentazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String descrizione;

	@ManyToMany
    @JoinTable(
        name = "alimentazione_tipo_veicolo",
        joinColumns = @JoinColumn(name = "alimentazione_id"),
        inverseJoinColumns = @JoinColumn(name = "tipo_veicolo_id")
    )
    private List<TipoVeicolo> tipiVeicolo;
}
