package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Admins;

public interface Adminsrepository extends JpaRepository<Admins, String>
{
	@Query(value = "SELECT count(*) from admins where email = :mailadmin and mdp = :mdpadmin", nativeQuery = true)
	public Iterable<Integer> findCount(String mailadmin,String mdpadmin);
	
	@Query(value = "SELECT count(*) from amende where idvehicule= :idvehicule", nativeQuery = true)
	public Integer countAmende(String idvehicule);
}