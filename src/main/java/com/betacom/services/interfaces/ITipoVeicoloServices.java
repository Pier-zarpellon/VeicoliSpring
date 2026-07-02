package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.TipoVeicoloReq;
import com.betacom.dto.output.TipoVeicoloDTO;

public interface ITipoVeicoloServices {
	
	void create (TipoVeicoloReq req) throws Exception;
	
	void delete (Integer id) throws Exception;
	
	List<TipoVeicoloDTO> list() throws Exception;

}
