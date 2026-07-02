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
@Table (name="macchina")
public class Macchina {


	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_auto")
    private Integer id;
    
	@Column (
			nullable= false,
			length = 7,
			unique = true
			)
    private String targa;
    
    
    private Integer cc;
    
    private Integer numeroPorte;
    
    private Integer numeroRuote;
    
    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "veicolo_id")
    private Veicolo veicolo;
}

