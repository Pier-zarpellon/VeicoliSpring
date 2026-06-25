package com.betacom.services.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.dto.input.MotoReq;
import com.betacom.exception.VeicoliException;
import com.betacom.models.Alimentazione;
import com.betacom.models.Categoria;
import com.betacom.models.Moto;
import com.betacom.models.Veicolo;
import com.betacom.repositories.IAlimentazioneRepositories;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.repositories.IMotoRepositories;
import com.betacom.services.interfaces.IMotoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Service
public class MotoImpl implements IMotoServices{

	private final IMotoRepositories Repmt;
	private final IAlimentazioneRepositories Repal;
	private final ICategoriaRepositories Repcat;
	private final VeicoloImpl veicoloimpl;

	@Transactional
	@Override
	public void create(MotoReq req) throws Exception {

	   log.debug("create {}", req);

	   Veicolo v = veicoloimpl.create(req);
	    
	    Moto m = new Moto();
	    m.setVeicolo(v);
	    m.setNumeroRuote(req.getNumeroRuote());
        m.setTarga(req.getTarga());
	    m.setCc(req.getCc());

	    Repmt.save(m);
        }

	@Transactional
	@Override
	public void update(MotoReq req) throws Exception {

	    if (req.getIdMoto() == null)
	        throw new VeicoliException("idmt.no.car");

	    Moto m = Repmt.findById(req.getIdMoto())
	            .orElseThrow(() -> new VeicoliException("mot.no.fnd"));
	    Veicolo v = m.getVeicolo();
	    if (req.getTarga() != null && !req.getTarga().equalsIgnoreCase(m.getTarga())) {
	        if (Repmt.existsByTarga(req.getTarga()))
	            throw new VeicoliException("tar.gia.exist");
	        m.setTarga(req.getTarga());
	    }
	    
	    Optional.ofNullable(req.getNumeroRuote()).ifPresent(m::setNumeroRuote);
	    Optional.ofNullable(req.getCc()).ifPresent(m::setCc);
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
        Moto m = Repmt.findById(id)
                .orElseThrow(() -> new VeicoliException("mot.no.fnd"));

        Repmt.delete(m);

    }

}
