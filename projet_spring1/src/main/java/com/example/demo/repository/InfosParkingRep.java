package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.InfosParking;
import com.example.demo.model.Pfnonvalide;

public interface InfosParkingRep extends JpaRepository<InfosParking, Integer> {
	@Query(value = "SELECT * from infosparking ", nativeQuery = true)
	public Iterable<InfosParking> getAll();
		
}
