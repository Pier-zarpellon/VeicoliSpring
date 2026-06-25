package com.betacom.alimentazione;

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

import com.betacom.dto.input.AlimentazioneReq;
import com.betacom.models.TipoVeicolo;
import com.betacom.repositories.ITipoVeicoloRepositories;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlimentazioneTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	@Autowired
	private ITipoVeicoloRepositories repTv;
	
	@Test
	@Order(1)
	public void createAlimentazioneTest() throws Exception{
		log.debug("createAlimentazioneTest");
		AlimentazioneReq req = new AlimentazioneReq();
		req.setDescrizione("manuale");
		
		TipoVeicolo bici = repTv.findById(1)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(bici));
		
		mockMvc.perform(post("/rest/alimentazione/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(2)
	public void createAlimentazioneTest2() throws Exception{
		log.debug("createAlimentazioneTest2");
		AlimentazioneReq req = new AlimentazioneReq();
		req.setDescrizione("benzina");
		
		TipoVeicolo moto = repTv.findById(2)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(moto));
		
		mockMvc.perform(post("/rest/alimentazione/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(3)
	public void createAlimentazioneTest3() throws Exception{
		log.debug("createAlimentazioneTest3");
		AlimentazioneReq req = new AlimentazioneReq();
		req.setDescrizione("diesel");
		
		TipoVeicolo macchina = repTv.findById(3)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(macchina));
		
		mockMvc.perform(post("/rest/alimentazione/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(4)
	public void createAlimentazioneTest4() throws Exception{
		log.debug("createAlimentazioneTest4");
		AlimentazioneReq req = new AlimentazioneReq();
		req.setDescrizione("elettrica");
		
		TipoVeicolo macchina = repTv.findById(3)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(macchina));
		
		mockMvc.perform(post("/rest/alimentazione/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	@Test
	@Order(5)
	public void createAlimentazioneTest5() throws Exception{
		log.debug("createAlimentazioneTest5");
		AlimentazioneReq req = new AlimentazioneReq();
		req.setDescrizione("acqua");
		
		TipoVeicolo macchina = repTv.findById(3)
		        .orElseThrow(() -> new RuntimeException("TipoVeicolo non trovato"));
		req.setTipiVeicolo(List.of(macchina));
		
		mockMvc.perform(post("/rest/alimentazione/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}
	
	
	
	@Test
	@Order(6)
	public void deleteAlimentazione() throws Exception{
		log.debug("deleteAlimentazione");
		
		mockMvc.perform(delete("/rest/alimentazione/delete/" +  "4"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
