package com.betacom.Bici;

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

import com.betacom.dto.input.BiciReq;
import com.betacom.dto.output.ResponseDTO;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BiciTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	
	@Test
	@Order(1)
	public void createBiciTest() throws Exception{
		log.debug("createBiciTest");
		BiciReq req = new BiciReq();
		req.setAlimentazioneId(1);
		req.setAnnoProduzione(2006);
		req.setNumeroMarce(2);
		req.setNumeroRuote(2);
		req.setColore("bianco");
		req.setMarca("ktm");
		req.setModello("d4");
		req.setCategoriaId(1);
		req.setFrenoId(1);
		req.setPieghevole(false);
		req.setSospensioneId(1);
		req.setTipoVeicoloId(1);
		
		mockMvc.perform(post("/rest/bici/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order (2)
	public void updateBiciTest() throws Exception {
		log.debug("updateBiciTest");
		BiciReq req = new BiciReq();
		req.setIdBici(1);
		req.setAnnoProduzione(2000);
		
		MvcResult result = mockMvc.perform(put("/rest/bici/update")
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
	public void createBiciTestError() throws Exception{
		log.debug("createBiciTestError");
		BiciReq req = new BiciReq();
		req.setAlimentazioneId(1);
		req.setAnnoProduzione(1600);
		req.setNumeroMarce(2);
		req.setNumeroRuote(2);
		req.setColore("bianco");
		req.setMarca("ktm");
		req.setModello("d4");
		req.setCategoriaId(1);
		req.setFrenoId(1);
		req.setPieghevole(false);
		req.setSospensioneId(1);
		req.setTipoVeicoloId(1);
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/create")
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
	public void deleteBici() throws Exception{
		log.debug("deleteBici");
		
		mockMvc.perform(delete("/rest/bici/delete/" +  "1"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
