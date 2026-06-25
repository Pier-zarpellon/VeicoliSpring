package com.betacom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.SospensioneReq;
import com.betacom.dto.input.ValidationGroups;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.services.interfaces.ISospensioneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/sospensione")
public class SospensioneController {
	
	private final ISospensioneServices sersop;
	
	 @PostMapping("create")
	    public ResponseEntity<ResponseDTO> create(@RequestBody (required = true) @Validated(ValidationGroups.Create.class) SospensioneReq req) throws Exception{
	        sersop.create(req);
	        return ResponseEntity.ok(ResponseDTO.builder()
	                .msg("created...")
	                .build());
	    }
	 
	 @DeleteMapping("delete/{id}")
	    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception{
	        sersop.delete(id);
	        return ResponseEntity.ok(ResponseDTO.builder()
	               .msg("deleted...")
	               .build());
	    }


}
