package com.betacom.mapping;

import java.util.List;

import com.betacom.dto.output.TipoVeicoloDTO;
import com.betacom.models.TipoVeicolo;

public class TipoVeicoloMap {
	
public static List<TipoVeicoloDTO> buildTipoVeicoloDTOList(List<TipoVeicolo> lTV){
		
		return lTV.stream()
				.map(s -> buildTipoVeicoloDTO(s)
						).toList();						
		
	}
	
	
	public static TipoVeicoloDTO buildTipoVeicoloDTO(TipoVeicolo tv) {

        return TipoVeicoloDTO.builder()
        		.id(tv.getId())
        		.nome(tv.getNome())
                .build();
    }

}
