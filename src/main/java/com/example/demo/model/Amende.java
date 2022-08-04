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
	
	@Column(name = "idreservation")
	private int idreservation;
	
	@Column(name = "idvehicule")
	private String idvehicule;
	
	
	public Amende(int idreservation, String idvehicule, double montant, int idclient) {
		super();
		this.idreservation = idreservation;
		this.idvehicule = idvehicule;
		this.montant = montant;
		this.idclient = idclient;
	}

	@Column(name = "montant")
	private double montant;
	
	@Column(name = "idclient")
	private int idclient;

	public Amende() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amende(int idreservation, double montant, int idclient) {
		super();
		this.idreservation = idreservation;
		this.montant = montant;
		this.idclient = idclient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdreservation() {
		return idreservation;
	}

	public void setIdreservation(int idreservation) {
		this.idreservation = idreservation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}


	
	
	

}
