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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Sortie")
public class Sortie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "idreservation")
	private int idReservation;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datesortie")
	private Date datesortie;
	
	
	public Sortie(int idReservation, Date datesortie) {
		super();
		this.idReservation = idReservation;
		this.datesortie = datesortie;
	}

	public Date getDatesortie() {
		return datesortie;
	}

	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public Sortie(int idReservation) {
		super();
		this.idReservation = idReservation;
	}

	public Sortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

}
