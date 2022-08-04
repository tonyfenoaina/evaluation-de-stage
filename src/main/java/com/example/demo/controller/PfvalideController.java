package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Pfvalide;
import com.example.demo.model.Pfvirtuelle;
import com.example.demo.repository.PfvalideRepository;
import com.example.demo.service.PfnonvalideService;
import com.example.demo.service.PfvalideService;
@Controller
public class PfvalideController {
	@Autowired
	  PfvalideRepository pfvirtuelleRepository;
	@Autowired
	  PfvalideService pfvirtuelleService;
	@Autowired
	  PfnonvalideService pfService;

	@GetMapping("/validerpf")
	public  ModelAndView ValiderPf(Model model,
			@RequestParam(name = "idClient",required = false) String idClient,
			@RequestParam(name = "montant",required = false) String montant,
			@RequestParam(name = "idpfvirtuel",required = false) String idpfvirtuel,
			HttpSession session) {
		System.out.println("id client_"+idClient);
		System.out.println("montant"+montant);
		
		
		
		int id = Integer.parseInt(idClient);
		int idpf = Integer.parseInt(idpfvirtuel);
		
		
		Pfvalide pfv = new Pfvalide();
		double m = 0.0;
		System.out.println("ty le vola"+pfvirtuelleService.listProduit(id));
		if(pfvirtuelleService.listProduit(id).size()!=0) {
			
			pfv = pfvirtuelleService.listProduit(id).get(0);
			 m = Double.parseDouble(montant) + pfv.getMontant();
			
		}else {
			
			m = Double.parseDouble(montant) ;
		}
		
		
		
		pfvirtuelleRepository.save(new Pfvalide(id,idpf,m));
		session.setAttribute("listepf", pfService.listProduit());
	  return new ModelAndView ("administrateur/listepf");
	}
	
	
	
	
	
	@GetMapping("/MontantPf")
	public  ModelAndView MontantPf(
			HttpSession session) {		
		String off = session.getAttribute("idClient").toString();
		int offs = Integer.parseInt(off); 
		session.setAttribute("listeProduit", pfvirtuelleService.listProduit(offs));
	  return new ModelAndView ("administrateur/listepf");
	}
	
}
