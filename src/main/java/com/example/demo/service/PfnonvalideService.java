package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pfnonvalide;
import com.example.demo.model.Pfvirtuelle;
import com.example.demo.repository.PfnonvalideRepository;
import com.example.demo.repository.PfvirtuelleRepository;

@Service
public class PfnonvalideService {
	@Autowired
	  PfnonvalideRepository pfvirtuelleRepository;
	public ArrayList<Pfnonvalide> listProduit() {
		
		 List<Pfnonvalide> listproduit =  (List<Pfnonvalide>) pfvirtuelleRepository.getAll();
		 
		 System.out.println("reto leizy"+listproduit.size());	 
		 ArrayList<Pfnonvalide> listproduits = new ArrayList<Pfnonvalide>();
		 
		 for (int i = 0; i<listproduit.size();i++) {
			 listproduits.add(listproduit.get(i));
			 System.out.println("reto leizy"+listproduits.size());	
			 
			 System.out.println("reto leizy"+listproduit.get(i).getMontant());	 
		 }
		return listproduits;
		}
}