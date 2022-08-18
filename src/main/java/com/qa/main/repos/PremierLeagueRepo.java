package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.PremierLeague;

@Repository
public interface PremierLeagueRepo extends JpaRepository<PremierLeague, Long>{
	
	// SELECT * from PremierLeague where club = '[name]';
	List<PremierLeague> findByClub(String club);
	
//	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery=true)
//	Optional<User> findByUsername(String username);

	
}
