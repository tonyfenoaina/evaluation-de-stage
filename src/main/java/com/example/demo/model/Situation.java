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
@Immutable
@Table(name = "situation")
public class Situation {
	
	@Id
	@Column(name = "idvehicule")
	
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datedebut")
	private Date datedebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datesortie")
	private Date datesortie;
	
	@Column(name = "type")
	private String type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatesortie() {
		return datesortie;
	}

	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public LocalTime getDurree() {
		return durree;
	}

	public void setDurree(LocalTime durree) {
		this.durree = durree;
	}

	public int getAmende() {
		return amende;
	}

	public void setAmende(int amende) {
		this.amende = amende;
	}

	@Column(name = "montanttarif")
	private double montanttarif;
	
	@Column(name = "montant")
	private double montant;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datefin")
	private Date datefin;
	
	@Column(name = "durree")
	private LocalTime durree;
	
	@Column(name = "durreenormaltarif")
	private LocalTime durreenormaltarif;
	
	@Column(name = "amende")
	private int amende;

	public double getMontanttarif() {
		return montanttarif;
	}

	public void setMontanttarif(double montanttarif) {
		this.montanttarif = montanttarif;
	}

	public LocalTime getDurreenormaltarif() {
		return durreenormaltarif;
	}

	public void setDurreenormaltarif(LocalTime durreenormaltarif) {
		this.durreenormaltarif = durreenormaltarif;
	}

	public Situation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
