package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Datenow;
import com.example.demo.model.InfosParking;

public interface DatenowRep extends JpaRepository<Datenow, Integer>{
	
	@Query(value = "SELECT * from datenow order by id desc limit 1 ", nativeQuery = true)
	public Iterable<Datenow> getAll();
	
	@Query(value = "SELECT getDatenowAmn18h(:datedebut)", nativeQuery = true)
	public Date getDatenowAmn18h(Date datedebut);
	
	@Query(value = "SELECT getDateAmn6rahampitso(:datedebut)", nativeQuery = true)
	public Date getDateAmn6rahampitso(Date datedebut);

}
