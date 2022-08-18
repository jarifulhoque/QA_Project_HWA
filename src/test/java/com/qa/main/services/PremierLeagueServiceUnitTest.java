package com.qa.main.services;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.PremierLeague;
import com.qa.main.repos.PremierLeagueRepo;
import com.qa.main.services.PremierLeagueService;

@SpringBootTest
public class PremierLeagueServiceUnitTest {

	@Autowired
	private PremierLeagueService service;
	
	@MockBean
	private PremierLeagueRepo repo;
	
	@Test
	public void create() {
		
		PremierLeague entry = new PremierLeague(2L, "Everton", 40, 200, 56); // 2L added
		
		PremierLeague result = new PremierLeague(2L, "Everton", 40, 200, 56);
		
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		
		assertEquals(result, service.create(entry));
		
	}
	
	@Test
	public void testGetAll() {
		
		List<PremierLeague> result = new ArrayList<>();
		result.add(new PremierLeague(1L, "Liverpool", 60, 300, 97));
		
		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
		
	}
	
	@Test
	public void update() {
		Long id = 1L;
		PremierLeague update = new PremierLeague(1L, "Liverpool", 60, 300, 97);
		Optional<PremierLeague> updateOp = Optional.ofNullable(update);
		
		PremierLeague expected = new PremierLeague(1L, "Liverpool", 60, 300, 97);
		
		Mockito.when(repo.findById(id)).thenReturn(updateOp);
		Mockito.when(repo.saveAndFlush(update)).thenReturn(expected);
		
		assertEquals(expected, service.update(id, update));
	}
	
	@Test
	public void delete() {
		Long id = 1L;
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		
		assertEquals(true, service.delete(id));
	}
	
}
