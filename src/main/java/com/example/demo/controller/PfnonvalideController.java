package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PfnonvalideService;
import com.example.demo.service.PfvirtuelleService;

@Controller
public class PfnonvalideController {

	@Autowired
	  PfnonvalideService pfService;
	
	@GetMapping(path = "/listepf")
	  public ModelAndView listeVehicule(HttpSession session) {
			
			session.setAttribute("listepf", pfService.listProduit());
			return new ModelAndView("administrateur/listepf");
		}
}
