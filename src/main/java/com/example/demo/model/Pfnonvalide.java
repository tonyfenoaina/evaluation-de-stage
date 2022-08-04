package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "pfnonvalide")
public class Pfnonvalide {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "pfvirtuelle")
	private int pfvirtuelle;
	
	public int getPfvirtuelle() {
		return pfvirtuelle;
	}

	public void setPfvirtuelle(int pfvirtuelle) {
		this.pfvirtuelle = pfvirtuelle;
	}

	public Pfnonvalide(String nom, int pfvirtuelle, String prenom, double montant) {
		super();
		this.nom = nom;
		this.pfvirtuelle = pfvirtuelle;
		this.prenom = prenom;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pfnonvalide() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "montant")
	private double montant;
	
}
