package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amendepaye")
public class AmendePayee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "idclient")
	private int idclient;

	@Column(name = "idamende")
	private int idAmende;

	public AmendePayee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public int getIdAmende() {
		return idAmende;
	}

	public void setIdAmende(int idAmende) {
		this.idAmende = idAmende;
	}

	public AmendePayee(int idclient, int idAmende) {
		super();
		this.idclient = idclient;
		this.idAmende = idAmende;
	}
	
	
	
	
	
}
