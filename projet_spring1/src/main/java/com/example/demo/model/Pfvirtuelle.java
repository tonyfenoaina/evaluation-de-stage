package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pfvirtuelle")
public class Pfvirtuelle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "idclient")
	private int idclient;
	
	public Pfvirtuelle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pfvirtuelle(int id, int idclient, double montant) {
		super();
		this.id = id;
		this.idclient = idclient;
		this.montant = montant;
	}

	@Column(name = "montant")
	private double montant;

	public Pfvirtuelle(int idclient, double montant) {
		super();
		this.idclient = idclient;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
