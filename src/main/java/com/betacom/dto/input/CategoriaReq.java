package com.betacom.dto.input;

import java.util.List;

import com.betacom.models.TipoVeicolo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaReq {
	
	private Integer id;
	@NotNull (groups = ValidationGroups.Create.class , message ="nruote.no.car")
	private String descrizione;
	private List<TipoVeicolo> tipiVeicolo;

}
