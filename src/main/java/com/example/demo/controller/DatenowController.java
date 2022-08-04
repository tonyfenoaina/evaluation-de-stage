package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Datenow;
import com.example.demo.model.InfosParking;
import com.example.demo.repository.DatenowRep;

@Controller
public class DatenowController {
	@Autowired
	DatenowRep datenowRep;
	
	
		
	@GetMapping(path = "/AjouterDateNow")
	  public ModelAndView AjouterTDateNow(
			  @RequestParam(name = "datenowvalue",required = false) String datenowvalue)			
			   {
			Date d = new Date(Timestamp.valueOf(LocalDateTime.parse(datenowvalue)).getTime());
			datenowRep.save(new Datenow(d,"miakatra"));					
			return new ModelAndView("administrateur/index");
		}
	
}
