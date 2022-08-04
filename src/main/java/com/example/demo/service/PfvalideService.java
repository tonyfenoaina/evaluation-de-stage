package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pfvalide;
import com.example.demo.model.Pfvirtuelle;
import com.example.demo.repository.PfvalideRepository;
import com.example.demo.repository.PfvirtuelleRepository;
@Service
public class PfvalideService {
	@Autowired
	  PfvalideRepository pfvirtuelleRepository;
	public ArrayList<Pfvalide> listProduit(int va) {
		 List<Pfvalide> listproduit =  (List<Pfvalide>) pfvirtuelleRepository.getAll(va);
		 ArrayList<Pfvalide> listproduits = new ArrayList<Pfvalide>();
		 for (int i = 0; i<listproduit.size();i++) {
			 listproduits.add(listproduit.get(i));
			 System.out.println("reto leizy"+listproduits);	 
		 }
		return listproduits;
		}
}
