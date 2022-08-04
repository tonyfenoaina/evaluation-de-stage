package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Datenow;
import com.example.demo.model.InfosParking;
import com.example.demo.repository.DatenowRep;

@Service
public class DatenowService {
	@Autowired
	DatenowRep datenowRep;
	
	public ArrayList<Datenow> getdateNow() {	
		 List<Datenow> listproduit =  (List<Datenow>) datenowRep.getAll();	 
		 System.out.println("reto leizy"+listproduit.size());	
		 
		 ArrayList<Datenow> listproduits = new ArrayList<Datenow>();
		 
		 for (int i = 0; i<listproduit.size();i++) {
			 
				//if (listproduit.get(i).getIdsortie() == 0) {
					 listproduits.add(listproduit.get(i));
					 
			//}
			 
					 
		 }
		 
				 
		return listproduits;
		}
}
