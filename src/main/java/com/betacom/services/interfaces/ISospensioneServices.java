package com.betacom.services.interfaces;

import com.betacom.dto.input.SospensioneReq;

public interface ISospensioneServices {
	
	void create (SospensioneReq req) throws Exception;
	
	void delete (Integer id) throws Exception;

}
