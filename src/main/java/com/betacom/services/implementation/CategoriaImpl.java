package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.dto.input.CategoriaReq;
import com.betacom.dto.output.CategoriaDTO;
import com.betacom.exception.VeicoliException;
import com.betacom.mapping.CategoriaMap;
import com.betacom.models.Categoria;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.services.interfaces.ICategoriaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoriaImpl implements ICategoriaServices{
	
	private final ICategoriaRepositories Repcat;

	@Override
	public void create(CategoriaReq req) throws Exception {
		log.debug("create {}", req);
		Categoria cat = new Categoria();
		cat.setDescrizione(req.getDescrizione());	
		cat.setTipiVeicolo(req.getTipiVeicolo());
		
		Repcat.save(cat);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Categoria cat = Repcat.findById(id)
				.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
		
		Repcat.delete(cat);
		
	}

	@Override
	public List<CategoriaDTO> list() throws Exception {
		List<Categoria> lA = Repcat.findAll();
		return CategoriaMap.buildCategoriaDTOList(lA);
	}

}
