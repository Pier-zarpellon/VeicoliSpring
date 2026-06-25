package com.betacom.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BiciReq extends VeicoloReq {

	@NotNull (groups = ValidationGroups.Update.class , message ="idbc.no.car")
	private Integer idBici;
	@NotNull (groups = ValidationGroups.Create.class , message ="nruote.no.car")
    private Integer numeroRuote;
	@NotNull (groups = ValidationGroups.Create.class , message ="nrmar.no.car")
	@Min(value = 1, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "marce_invalid")
	@Max(value = 25, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "marce_invalid")
    private Integer numeroMarce;
    private Boolean pieghevole;
    private Integer frenoId;
    private Integer sospensioneId;
   
}

