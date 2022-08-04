package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pfvalide")
public class Pfvalide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "idclient")
	private int idclient;
	
	@Column(name = "idpfvirtuel")
	private int idpfvirtuel;
	
	public int getIdpfvirtuel() {
		return idpfvirtuel;
	}

	public void setIdpfvirtuel(int idpfvirtuel) {
		this.idpfvirtuel = idpfvirtuel;
	}

	public Pfvalide(int idclient, int idpfvirtuel, double montant) {
		super();
		this.idclient = idclient;
		this.idpfvirtuel = idpfvirtuel;
		this.montant = montant;
	}

	public Pfvalide() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name = "montant")
	private double montant;

	public Pfvalide(int idclient, double montant) {
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
