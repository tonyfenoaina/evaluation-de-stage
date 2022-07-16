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

}
