package com.betacom.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SospensioneReq {
	
	private Integer id;
	@NotNull (groups = ValidationGroups.Create.class , message ="nruote.no.car")
	private String descrizioneSospensione;

}
