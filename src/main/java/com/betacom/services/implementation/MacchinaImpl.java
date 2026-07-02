package com.betacom.services.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.dto.input.MacchinaReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.Macchina;
import com.betacom.models.Veicolo;
import com.betacom.repositories.IAlimentazioneRepositories;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.repositories.IMacchinaRepositories;
import com.betacom.services.interfaces.IMacchinaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MacchinaImpl implements IMacchinaServices {

	private final IMacchinaRepositories Repm;
	private final IAlimentazioneRepositories Repal;
	private final ICategoriaRepositories Repcat;
	private final VeicoloImpl veicoloimpl;
	
	@Transactional
	@Override
	public void create(MacchinaReq req) throws Exception {
		    log.debug("create {}", req);

		    Veicolo v = veicoloimpl.create(req);
		    
		    Macchina mc = new Macchina();
		    mc.setVeicolo(v);
		    mc.setNumeroPorte(req.getNumeroPorte());
		    mc.setNumeroRuote(req.getNumeroRuote());
            mc.setTarga(req.getTarga());
		    mc.setCc(req.getCc());

		    Repm.save(mc);
		}
		
	@Transactional
	@Override
	public void update(MacchinaReq req) throws Exception {

	    if (req.getIdMacchina() == null)
	        throw new VeicoliException("idmc.no.car");

	    Macchina mc = Repm.findById(req.getIdMacchina())
	            .orElseThrow(() -> new VeicoliException("mac.no.fnd"));
	    Veicolo v = mc.getVeicolo();
	    if (req.getTarga() != null && !req.getTarga().equalsIgnoreCase(mc.getTarga())) {
	        if (Repm.existsByTarga(req.getTarga()))
	            throw new VeicoliException("tar.gia.exist");
	        mc.setTarga(req.getTarga());
	    }
	    
	    Optional.ofNullable(req.getNumeroRuote()).ifPresent(mc::setNumeroPorte);
	    Optional.ofNullable(req.getNumeroPorte()).ifPresent(mc::setNumeroPorte);
	    Optional.ofNullable(req.getCc()).ifPresent(mc::setCc);
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
	}
	@Transactional
	@Override
	   public void delete(Integer id) throws Exception {
        log.debug("delete {}", id);
        Macchina mc = Repm.findById(id)
                .orElseThrow(() -> new VeicoliException("mac.no.fnd"));

        Repm.delete(mc);

    }


}