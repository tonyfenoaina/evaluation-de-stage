package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Pfvalide;
import com.example.demo.model.Pfvirtuelle;

public interface PfvalideRepository extends JpaRepository<Pfvalide, Integer> {
	
	@Query(value = "SELECT * from pfvalide where idclient = :client order by id desc limit 1 ", nativeQuery = true)
	public Iterable<Pfvalide> getAll(int client);

}
