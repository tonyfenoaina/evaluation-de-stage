package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Parking;
import com.example.demo.model.Pfvalide;
import com.example.demo.repository.ParkingRep;
import com.example.demo.service.InfosParkingsevice;

@Controller
public class ParkingController {
	@Autowired 
	ParkingRep parkingRep;
	
	@PostMapping("/AjouterParking")
	public  ModelAndView ValiderPf(Model model,
			@RequestParam(name = "taille",required = false) String taille,
			@RequestParam(name = "numero",required = false) String numero,
			HttpSession session) {
		parkingRep.save(new Parking(Double.parseDouble(taille),Integer.parseInt(numero)));
		
	  return new ModelAndView ("administrateur/index");
	}
	
	@GetMapping("/updateParking")
	public  ModelAndView updateParking(Model model,
			@RequestParam(name = "id",required = false) String id,
			HttpSession session) {
		
		Parking ta = parkingRep.getById(Integer.parseInt(id));
		ta.setEtat("desactive");		
		parkingRep.save(ta);
		session.setAttribute("listeInfosParkingAdmin", ifnserv.listProduit());
		
		
	  return new ModelAndView ("administrateur/desactivation");
	}
	
	@Autowired
	InfosParkingsevice ifnserv;
	@GetMapping("/active")
	public  ModelAndView active(Model model,
			@RequestParam(name = "id",required = false) String id,
			HttpSession session) {
		
		Parking ta = parkingRep.getById(Integer.parseInt(id));
		ta.setEtat("active");		
		parkingRep.save(ta);
		session.setAttribute("listeInfosParkingAdmin", ifnserv.listProduit());
			
	  return new ModelAndView ("administrateur/desactivation");
	}
	
	

}
