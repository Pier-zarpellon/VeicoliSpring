package com.betacom.tipoveicolo;

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

import com.betacom.dto.input.TipoVeicoloReq;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TipoVeicoloTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	@Test
	@Order(1)
	public void createTipoVeicoloTest() throws Exception{
		List<String> lA = List.of("bici", "moto", "macchina", "treno");
		lA.forEach(a -> {
			TipoVeicoloReq req = new TipoVeicoloReq();
			req.setNome(a);
			
			try {
				mockMvc.perform(post("/rest/tipoveicolo/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(req))
						).andExpect(status().isOk());
			} catch (Exception e) {
				log.error("Error in create {}", e.getMessage());
			}
		});	
		
	}
	
	@Test
	@Order(2)
	public void deleteTipoVeicolo() throws Exception{
		log.debug("deleteTipoVeicolo");
		
		mockMvc.perform(delete("/rest/tipoveicolo/delete/" +  "4"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

}
