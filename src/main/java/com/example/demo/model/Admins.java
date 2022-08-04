package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admins")
public class Admins {
	@Id
	private String id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenomadmin;

	@Column(name = "email")
	private String mail ;

	@Column(name = "mdp")
	private String mdp;


}