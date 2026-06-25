package com.betacom.services.interfaces;

import com.betacom.dto.input.CategoriaReq;

public interface ICategoriaServices {
	
	void create (CategoriaReq req) throws Exception;
	
	void delete (Integer id) throws Exception;
	
	

}
