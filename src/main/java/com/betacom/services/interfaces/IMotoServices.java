package com.betacom.services.interfaces;

import com.betacom.dto.input.MotoReq;


public interface IMotoServices {

	void create (MotoReq req) throws Exception;
	
	void update (MotoReq req) throws Exception;
	
	void delete(Integer id) throws Exception;

}
