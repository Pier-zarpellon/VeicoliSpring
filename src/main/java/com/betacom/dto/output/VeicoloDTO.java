package com.betacom.dto.output;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeicoloDTO {

    private String tipoVeicolo;
    private String colore;
    private String marca;
    private Integer annoProduzione;
    private String modello;
    private String categoria;
    private String alimentazione;
    private MacchinaDTO macchina;
    private MotoDTO moto;
    private BiciDTO bici;
    
}

