package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Pfvirtuelle;

public interface PfnonvalideRepository extends JpaRepository<Pfnonvalide, Integer>{
	@Query(value = "SELECT * from Pfnonvalide ", nativeQuery = true)
	public Iterable<Pfnonvalide> getAll();
}
