package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PremierLeague {

	//Columns
	
	@Id // primary key indicator
	@GeneratedValue(strategy = GenerationType.IDENTITY) // incrementing ids
	private long id;
	
	//@Column(name = "Club Name", unique = true, nullable = false) // pick a custom name
	private String club; // VARCHAR
	
	//@Column(name = "Stadium Capacity", unique = true, nullable = false) // unique constraint
	private long stadiumCapacity;
	
	//@Column(name = "Club Value", unique = true, nullable = false) // not null constraint. can be chained using commas
	private long clubValue;
	
	// @Column(length= 114) // max number
	//@Column(name = "Points", unique = true, nullable = false)
	private int points;

	
	// Constructors - 3 required. default. read. create.
	
	// Default Constructor
	public PremierLeague() {
		
	}
	
	// For Reading
	public PremierLeague(long id, String club, long stadiumCapacity, long clubValue, int points) {
		super();
		this.id = id;
		this.club = club;
		this.stadiumCapacity = stadiumCapacity;
		this.clubValue = clubValue;
		this.points = points;
	}
	
	// For Creating (without id)
	
	public PremierLeague(String club, long stadiumCapacity, long clubValue, int points) {
		super();
		this.club = club;
		this.stadiumCapacity = stadiumCapacity;
		this.clubValue = clubValue;
		this.points = points;
	}
	
	
	
	// Getters & Setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public long getStadiumCapacity() {
		return stadiumCapacity;
	}

	public void setStadiumCapacity(long stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}

	public long getClubValue() {
		return clubValue;
	}

	public void setClubValue(long clubValue) {
		this.clubValue = clubValue;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		return Objects.hash(club, clubValue, id, points, stadiumCapacity);
	}

	// Override methods - used for testing
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremierLeague other = (PremierLeague) obj;
		return Objects.equals(club, other.club) && clubValue == other.clubValue && id == other.id
				&& points == other.points && stadiumCapacity == other.stadiumCapacity;
	}
	

}
