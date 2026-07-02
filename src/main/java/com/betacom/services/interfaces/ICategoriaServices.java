package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.CategoriaReq;
import com.betacom.dto.output.CategoriaDTO;

public interface ICategoriaServices {
	
	void create (CategoriaReq req) throws Exception;
	
	void delete (Integer id) throws Exception;
	
	List<CategoriaDTO> list() throws Exception;
	
	

}
