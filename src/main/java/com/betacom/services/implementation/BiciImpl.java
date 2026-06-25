package com.betacom.services.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.dto.input.BiciReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.Alimentazione;
import com.betacom.models.Bici;
import com.betacom.models.Categoria;
import com.betacom.models.Freno;
import com.betacom.models.Sospensione;
import com.betacom.models.Veicolo;
import com.betacom.repositories.IAlimentazioneRepositories;
import com.betacom.repositories.IBiciRepositories;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.repositories.IFrenoRepositories;
import com.betacom.repositories.ISospensioneRepositories;
import com.betacom.services.interfaces.IBiciServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Service
public class BiciImpl implements IBiciServices {
	
	private final IBiciRepositories Repb;
	private final IAlimentazioneRepositories Repal;
	private final ICategoriaRepositories Repcat;
	private final IFrenoRepositories Repfr;
	private final ISospensioneRepositories Repsos;
	
	private final VeicoloImpl veicoloimpl;

	@Transactional
	@Override
	public void create(BiciReq req) throws Exception {
		log.debug("create {}", req);

		Veicolo v = veicoloimpl.create(req);
		
		
	    
	    Freno fre = Repfr.findById(req.getFrenoId())
	            .orElseThrow(() -> new VeicoliException("frn.no.fnd"));
	    
	    Sospensione sop = Repsos.findById(req.getSospensioneId())
	            .orElseThrow(() -> new VeicoliException("sosp.no.fnd"));

	    Bici b = new Bici();
	    b.setVeicolo(v);
	    b.setNrRuote(req.getNumeroRuote());
	    b.setNumeroMarce(req.getNumeroMarce());
	    b.setPieghevole(req.getPieghevole());
	    b.setFreno(fre);
	    b.setSospensione(sop);

	    Repb.save(b);
	
	}

	@Transactional
	@Override
	public void update(BiciReq req) throws Exception {
		 if (req.getIdBici() == null)
	            throw new VeicoliException("idbc.no.car");

	        Bici b = Repb.findById(req.getIdBici())
	                .orElseThrow(() -> new VeicoliException("bic.no.fnd"));
	        Veicolo v = b.getVeicolo();
	        
	        Optional.ofNullable(req.getNumeroRuote()).ifPresent(b::setNrRuote);
	        Optional.ofNullable(req.getPieghevole()).ifPresent(b::setPieghevole);
	        Optional.ofNullable(req.getNumeroMarce()).ifPresent(b::setNumeroMarce);
	        Optional.ofNullable(req.getColore()).ifPresent(v::setColore);
	        Optional.ofNullable(req.getMarca()).ifPresent(v::setMarca);
	        Optional.ofNullable(req.getAnnoProduzione()).ifPresent(v::setAnnoProduzione);
	        Optional.ofNullable(req.getModello()).ifPresent(v::setModello);
	        
	        

	        if (req.getCategoriaId() != null) {
	            Categoria cat = Repcat.findById(req.getCategoriaId())
	                    .orElseThrow(() -> new VeicoliException("cat.no.fnd"));
	            v.setCategoria(cat);
	        }
	        if (req.getAlimentazioneId() != null) {
	            Alimentazione alt = Repal.findById(req.getAlimentazioneId())
	                    .orElseThrow(() -> new VeicoliException("alim.no.fnd"));
	            v.setAlimentazione(alt);
	        }
	        if (req.getSospensioneId() != null) {
	            Sospensione sop = Repsos.findById(req.getSospensioneId())
	                    .orElseThrow(() -> new VeicoliException("sosp.no.fnd"));
	            b.setSospensione(sop);
	        }
	        if (req.getFrenoId() != null) {
	            Freno fre = Repfr.findById(req.getFrenoId())
	                    .orElseThrow(() -> new VeicoliException("frn.no.fnd"));
	            b.setFreno(fre);
	        }
		
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
			log.debug("delete {}", id);
			Bici b = Repb.findById(id)
					.orElseThrow(() -> new VeicoliException("bic.no.fnd"));
			
			Repb.delete(b);
		
	}


}
