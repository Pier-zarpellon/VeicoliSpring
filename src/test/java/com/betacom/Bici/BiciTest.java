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

import com.betacom.controllers.BiciController;
import com.betacom.dto.input.BiciReq;
import com.betacom.dto.output.ResponseDTO;
import com.betacom.repositories.ITipoVeicoloRepositories;

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
	
	@Autowired
	private BiciController biciC;
	
	@Autowired
	private ITipoVeicoloRepositories tipoVeicoloRepository;
	
	
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
	@Order(4)
	public void createBiciTestError2() throws Exception{
		log.debug("createBiciTestError2");
		BiciReq req = new BiciReq();
		req.setAlimentazioneId(1);
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
	public void updateBiciTestError() throws Exception{
		log.debug("updateBiciTestError");
		BiciReq req = new BiciReq();
		req.setIdBici(1);
		req.setCategoriaId(10);
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
		
	}
	
	@Test
	@Order(6)
	public void updateBiciTestError2() throws Exception{
		log.debug("updateBiciTestError");
		BiciReq req = new BiciReq();
		req.setCategoriaId(1);;
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
		
	}
	
	@Test
	@Order(7)
	public void updateBiciTestError3() throws Exception{
		log.debug("updateBiciTestError");
		BiciReq req = new BiciReq();
		req.setIdBici(1);
		req.setAlimentazioneId(10);
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
		
	}
	
	@Test
	@Order(8)
	public void updateBiciTestError4() throws Exception{
		log.debug("updateBiciTestError");
		BiciReq req = new BiciReq();
		req.setIdBici(1);
		req.setSospensioneId(10);
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
		
	}
	
	@Test
	@Order(9)
	public void updateBiciTestError5() throws Exception{
		log.debug("updateBiciTestError");
		BiciReq req = new BiciReq();
		req.setIdBici(1);
		req.setFrenoId(10);
		
		MvcResult result =  mockMvc.perform(post("/rest/bici/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
		
	}
	

	@Test
	@Order(10)
	public void deleteBici() throws Exception{
		log.debug("deleteBici");
		
		mockMvc.perform(delete("/rest/bici/delete/" +  "1"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
