package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InfosParkingsevice;

@Controller
public class InfosParkingController {

	@Autowired
	InfosParkingsevice ifnserv;
	
	@GetMapping(path = "/listeInfosParking")
	  public ModelAndView listeVehicule(HttpSession session) {
			
			session.setAttribute("listepf", ifnserv.listProduit());
			return new ModelAndView("administrateur/listepf");
		}
	
	@GetMapping(path = "/listeInfosParkingAdmin")
	  public ModelAndView listeInfosParkingAdmin(HttpSession session) {			
			session.setAttribute("listeInfosParkingAdmin", ifnserv.listProduit());
			return new ModelAndView("administrateur/desactivation");
		}
	
	

}
