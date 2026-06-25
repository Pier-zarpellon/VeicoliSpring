package com.betacom.services.implementation;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.FrenoReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.Freno;
import com.betacom.repositories.IFrenoRepositories;
import com.betacom.services.interfaces.IFrenoServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class FrenoImpl implements IFrenoServices{
	
	private final IFrenoRepositories Repfrn;

	@Transactional
	@Override
	public void create(FrenoReq req) throws Exception {
		log.debug("create {}", req);
		Freno frn = new Freno();
		frn.setDescrizioneFreno(req.getDescrizioneFreno());	
		
		Repfrn.save(frn);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Freno frn = Repfrn.findById(id)
				.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
		
		Repfrn.delete(frn);
		
	}

}
