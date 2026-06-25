package com.betacom.dto.output;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@JsonPropertyOrder({ "veicolo", "nrRuote", "numeroMarce", "pieghevole", "frenoId", "sospensione" })
public class BiciDTO {

	private Integer nrRuote;
    private Integer numeroMarce;
	private Boolean pieghevole;
	private Integer frenoId;
	private Integer sospensioneId;
}