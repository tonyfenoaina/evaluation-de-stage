package com.example.demo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.InfosParking;
import com.example.demo.model.PDFGenerator;
import com.example.demo.model.Sortie;
import com.example.demo.repository.ReservationRep;
import com.example.demo.repository.SortieRep;
import com.example.demo.service.InfosParkingsevice;
import com.lowagie.text.DocumentException;

@Controller
public class SortieController {
	
@Autowired
SortieRep srp;

@Autowired
InfosParkingsevice ifnserv;

@Autowired
ReservationRep rrep;




@GetMapping("/Sortie")
public  ModelAndView PageAjoutReservation(Model m,HttpSession session,
		@RequestParam(name = "idReservation",required = false) String idReservation,
		@RequestParam(name = "idVehicule",required = false) String idVehicule,
		@RequestParam(name = "numeroparking",required = false) String numeroparking,
		@RequestParam(name = "nom",required = false) String nom,
		@RequestParam(name = "prenom",required = false) String prenom,
		@RequestParam(name = "montant",required = false) String montant,
		@RequestParam(name = "duree",required = false) String duree,
		@RequestParam(name = "datesortie",required = false) String datesortie,
		HttpServletResponse response
		 
		) throws DocumentException, IOException
{		
	java.util.Date date = new Date(Timestamp.valueOf(LocalDateTime.parse(datesortie)).getTime());
	srp.save(new Sortie(Integer.parseInt(idReservation),date));
		
	//rrep.deleteById(Integer.parseInt(idReservation));
	session.setAttribute("listinfos", ifnserv.listProduit());
	
  return new ModelAndView ("client/index");
}



}
