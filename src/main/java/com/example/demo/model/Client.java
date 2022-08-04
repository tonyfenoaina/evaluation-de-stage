package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nom")
	private String nom;

	public Client(String nom, String prenomadmin, String mail, String mdp) {
		super();
		this.nom = nom;
		this.prenomadmin = prenomadmin;
		this.mail = mail;
		this.mdp = mdp;
	}

	@Column(name = "prenom", length = 20)
	private String prenomadmin;

	@Column(name = "email")
	private String mail ;

	@Column(name = "mdp")
	private String mdp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenomadmin() {
		return prenomadmin;
	}

	public void setPrenomadmin(String prenomadmin) {
		this.prenomadmin = prenomadmin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	


	
	
}
