package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Parking")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "taille")
	private Double taille;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "etat")
	private String etat;
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTaille() {
		return taille;
	}

	public void setTaille(Double taille) {
		this.taille = taille;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Parking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parking(Double taille, int numero) {
		super();
		this.taille = taille;
		this.numero = numero;
	}

	public Parking(Double taille, int numero, String etat) {
		super();
		this.taille = taille;
		this.numero = numero;
		this.etat = etat;
	}
	
}
