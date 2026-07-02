package com.betacom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.AlimentazioneReq;
import com.betacom.dto.input.ValidationGroups;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.services.interfaces.IAlimentazioneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/alimentazione")
public class AlimentazioneController {
	
	private final IAlimentazioneServices seraln;
	
	 @PostMapping("create")
	    public ResponseEntity<ResponseDTO> create(@RequestBody (required = true) @Validated(ValidationGroups.Create.class) AlimentazioneReq req) throws Exception{
	        seraln.create(req);
	        return ResponseEntity.ok(ResponseDTO.builder()
	                .msg("created...")
	                .build());
	    }
	 
	 @DeleteMapping("delete/{id}")
	    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception{
	        seraln.delete(id);
	        return ResponseEntity.ok(ResponseDTO.builder()
	               .msg("deleted...")
	               .build());
	    }
	 
	 @GetMapping("/list")
		public ResponseEntity<Object> list() throws Exception{
			return ResponseEntity.ok(seraln.list());
		}

}
