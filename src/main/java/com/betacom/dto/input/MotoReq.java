package com.betacom.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoReq extends VeicoloReq {
	
	@NotNull (groups = ValidationGroups.Update.class , message ="idmt.no.car")
	private Integer idMoto;
	@NotNull (groups = ValidationGroups.Create.class , message ="nruote.no.car")
	@Min(value = 2, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "ruote_invalid")
	@Max(value = 6, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "ruote_invalid")
    private Integer numeroRuote;
	@Pattern(
			groups = ValidationGroups.Create.class,
		    regexp = "^[A-Z]{2}[0-9]{5}$",
		    message = "Formato targa non valido. Esempio: AB123CD"
		)
    private String targa;
    @NotNull (groups = ValidationGroups.Create.class , message ="nrcc.no.car")
    private Integer cc;
}