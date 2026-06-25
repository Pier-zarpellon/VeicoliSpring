package com.betacom.mapping;

import com.betacom.dto.output.BiciDTO;
import com.betacom.models.Bici;

public class BiciMap {



	public static BiciDTO buildBiciDTO(Bici b) {

        return BiciDTO.builder()
    
                .nrRuote(b.getNrRuote())
                .numeroMarce(b.getNumeroMarce())
                .pieghevole(b.getPieghevole())
                .frenoId(b.getFreno() == null ? null : b.getFreno().getId())
                .sospensioneId(b.getSospensione() == null ? null : b.getSospensione().getId())
                .build();
    }
	}
