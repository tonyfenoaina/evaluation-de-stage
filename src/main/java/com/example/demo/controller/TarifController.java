package com.example.demo.controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Datenow;
import com.example.demo.model.Tarif;
import com.example.demo.repository.DatenowRep;
import com.example.demo.repository.TarifRep;
import com.example.demo.service.TarifService;

@Controller
public class TarifController {
	@Autowired
	TarifRep tarifRep;
	
	@Autowired
	TarifService tarifService;
	
	
	
	
	
	@GetMapping(path = "/listeTarif")
	  public ModelAndView listeTarif(HttpSession session) {			
			session.setAttribute("listepf", tarifService.listTarif());
			return new ModelAndView("administrateur/listepf");
		}
	
	@GetMapping(path = "/deleteTarif")
	  public ModelAndView deleteTarif(HttpSession session,@RequestParam(name = "id",required = false) String id) {			
			tarifRep.deleteById(Integer.parseInt(id));
			session.setAttribute("listepf", tarifService.listTarif());
			return new ModelAndView("administrateur/listepf");
		}
	
	@PostMapping(path = "/AjouterTarif")
	  public ModelAndView AjouterTarif(
			  @RequestParam(name = "montant",required = false) String montant,
			@RequestParam(name = "durree",required = false) String durree)
			   {
			LocalTime t = LocalTime.parse(durree);
			tarifRep.save(new Tarif(Double.parseDouble(montant),t));
					
			return new ModelAndView("administrateur/index");
		}

	
}
