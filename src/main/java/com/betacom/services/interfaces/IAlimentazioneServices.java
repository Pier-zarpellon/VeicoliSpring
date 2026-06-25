package com.betacom.services.interfaces;

import com.betacom.dto.input.AlimentazioneReq;

public interface IAlimentazioneServices {
	
	void create (AlimentazioneReq req) throws Exception;
	
	void delete (Integer id) throws Exception;
	

}
