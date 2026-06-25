package com.betacom.validator;

import java.time.Year;

import com.betacom.exception.VeicoliException;



public class Validator {

	public static void validaAnnoProduzione(Integer annoProduzione) throws VeicoliException {
		if (annoProduzione == null) {
            throw new VeicoliException("Anno produzione non caricato");
        }

        int annoCorrente = Year.now().getValue();

        if (annoProduzione < 2000 || annoProduzione > annoCorrente) {
            throw new VeicoliException(
                "L'anno di produzione deve essere compreso tra 2000 e " + annoCorrente
            );
        }
    }

}