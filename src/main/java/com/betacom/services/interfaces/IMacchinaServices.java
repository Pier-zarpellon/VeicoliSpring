package com.betacom.services.interfaces;

import com.betacom.dto.input.MacchinaReq;

public interface IMacchinaServices {
void create (MacchinaReq req) throws Exception;
	
	void update (MacchinaReq req) throws Exception;
	
	void delete(Integer id) throws Exception;
}
