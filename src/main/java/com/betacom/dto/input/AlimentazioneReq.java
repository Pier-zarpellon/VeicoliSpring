package com.betacom.dto.input;

import java.util.List;

import com.betacom.models.TipoVeicolo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlimentazioneReq {
	
	private Integer id;
	private String descrizione;
	private List<TipoVeicolo> tipiVeicolo;

}
