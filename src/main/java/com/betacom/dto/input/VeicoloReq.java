package com.betacom.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeicoloReq {

	@NotNull (groups = ValidationGroups.Create.class , message ="veicolo.no.car")
    private Integer tipoVeicoloId;
	@NotNull (groups = ValidationGroups.Create.class , message ="colore.no.car")
    @NotBlank (groups = ValidationGroups.Create.class , message ="colore.no.car")
    private String colore;
	@NotNull (groups = ValidationGroups.Create.class , message ="marca.no.car")
    @NotBlank (groups = ValidationGroups.Create.class , message ="marca.no.car")
    private String marca;
	@NotNull (groups = ValidationGroups.Create.class , message ="annop.no.car")
    private Integer annoProduzione;
	@NotNull (groups = ValidationGroups.Create.class , message ="modello.no.car")
    @NotBlank (groups = ValidationGroups.Create.class , message ="modello.no.car")
    private String modello;
	@NotNull (groups = ValidationGroups.Create.class , message ="cat.no.fnd")
    private Integer categoriaId;
	@NotNull (groups = ValidationGroups.Create.class , message ="alim.no.fnd")
    private Integer alimentazioneId;
}

