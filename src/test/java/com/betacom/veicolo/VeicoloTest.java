package com.betacom.veicolo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VeicoloTest {
	  @Autowired
	    private MockMvc mockMvc;

	    @Test
	    @Order(1)
	    public void testListVeicoli_AllParams() throws Exception {

	        mockMvc.perform(get("/rest/veicoli/list")
	                .param("tipoVeicolo", "moto")
	                .param("colore", "blu")
	                .param("alimentazione", "benzina")
	                .param("categoria", "strada")
	        )
	        .andExpect(status().isOk());
	    }
}
