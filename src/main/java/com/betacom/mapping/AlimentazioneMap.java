package com.betacom.mapping;

import java.util.List;

import com.betacom.dto.output.AlimentazioneDTO;
import com.betacom.models.Alimentazione;

public class AlimentazioneMap {
	
	public static List<AlimentazioneDTO> buildAlimentazioneDTOList(List<Alimentazione> lA){
		
		return lA.stream()
				.map(s -> buildAlimentazioneDTO(s)
						).toList();						
		
	}
	
	
	public static AlimentazioneDTO buildAlimentazioneDTO(Alimentazione a) {

        return AlimentazioneDTO.builder()
        		.id(a.getId())
        		.descrizione(a.getDescrizione())
                .build();
    }

}
