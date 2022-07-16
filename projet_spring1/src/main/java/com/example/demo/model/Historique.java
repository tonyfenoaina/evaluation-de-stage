package com.example.demo.model;

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
@Table(name = "historique")
public class Historique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "numeroparking")
	private int numeroparking ;
	
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
	

}
