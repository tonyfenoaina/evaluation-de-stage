package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AmendePayee;

public interface AmendePayeRep extends JpaRepository<AmendePayee, Integer> {
	
}
