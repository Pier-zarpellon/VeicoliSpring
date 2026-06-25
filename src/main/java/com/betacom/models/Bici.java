package com.betacom.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table (name="bici")
public class Bici{

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_bici")
    private Integer id;
	
	@Column (
			length = 100,
			nullable = false
			)
	private Integer nrRuote;
		
	@Column (
			nullable = false
			)
	private Integer numeroMarce;
	
	private Boolean pieghevole;
	
	 @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
	 @JoinColumn(name = "veicolo_id")
	 private Veicolo veicolo;
	 
	 @ManyToOne
	 @JoinColumn(name = "freno_id")
	 private Freno freno;
	 
	 @ManyToOne
	 @JoinColumn(name = "sospensione_id")
	 private Sospensione sospensione;
	 
	
}
