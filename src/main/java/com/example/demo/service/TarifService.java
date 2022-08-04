package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Tarif;
import com.example.demo.repository.TarifRep;

@Service
public class TarifService {
	@Autowired
	TarifRep tarifRep; 
	
	public ArrayList<Tarif> listTarif() {
		
		 List<Tarif> listproduit =  (List<Tarif>) tarifRep.getAll();
		 
		 System.out.println("reto leizy"+listproduit.size());	 
		 ArrayList<Tarif> listproduits = new ArrayList<Tarif>();
		 
		 for (int i = 0; i<listproduit.size();i++) {
			 listproduits.add(listproduit.get(i));
			 System.out.println("reto leizy"+listproduits.size());	
			 
			 System.out.println("reto leizy"+listproduit.get(i).getMontant());	 
		 }
		return listproduits;
		}
	
	

}
