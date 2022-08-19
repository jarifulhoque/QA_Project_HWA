package com.qa.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.PremierLeague;
import com.qa.main.services.PremierLeagueService;

@RestController
@CrossOrigin
@RequestMapping("/league")
public class PremierLeagueController {

	private PremierLeagueService service;
	
	public PremierLeagueController(PremierLeagueService service) {
		this.service = service;
	}
	
	/* 
	// POST REQUESTS - CREATE
	 * original
	@PostMapping("/create")
	public PremierLeague create(@RequestBody PremierLeague club) {
		return service.create(club); // last entry in the ArrayList
	}
	*/
	
	// with response entity
	@PostMapping("/create") // localhost:8080/create
	public ResponseEntity<PremierLeague> create(@RequestBody PremierLeague club) {
		return new ResponseEntity<PremierLeague>(service.create(club), HttpStatus.CREATED);
	}
	
	
	// GET REQUESTS - READ
	@GetMapping("/getAll")
	public ResponseEntity<List<PremierLeague>> getAll() {
		return new ResponseEntity<List<PremierLeague>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getByID/{id}")
	public ResponseEntity<PremierLeague> getByID(@PathVariable long id) {
		return new ResponseEntity<PremierLeague>(service.getByID(id), HttpStatus.OK);
	}
	
	// query
	@GetMapping("/getByClub/{club}")
	public ResponseEntity<List<PremierLeague>> getByClub(@PathVariable String club){
		return new ResponseEntity<List<PremierLeague>>(service.getByClub(club), HttpStatus.OK);
	}
	
	// PUT REQUESTS - UPDATE
	@PutMapping("/update/{id}") // localhost:8080/update/id
	public ResponseEntity<PremierLeague> update(@PathVariable long id, @RequestBody PremierLeague club) {
		return new ResponseEntity<PremierLeague>(service.update(id, club), HttpStatus.ACCEPTED);
	}
	
	// DELETE REQUESTS - DELETE
//	@DeleteMapping("/delete/{id}") //localhost:8080/delete/id
//	public ResponseEntity<?> delete(@PathVariable long id) {
//		return (service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
//			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	// DELETE REQUESTS - DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);

	}
}
