package com.betacom.macchina;

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

import com.betacom.dto.input.MacchinaReq;
import com.betacom.dto.output.ResponseDTO;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MacchinaTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	@Test
	@Order(1)
	public void createMacchinaTest() throws Exception{
		log.debug("createMacchinaTest");
		MacchinaReq req = new MacchinaReq();
		req.setAlimentazioneId(3);
		req.setAnnoProduzione(2006);
		req.setNumeroRuote(4);
		req.setColore("nero");
		req.setMarca("Bmw");
		req.setModello("m3");
		req.setCategoriaId(3);
		req.setTipoVeicoloId(3);
		req.setCc(2000);
		req.setTarga("AA123AA");
		req.setNumeroPorte(5);
		
		mockMvc.perform(post("/rest/macchina/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order (2)
	public void updateMacchinaTest() throws Exception {
		log.debug("updateMacchinaTest");
		MacchinaReq req = new MacchinaReq();
		req.setIdMacchina(1);
		req.setAnnoProduzione(2000);
		
		MvcResult result = mockMvc.perform(put("/rest/macchina/update")
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
	public void createMacchinaTestError() throws Exception{
		log.debug("createMacchinaTestError");
		MacchinaReq req = new MacchinaReq();
		req.setAlimentazioneId(3);
		req.setAnnoProduzione(1600);
		req.setNumeroRuote(4);
		req.setColore("nero");
		req.setMarca("Bmw");
		req.setModello("m3");
		req.setCategoriaId(3);
		req.setTipoVeicoloId(3);
		req.setCc(2000);
		req.setTarga("AA123AA");
		req.setNumeroPorte(5);
		
		MvcResult result =  mockMvc.perform(post("/rest/macchina/create")
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
		log.debug("deleteMacchina");
		
		mockMvc.perform(delete("/rest/macchina/delete/" +  "1"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
