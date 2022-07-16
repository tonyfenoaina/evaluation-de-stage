package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query(value = "SELECT count(*) from client where email = :mailadmin and mdp = :mdpadmin", nativeQuery = true)
	public Iterable<Integer> Login(String mailadmin,String mdpadmin);
	
	@Query(value = "SELECT id from client where email = :mailadmin and mdp = :mdpadmin", nativeQuery = true)
	public Iterable<Integer> getId(String mailadmin,String mdpadmin);
		
}
