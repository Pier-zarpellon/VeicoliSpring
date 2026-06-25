package com.betacom.services.interfaces;

import com.betacom.dto.input.TipoVeicoloReq;

public interface ITipoVeicoloServices {
	
	void create (TipoVeicoloReq req) throws Exception;
	
	void delete (Integer id) throws Exception;

}
