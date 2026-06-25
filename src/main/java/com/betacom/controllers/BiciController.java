package com.betacom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.dto.input.BiciReq;
import com.betacom.dto.input.ValidationGroups;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.services.interfaces.IBiciServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/bici")
public class BiciController {
	private final IBiciServices mtB;
	 
	 @PostMapping("create")
	    public ResponseEntity<ResponseDTO> create(@RequestBody (required = true) @Validated(ValidationGroups.Create.class) BiciReq req) throws Exception{
	        mtB.create(req);
	        return ResponseEntity.ok(ResponseDTO.builder()
	                .msg("created...")
	                .build());
	    }
	
	    @PutMapping("update")
	    public ResponseEntity<ResponseDTO> update(@RequestBody (required = true) @Validated(ValidationGroups.Update.class) BiciReq req) throws Exception{
	        mtB.update(req);
	        return ResponseEntity.ok(ResponseDTO.builder()
	                .msg("updated...")
	                .build());
	    }
	
	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception{
	        mtB.delete(id);
	        return ResponseEntity.ok(ResponseDTO.builder()
	               .msg("deleted...")
	               .build());
	    }


}

