package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Pfvalide;
import com.example.demo.model.Pfvirtuelle;

import com.example.demo.repository.PfvirtuelleRepository;

import com.example.demo.service.PfvirtuelleService;

@Controller
public class PfvirtuelleController {
	
	@Autowired
	  PfvirtuelleRepository pfRepository;
	@Autowired
	  PfvirtuelleService pfService;
	
	@PostMapping("/ajoutpf")
	public  ModelAndView LoginAdmin(Model model,
			@RequestParam(name = "montant",required = false) String montant,
			HttpSession session) {
		
		System.out.println("montant"+montant);
		
		int id = Integer.parseInt(session.getAttribute("idClient").toString());
		double m = Double.parseDouble(montant);
		ArrayList<Pfvalide> volaActuelle = (ArrayList<Pfvalide>)session.getAttribute("montantPF");
		//double v = volaActuelle.get(0).getMontant();	
		//m = m + v;
		System.out.println(m);
		
		
		pfRepository.save(new Pfvirtuelle(id,m));
	  return new ModelAndView ("client/depot");
	}
	
	

}
