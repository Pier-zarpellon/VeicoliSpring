package com.betacom.services.interfaces;

import java.util.List;

import com.betacom.dto.input.AlimentazioneReq;
import com.betacom.dto.output.AlimentazioneDTO;

public interface IAlimentazioneServices {
	
	void create (AlimentazioneReq req) throws Exception;
	
	void delete (Integer id) throws Exception;
	
	List<AlimentazioneDTO> list() throws Exception;
	

}
