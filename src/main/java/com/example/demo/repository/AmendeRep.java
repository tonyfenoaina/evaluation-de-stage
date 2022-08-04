package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Amende;

public interface AmendeRep extends JpaRepository<Amende, Integer> {

	@Query(value = "SELECT count(*) from amende where idvehicule= :idvehicule", nativeQuery = true)
	public Integer countAmende(String idvehicule);
}
