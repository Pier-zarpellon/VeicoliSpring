package com.betacom.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table (name="moto")
public class Moto {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMoto;
	
	@Column (
			length = 100,
			nullable = false
			)
	private Integer numeroRuote;
	
	@Column (
			length = 100,
			nullable = false
			)
    private String targa;
	@Column (
			length = 100,
			nullable = false
			)
    private Integer cc;
	
	 @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	    @JoinColumn(name = "veicolo_id")
	    private Veicolo veicolo;
	 
	

}
