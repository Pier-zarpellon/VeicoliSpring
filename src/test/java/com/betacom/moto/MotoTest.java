package com.betacom.moto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.betacom.dto.input.MotoReq;
import com.betacom.dto.output.ResponseDTO;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MotoTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	
	@Test
	@Order(1)
	public void createMotoTest() throws Exception{
		log.debug("createMotoTest");
		MotoReq req = new MotoReq();
		req.setAlimentazioneId(2);
		req.setAnnoProduzione(2006);
		req.setNumeroRuote(2);
		req.setColore("nero");
		req.setMarca("Aprilia");
		req.setModello("rsv4");
		req.setCategoriaId(2);
		req.setTipoVeicoloId(2);
		req.setCc(2000);
		req.setTarga("AA12345");
		
		mockMvc.perform(post("/rest/moto/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order (2)
	public void updateMotoTest() throws Exception {
		log.debug("updateMotoTest");
		MotoReq req = new MotoReq();
		req.setIdMoto(1);
		req.setAnnoProduzione(2000);
		
		MvcResult result = mockMvc.perform(put("/rest/moto/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isOk())
		.andReturn();

		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
	}
	
	@Test
	@Order(3)
	public void createMotoTestError() throws Exception{
		log.debug("createMotoTestError");
		MotoReq req = new MotoReq();
		req.setAlimentazioneId(2);
		req.setAnnoProduzione(1600);
		req.setNumeroRuote(2);
		req.setColore("nero");
		req.setMarca("Aprilia");
		req.setModello("rsv4");
		req.setCategoriaId(2);
		req.setTipoVeicoloId(2);
		req.setCc(2000);
		req.setTarga("AA12345");
		
		MvcResult result =  mockMvc.perform(post("/rest/moto/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc create :{}", dto.getMsg());
		
	}
	

	@Test
	@Order(5)
	public void deleteMoto() throws Exception{
		log.debug("deleteMoto");
		
		mockMvc.perform(delete("/rest/moto/delete/" +  "1"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}


}
