package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Pfvirtuelle;


public interface PfvirtuelleRepository extends JpaRepository<Pfvirtuelle, Integer>{

	
	@Query(value = "SELECT * from pfvirtuelle ", nativeQuery = true)
	public Iterable<Pfvirtuelle> getAll();
}
