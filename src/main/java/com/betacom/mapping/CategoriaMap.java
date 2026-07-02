package com.betacom.mapping;

import java.util.List;

import com.betacom.dto.output.CategoriaDTO;
import com.betacom.models.Categoria;

public class CategoriaMap {
	
public static List<CategoriaDTO> buildCategoriaDTOList(List<Categoria> lC){
		
		return lC.stream()
				.map(s -> buildCategoriaDTO(s)
						).toList();						
		
	}
	
	
	public static CategoriaDTO buildCategoriaDTO(Categoria c) {

        return CategoriaDTO.builder()
        		.id(c.getId())
        		.descrizione(c.getDescrizione())
                .build();
    }

}
