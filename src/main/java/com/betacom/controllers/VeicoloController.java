package com.betacom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.services.interfaces.IVeicoloServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/veicoli")
public class VeicoloController {
	
private final IVeicoloServices veS;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(
	        @RequestParam (required = false)  String TipoVeicolo,
	        @RequestParam (required = false)  String colore,
	        @RequestParam (required = false)  String alimentazione,
	        @RequestParam (required = false)  String categoria,
	        @RequestParam (required = false)  String targa,
	        @RequestParam (required = false)  Integer idVeicolo
	        ) throws Exception{
	        return ResponseEntity.ok(veS.list(TipoVeicolo, colore, alimentazione, categoria, targa, idVeicolo));
	}
	
	


}
