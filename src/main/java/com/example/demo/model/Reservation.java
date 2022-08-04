package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "idparking")
	private int idParking;
	
	@Column(name = "idclient")
	private int idClient;
	
	
	@Column(name = "idtarif")
	private int idtarif ;
	

	@Column(name = "idvehicule")
	private String  idVehicule;
	
	@Column(name = "montant")
	private double  montant;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datedebut")
	private Date dateDebut;
	
	
	
	
	
	
	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public Reservation(int idParking, int idClient, int idtarif, String idVehicule, double montant, Date dateDebut) {
		super();
		this.idParking = idParking;
		this.idClient = idClient;
		this.idtarif = idtarif;
		this.idVehicule = idVehicule;
		this.montant = montant;
		this.dateDebut = dateDebut;
	}



	public Reservation(int idParking, int idtarif, String idVehicule) {
		super();
		this.idParking = idParking;
		this.idtarif = idtarif;
		this.idVehicule = idVehicule;
	}
	
	

	public Reservation(int idParking, int idClient, int idtarif, String idVehicule, Date dateDebut) {
		super();
		this.idParking = idParking;
		this.idClient = idClient;
		this.idtarif = idtarif;
		this.idVehicule = idVehicule;
		this.dateDebut = dateDebut;
	}



	public Reservation(int idParking, int idClient, int idtarif, String idVehicule) {
		super();
		this.idParking = idParking;
		this.idClient = idClient;
		this.idtarif = idtarif;
		this.idVehicule = idVehicule;
	}



	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public int getIdtarif() {
		return idtarif;
	}



	public void setIdtarif(int idtarif) {
		this.idtarif = idtarif;
	}



	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int idParking, String idVehicule, Date dateDebut) {
		super();
		this.idParking = idParking;
		this.idVehicule = idVehicule;
		this.dateDebut = dateDebut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdParking() {
		return idParking;
	}

	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}

	public String getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(String idVehicule) {
		this.idVehicule = idVehicule;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	
	

}
