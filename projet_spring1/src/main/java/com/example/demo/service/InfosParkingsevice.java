package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InfosParking;
import com.example.demo.model.Pfnonvalide;
import com.example.demo.repository.InfosParkingRep;

@Service
public class InfosParkingsevice {
	@Autowired
	InfosParkingRep ifr;
	
	public ArrayList<InfosParking> listProduit() {
		
		 List<InfosParking> listproduit =  (List<InfosParking>) ifr.getAll();
		 
		 System.out.println("reto leizy"+listproduit.size());	 
		 ArrayList<InfosParking> listproduits = new ArrayList<InfosParking>();
		 
		 for (int i = 0; i<listproduit.size();i++) {
			 
				//if (listproduit.get(i).getIdsortie() == 0) {
					 listproduits.add(listproduit.get(i));
					 
			//}
			 
					 
		 }
		return listproduits;
		}
}
