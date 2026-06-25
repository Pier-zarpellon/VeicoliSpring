package com.betacom.mapping;


import java.util.List;

import com.betacom.dto.output.VeicoloDTO;
import com.betacom.models.Veicolo;

public class VeicoloMap {

	public static List<VeicoloDTO> buildVeicoloDTOList(List<Veicolo> lV) {

        return lV.stream()
                .map(v -> buildVeicoloDTO(v)
                        ).toList();

    }
	
	public static VeicoloDTO buildVeicoloDTO(Veicolo v) {

	    return VeicoloDTO.builder()
	            .tipoVeicolo(v.getTipoVeicolo() != null ? v.getTipoVeicolo().getNome() : null)
	            .colore(v.getColore())
	            .marca(v.getMarca())
	            .annoProduzione(v.getAnnoProduzione())
	            .modello(v.getModello())
	            .categoria(v.getCategoria() != null ? v.getCategoria().getDescrizione() : null)
	            .alimentazione(v.getAlimentazione() != null ? v.getAlimentazione().getDescrizione() : null)
	            .macchina(v.getMacchina() == null ? null :MacchinaMap.buildMacchinaDTO(v.getMacchina()))
                .moto(v.getMoto() == null ? null : MotoMap.buildMotoDTO(v.getMoto()))
                .bici(v.getBici() == null ? null : BiciMap.buildBiciDTO(v.getBici()))
	            .build();
	}
}

