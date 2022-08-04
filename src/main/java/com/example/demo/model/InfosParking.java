package com.example.demo.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "infosparking")
public class InfosParking {
	
	@Id
	private int id;
	
	@Column(name = "numeroparking")
	private int numeroparking ;
	
	@Column(name = "etat")
	private String etat ;
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Column(name = "idvehicule")
	private String idvehicule ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datedebut")
	private Date datedebut ;
	
	@Column(name = "durree")
	private LocalTime durree ;
	
	@Column(name = "idclient")
	private int idclient ;
	
	@Column(name = "idsortie")	
	private int idsortie ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datefin")	
	private Date datefin ;
	
	@Column(name = "delaidepart")	
	private String  delaidepart ;
	
	@Column(name = "idreservation")
	private int idreservation ;
	
	@Column(name = "nom")
	private String nom ;
	
	@Column(name = "prenom")
	private String prenom ;
	
	@Column(name = "montant")
	private double montant ;
	
	@Column(name = "type")
	private String type ;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getDelaidepart() {
		return delaidepart;
	}

	public void setDelaidepart(String delaidepart) {
		this.delaidepart = delaidepart;
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

	
	
	
	public int getIdreservation() {
		return idreservation;
	}

	public void setIdreservation(int idreservation) {
		this.idreservation = idreservation;
	}

	
	
	
	

	public int getIdsortie() {
		return idsortie;
	}

	public void setIdsortie(int idsortie) {
		this.idsortie = idsortie;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroparking() {
		return numeroparking;
	}

	public void setNumeroparking(int numeroparking) {
		this.numeroparking = numeroparking;
	}

	public String getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(String idvehicule) {
		this.idvehicule = idvehicule;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public LocalTime getDurree() {
		return durree;
	}

	public void setDurree(LocalTime durree) {
		this.durree = durree;
	}

	public InfosParking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InfosParking(int numeroparking, String idvehicule, Date datedebut, LocalTime durree) {
		super();
		this.numeroparking = numeroparking;
		this.idvehicule = idvehicule;
		this.datedebut = datedebut;
		this.durree = durree;
	}



}
