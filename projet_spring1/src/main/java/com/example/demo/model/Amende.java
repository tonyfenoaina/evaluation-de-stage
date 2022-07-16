package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Amende")
public class Amende {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "montant")
	private double montant;
	
	@Column(name = "idclient")
	private int idclient;

	public Amende() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amende(double idReservation, int idclient) {
		super();
		this.montant = idReservation;
		this.idclient = idclient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getIdReservation() {
		return montant;
	}

	public void setIdReservation(double idReservation) {
		this.montant = idReservation;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	
	
	
	

}
