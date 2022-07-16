package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Parking;

public interface ParkingRep extends JpaRepository<Parking, Integer> {

}
