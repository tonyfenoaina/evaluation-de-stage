package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Situation;

public interface SituationRep extends JpaRepository<Situation, String> {

	@Query(value = "SELECT * from situation ", nativeQuery = true)
	public Iterable<Situation> getAll();
	
	@Query(value = "SELECT * from situation where idvehicule= :id", nativeQuery = true)
	public Situation getparId(String id);
}
