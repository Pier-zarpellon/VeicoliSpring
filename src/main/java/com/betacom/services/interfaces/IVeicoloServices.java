package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.VeicoloReq;
import com.betacom.dto.output.VeicoloDTO;
import com.betacom.models.Veicolo;

public interface IVeicoloServices {
	Veicolo create (VeicoloReq req) throws Exception;
	
	void update (VeicoloReq req) throws Exception;
	
	List<VeicoloDTO> list(String TipoVeicolo, String colore, String alimentazione, String categoria, String targa, Integer idVeicolo) throws Exception;
	
}
