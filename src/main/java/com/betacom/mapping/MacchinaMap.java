package com.betacom.mapping;

import com.betacom.dto.output.MacchinaDTO;
import com.betacom.models.Macchina;

public class MacchinaMap {

	public static MacchinaDTO buildMacchinaDTO(Macchina mac) {

        return MacchinaDTO.builder()
           
                .numeroPorte(mac.getNumeroPorte())
                .numeroRuote(mac.getNumeroPorte())
                .cc(mac.getCc())
                .targa(mac.getTarga())
                .build();
    }
}
