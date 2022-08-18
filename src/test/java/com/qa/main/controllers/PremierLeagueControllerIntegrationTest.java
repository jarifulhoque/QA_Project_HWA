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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.PremierLeague;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PremierLeagueControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception{
		PremierLeague entry = new PremierLeague("Everton", 40, 200, 56);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		PremierLeague result = new PremierLeague(2L, "Everton", 40, 200, 56);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/league/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception{
		List<PremierLeague> result = new ArrayList<>();
		result.add(new PremierLeague(1L, "Liverpool", 60, 300, 97));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/league/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
//	@Test
//	public void readByIdTest() throws Exception{
//		List<PremierLeague> result = new ArrayList<>();
//		result.add(new PremierLeague(1L, "Liverpool", 60, 300, 97));
//		String resultAsJSON = mapper.writeValueAsString(result);
//		
//		mvc.perform(get("/league/getById/1")
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(content().json(resultAsJSON));	
//	}
	
	@Test
	public void updateTest() throws Exception{
		PremierLeague result = new PremierLeague(1L, "Liverpool", 60, 300, 97);
		String resultAsJSON = mapper.writeValueAsString(result);
		
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
	
	@Test
	public void ExceptionTest() throws Exception {
		mvc.perform(get("/league/getById/100")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		
	}
	
}