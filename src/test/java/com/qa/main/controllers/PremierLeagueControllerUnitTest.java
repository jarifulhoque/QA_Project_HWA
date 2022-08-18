package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.PremierLeague;
import com.qa.main.services.PremierLeagueService;

@WebMvcTest
public class PremierLeagueControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private PremierLeagueService service;
	
	@Test
	public void createTest() throws Exception{
		PremierLeague entry = new PremierLeague("Everton", 40, 200, 56);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		PremierLeague result = new PremierLeague(2L, "Everton", 40, 200, 56);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.create(entry)).thenReturn(result);
		
		mvc.perform(post("/league/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	void getAllTest() throws Exception {
				List<PremierLeague> result = new ArrayList<>();
			
				result.add(new PremierLeague("Everton", 40, 200, 56));
				
				Mockito.when(service.getAll()).thenReturn(result);
				String resultAsJSON = mapper.writeValueAsString(result);
				mvc.perform(get("/league/getAll")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	void updateTest() throws Exception {

		PremierLeague result = new PremierLeague("Everton", 40, 200, 56);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.update(1L, result)).thenReturn(result);
		
		mvc.perform(put("/league/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(resultAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception{
		mvc.perform(delete("/league/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
	
}





