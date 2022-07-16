package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Amende;

public interface AmendeRep extends JpaRepository<Amende, Integer> {

}
