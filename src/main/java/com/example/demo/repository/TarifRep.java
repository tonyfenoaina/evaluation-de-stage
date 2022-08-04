package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Tarif;

public interface TarifRep extends JpaRepository<Tarif, Integer> {

	@Query(value = "SELECT * from Tarif ", nativeQuery = true)
	public Iterable<Tarif> getAll();
}
