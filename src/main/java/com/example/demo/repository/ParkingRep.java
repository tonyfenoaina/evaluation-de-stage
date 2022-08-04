package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Parking;

public interface ParkingRep extends JpaRepository<Parking, Integer> {

	@Query(value = "SELECT count(*) from infosparking where etat= 'desactive' and type = 'libre' ", nativeQuery = true)
	public Integer getDesactive();
	
}
