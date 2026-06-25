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

import com.betacom.dto.input.MacchinaReq;
import com.betacom.dto.input.ValidationGroups;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.services.interfaces.IMacchinaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/macchina")
public class MacchinaController {
	
	private final IMacchinaServices mtM;
	 
	@PostMapping("create")
	public ResponseEntity<ResponseDTO> create(@RequestBody (required = true) @Validated(ValidationGroups.Create.class) MacchinaReq req) throws Exception{
		mtM.create(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("created...")
				.build());
	}
	
	@PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody (required = true) @Validated(ValidationGroups.Update.class) MacchinaReq req) throws Exception{
        mtM.update(req);
        return ResponseEntity.ok(ResponseDTO.builder()
				.msg("updated...")
				.build());
    }
	
	@DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception{
        mtM.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder()
      	       .msg("deleted...")
			   .build());
    }
	

}
