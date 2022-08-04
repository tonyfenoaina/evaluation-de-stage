package com.example.demo.repository;

import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reservation;

public interface ReservationRep extends JpaRepository<Reservation, Integer> {
	@Query(value = "SELECT getVolaPayena(:payant)", nativeQuery = true)
	public Double getVolaPayena(Time payant);
}
