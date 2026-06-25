package com.betacom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.FrenoReq;
import com.betacom.dto.input.ValidationGroups;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.services.interfaces.IFrenoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/freno")
public class FrenoController {
	
	private final IFrenoServices serfrn;
	
	 @PostMapping("create")
	    public ResponseEntity<ResponseDTO> create(@RequestBody (required = true) @Validated(ValidationGroups.Create.class) FrenoReq req) throws Exception{
	        serfrn.create(req);
	        return ResponseEntity.ok(ResponseDTO.builder()
	                .msg("created...")
	                .build());
	    }
	 
	 @DeleteMapping("delete/{id}")
	    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception{
	        serfrn.delete(id);
	        return ResponseEntity.ok(ResponseDTO.builder()
	               .msg("deleted...")
	               .build());
	    }

}
