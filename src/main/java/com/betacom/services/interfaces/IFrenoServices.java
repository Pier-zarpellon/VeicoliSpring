package com.betacom.services.interfaces;

import com.betacom.dto.input.FrenoReq;

public interface IFrenoServices {
	
	void create (FrenoReq req) throws Exception;
	
	void delete (Integer id) throws Exception;

}
