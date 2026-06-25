package com.betacom.services.implementation;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.SospensioneReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.Sospensione;
import com.betacom.repositories.ISospensioneRepositories;
import com.betacom.services.interfaces.ISospensioneServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class SospensioneImpl implements ISospensioneServices{
	
	private final ISospensioneRepositories Repsop;

	@Transactional
	@Override
	public void create(SospensioneReq req) throws Exception {
		log.debug("create {}", req);
		Sospensione sop = new Sospensione();
		sop.setDescrizioneSospensione(req.getDescrizioneSospensione());	
		
		Repsop.save(sop);
		
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Sospensione sop = Repsop.findById(id)
				.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
		
		Repsop.delete(sop);
		
	}

}
