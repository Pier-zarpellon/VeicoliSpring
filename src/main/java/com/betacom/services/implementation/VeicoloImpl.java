package com.betacom.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.dto.input.VeicoloReq;
import com.betacom.dto.output.VeicoloDTO;
import com.betacom.exception.VeicoliException;
import com.betacom.mapping.VeicoloMap;
import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.TipoVeicolo;
import com.betacom.models.Veicolo;
import com.betacom.repositories.IAlimentazioneRepositories;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.repositories.ITipoVeicoloRepositories;
import com.betacom.repositories.IVeicoloRepositories;
import com.betacom.services.interfaces.IVeicoloServices;
import com.betacom.validator.Validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class VeicoloImpl implements IVeicoloServices {
	
	private final IVeicoloRepositories Repv;
    private final ICategoriaRepositories Repcat;
    private final IAlimentazioneRepositories Repal;
    private final ITipoVeicoloRepositories Reptv;

    @Transactional
	@Override
	public Veicolo create(VeicoloReq req) throws Exception {
		Veicolo v = new Veicolo();
		 
	        v.setColore(req.getColore());
	        v.setMarca(req.getMarca());

	        Validator.validaAnnoProduzione(req.getAnnoProduzione());
	        v.setAnnoProduzione(req.getAnnoProduzione());

	        v.setModello(req.getModello());
	        
	        TipoVeicolo tv = Reptv.findById(req.getTipoVeicoloId())
				    .orElseThrow(() -> new VeicoliException("tipo.no.fnd"));

	        Categoria cat = Repcat.findById(req.getCategoriaId())
	                .orElseThrow(() -> new VeicoliException("cat.no.fnd"));
	        
	        if (!cat.getTipiVeicolo().contains(tv)) {
	            throw new VeicoliException("cat.non.com.con.ti");
	        }

	        Alimentazione alt = Repal.findById(req.getAlimentazioneId())
	                .orElseThrow(() -> new VeicoliException("alim.no.fnd"));
	        
	        if (!alt.getTipiVeicolo().contains(tv)) {
	            throw new VeicoliException("alime.non.com.con.ti");
	        }

	        v.setCategoria(cat);
	        v.setAlimentazione(alt);
	        v.setTipoVeicolo(tv);

	       return  Repv.save(v);
		
		
	}

	@Override
	public void update(VeicoloReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VeicoloDTO> list(String TipoVeicolo, String colore, String alimentazione, String categoria, String targa, Integer idVeicolo) throws Exception{
		log.debug("List: {} / {} / {} / {} / {} / {}", TipoVeicolo, colore, alimentazione, categoria, targa, idVeicolo);
		List<Veicolo> lV = Repv.searchByFilter(TipoVeicolo, colore, alimentazione, categoria, targa, idVeicolo);
		return VeicoloMap.buildVeicoloDTOList(lV);
	}

	


}
