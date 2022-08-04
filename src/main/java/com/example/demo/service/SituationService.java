package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Situation;
import com.example.demo.repository.SituationRep;

@Controller
public class SituationService {
	@Autowired
	SituationRep situationRep;
	
	
	public ArrayList<Situation> listProduit() {
		
		 List<Situation> listproduit =  (List<Situation>) situationRep.getAll();
		 
		 System.out.println("reto leizy"+listproduit.size());	 
		 ArrayList<Situation> listproduits = new ArrayList<Situation>();
		 
		 for (int i = 0; i<listproduit.size();i++) {
			 listproduits.add(listproduit.get(i));
			 System.out.println("reto leizy"+listproduits.size());	
			 
			 
		 }
		return listproduits;
		}

}
