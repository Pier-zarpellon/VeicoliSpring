package com.betacom.categoria;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.betacom.controllers.CategoriaController;
import com.betacom.dto.input.CategoriaReq;
import com.betacom.models.TipoVeicolo;
import com.betacom.repositories.ICategoriaRepositories;
import com.betacom.repositories.ITipoVeicoloRepositories;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CategoriaController catC;
	
	@Autowired
	private ICategoriaRepositories repC;
	
	@Autowired
	private ITipoVeicoloRepositories repTv;
	
	@Test
	@Order(1)
	public void createCategoriaTest1() throws Exception{
		log.debug("createCategoriaTest1");
		CategoriaReq req = new CategoriaReq();
		
		
		req.setDescrizione("corsa");
		TipoVeicolo bici = repTv.findById(1)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(bici));
		
		mockMvc.perform(post("/rest/categoria/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(2)
	public void createCategoriaTest2() throws Exception{
		log.debug("createCategoriaTest2");
		CategoriaReq req = new CategoriaReq();
		
		
		req.setDescrizione("motocross");
		TipoVeicolo moto = repTv.findById(2)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(moto));
		
		mockMvc.perform(post("/rest/categoria/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(3)
	public void createCategoriaTest3() throws Exception{
		log.debug("createCategoriaTest3");
		CategoriaReq req = new CategoriaReq();
		
		
		req.setDescrizione("sportiva");
		TipoVeicolo macchina = repTv.findById(3)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(macchina));
		
		mockMvc.perform(post("/rest/categoria/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(4)
	public void createCategoriaTest4() throws Exception{
		log.debug("createCategoriaTest4");
		CategoriaReq req = new CategoriaReq();
		
		
		req.setDescrizione("montagna");
		TipoVeicolo macchina = repTv.findById(3)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(macchina));
		
		mockMvc.perform(post("/rest/categoria/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(5)
	public void deleteCategoria() throws Exception{
		log.debug("deleteCategoria");
		
		mockMvc.perform(delete("/rest/categoria/delete/" +  "4"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
