package com.betacom.freno;

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

import com.betacom.dto.input.FrenoReq;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FrenoTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	@Order(1)
	public void createfrenoTest() throws Exception{
		log.debug("createFrenoTest");
		
	
		List<String> lA = List.of("tamburo", "disco");
		lA.forEach(a -> {
			FrenoReq req = new FrenoReq();
			req.setDescrizioneFreno(a);
			
			try {
				mockMvc.perform(post("/rest/freno/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(req))
						).andExpect(status().isOk());
			} catch (Exception e) {
				log.error("Error in create {}", e.getMessage());
			}
		});	

	}
	
	@Test
	@Order(5)
	public void deleteFreno() throws Exception{
		log.debug("deleteFreno");
		
		mockMvc.perform(delete("/rest/freno/delete/" +  "2"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}
	

}