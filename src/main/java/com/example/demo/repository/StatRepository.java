package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Stat;

public interface StatRepository extends JpaRepository<Stat, String> {

	
	
}
