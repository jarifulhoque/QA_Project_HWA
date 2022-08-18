package com.qa.main.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.qa.main.domain.PremierLeague;
import com.qa.main.exceptions.ClubNotFoundException;
import com.qa.main.repos.PremierLeagueRepo;

@Service
public class PremierLeagueService {

	private PremierLeagueRepo repo;
	
	public PremierLeagueService(PremierLeagueRepo repo) {
		this.repo = repo;
	}
	
	// POST REQUESTS - CREATE

	public PremierLeague create(PremierLeague entry) {
		return repo.saveAndFlush(entry);
	}
	
	// GET REQUESTS - READ

	public List<PremierLeague>getAll(){
		return repo.findAll();
	}
	
	public PremierLeague getByID(long id){
		return repo.findById(id).orElseThrow(ClubNotFoundException::new);
	}
	
	// return list of clubs- query
	public List<PremierLeague> getByClub(String club){
		return repo.findByClub(club);
	}
	
	// PUT REQUESTS - UPDATE
	
	public PremierLeague update(long id, PremierLeague club) {
		PremierLeague existing = repo.findById(id).get();
		existing.setClub(club.getClub());
		existing.setClubValue(club.getClubValue());
		existing.setPoints(club.getPoints());
		existing.setStadiumCapacity(club.getStadiumCapacity());
		
		return repo.saveAndFlush(existing);
	}
	
	
	// DELETE REQUESTS - DELETE
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
