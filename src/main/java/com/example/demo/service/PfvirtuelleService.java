package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pfvirtuelle;

import com.example.demo.repository.PfvirtuelleRepository;


@Service
public class PfvirtuelleService {
	@Autowired
	  PfvirtuelleRepository pfvirtuelleRepository;
	public ArrayList<Pfvirtuelle> listProduit() {
		 List<Pfvirtuelle> listproduit =  (List<Pfvirtuelle>) pfvirtuelleRepository.getAll();
		 ArrayList<Pfvirtuelle> listproduits = new ArrayList<Pfvirtuelle>();
		 for (int i = 0; i<listproduit.size();i++) {
			 listproduits.add(listproduit.get(i));
			 System.out.println("reto leizy"+listproduits);	 
		 }
		return listproduits;
		}
}
