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
@Table (name="veicolo")
public class Veicolo {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idVeicolo;
	
	
	@Column (
			length = 100,
			nullable = false
			)
	private String colore;
	
	@Column (
			length = 100,
			nullable = false
			)
	private String marca;
	
	private Integer AnnoProduzione;
	
	@Column (
			length = 100,
			nullable = false
			)
	private String modello;
	
	 @ManyToOne
	 @JoinColumn(name = "categoria_id")
	 private Categoria categoria;
	 
	 @ManyToOne
	 @JoinColumn(name = "alimentazione_id")
	 private Alimentazione alimentazione;
	 
	 @ManyToOne
	 @JoinColumn(name = "tipo_veicolo_id")
	 private TipoVeicolo tipoVeicolo;
	 
	 @OneToOne(
				mappedBy = "veicolo",
				cascade =  CascadeType.REMOVE
				)
		private Macchina macchina;

		@OneToOne(
				mappedBy = "veicolo",
				cascade =  CascadeType.REMOVE
				)
		private Moto moto;
		
		@OneToOne(
				mappedBy = "veicolo",
				cascade =  CascadeType.REMOVE
				)
		private Bici bici;
	 
	 
	
}
