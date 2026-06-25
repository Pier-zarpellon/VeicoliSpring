package com.betacom.services.interfaces;

import com.betacom.dto.input.BiciReq;


public interface IBiciServices {
void create (BiciReq req) throws Exception;
	
	void update (BiciReq req) throws Exception;
	
	void delete(Integer id) throws Exception;
}
