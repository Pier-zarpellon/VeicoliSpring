package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.AlimentazioneReq;
import com.betacom.dto.output.AlimentazioneDTO;
import com.betacom.exception.VeicoliException;
import com.betacom.mapping.AlimentazioneMap;
import com.betacom.models.Alimentazione;
import com.betacom.repositories.IAlimentazioneRepositories;
import com.betacom.services.interfaces.IAlimentazioneServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AlimentazioneImpl implements IAlimentazioneServices{

	private final IAlimentazioneRepositories Repalm;
	
	@Transactional
	@Override
	public void create(AlimentazioneReq req) throws Exception {
		log.debug("create {}", req);
		Alimentazione alm = new Alimentazione();
		alm.setDescrizione(req.getDescrizione());
		alm.setTipiVeicolo(req.getTipiVeicolo());
	
		
		Repalm.save(alm);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Alimentazione alm = Repalm.findById(id)
				.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
		
		Repalm.delete(alm);
		
	}

	@Override
	public List<AlimentazioneDTO> list() throws Exception {
		List<Alimentazione> lA = Repalm.findAll();
		return AlimentazioneMap.buildAlimentazioneDTOList(lA);
	}

}
