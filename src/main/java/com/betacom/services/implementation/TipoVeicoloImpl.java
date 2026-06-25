package com.betacom.services.implementation;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.TipoVeicoloReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.TipoVeicolo;
import com.betacom.repositories.ITipoVeicoloRepositories;
import com.betacom.services.interfaces.ITipoVeicoloServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class TipoVeicoloImpl implements ITipoVeicoloServices{
	
	private final ITipoVeicoloRepositories Reptv;

	@Transactional
	@Override
	public void create(TipoVeicoloReq req) throws Exception {
		log.debug("create {}", req);
		TipoVeicolo tv =  new TipoVeicolo();
		tv.setNome(req.getNome());	
		
		Reptv.save(tv);
		
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		TipoVeicolo tv = Reptv.findById(id)
				.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
		
		Reptv.delete(tv);
		
	}

}
