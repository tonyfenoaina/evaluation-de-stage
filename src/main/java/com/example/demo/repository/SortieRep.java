package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sortie;

public interface SortieRep extends JpaRepository<Sortie, Integer> {

}
