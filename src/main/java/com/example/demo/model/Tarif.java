package com.example.demo.model;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarif")
public class Tarif {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "montant")
	private double montant;
	
	
	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name = "durree")
	private LocalTime duree;


	public Tarif(double montant, LocalTime duree) {
		super();
		this.montant = montant;
		this.duree = duree;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public LocalTime getDuree() {
		return duree;
	}


	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}
	
	
	
	
}
