package com.betacom.services.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.models.MessageID;
import com.betacom.models.Messaggi;
import com.betacom.repositories.IMessageRepository;
import com.betacom.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MessaggioImpl implements IMessaggioServices{

	private final IMessageRepository mesR;
	
	@Value("${lang}")
	private String lang;
	
	@Override
	public String get(String code) {
		log.debug("get {}", code);
		String r = null;
		Optional<Messaggi> m = mesR.findById(new MessageID(lang, code));
		if (m.isEmpty()) {
			r = code;
		} else 
			r = m.get().getMessaggio();
		
		return r;
	}

}
