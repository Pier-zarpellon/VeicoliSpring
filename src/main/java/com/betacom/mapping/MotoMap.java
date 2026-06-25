package com.betacom.mapping;

import com.betacom.dto.output.MotoDTO;
import com.betacom.models.Moto;

public class MotoMap {

	public static MotoDTO buildMotoDTO(Moto m) {

        return MotoDTO.builder()
               
                .numeroRuote(m.getNumeroRuote())
                .targa(m.getTarga())
                .cc(m.getCc())
                .build();
    }
}
