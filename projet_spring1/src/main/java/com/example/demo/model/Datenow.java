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
@Table(name = "datenow")
public class Datenow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datenowvalue")
	private Date datenowvalue;
	
	@Column(name = "etat")
	private String etat ;

	public Datenow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Datenow(Date datenowvalue, String etat) {
		super();
		this.datenowvalue = datenowvalue;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatenowvalue() {
		return datenowvalue;
	}

	public void setDatenowvalue(Date datenowvalue) {
		this.datenowvalue = datenowvalue;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	

}
