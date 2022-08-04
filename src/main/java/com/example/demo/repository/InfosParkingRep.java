package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.InfosParking;
import com.example.demo.model.Pfnonvalide;

public interface InfosParkingRep extends JpaRepository<InfosParking, Integer> {
	@Query(value = "SELECT * from infosparking ", nativeQuery = true)
	public Iterable<InfosParking> getAll();
	
	@Query(value = "SELECT * from infosparking where idreservation = :id", nativeQuery = true)
	public Iterable<InfosParking> getbyidres(int id);
	
	@Query(value = "SELECT * from infosparking where idclient = :idclient and type='infraction' ", nativeQuery = true)
	public Iterable<InfosParking> getAmendeParClient(int idclient);
	
	@Query(value = "SELECT count(*) from infosparking where idclient = :idclient and type='infraction' ", nativeQuery = true)
	public Iterable<Integer> getNombreInfractionParClient(int idclient);
	
	@Query(value = "SELECT count(*) from infosparking group by type", nativeQuery = true)
	public Iterable<Integer> getNombreParType();
		
	
	
}
