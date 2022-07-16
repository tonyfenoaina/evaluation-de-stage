package com.example.demo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import com.example.demo.model.PDFGenerator;
import com.example.demo.model.Pfvalide;
import com.example.demo.model.Reservation;
import com.example.demo.model.Tarif;
import com.example.demo.repository.InfosParkingRep;
import com.example.demo.repository.PfvalideRepository;
import com.example.demo.repository.ReservationRep;
import com.example.demo.repository.TarifRep;
import com.example.demo.service.InfosParkingsevice;
import com.example.demo.service.PfvalideService;
import com.example.demo.service.TarifService;
import com.lowagie.text.DocumentException;

@Controller
public class ReservationController {
@Autowired
ReservationRep reservationRep;

@Autowired
InfosParkingsevice ifnserv;

@Autowired
InfosParkingRep infrep;

@Autowired
PfvalideRepository pfr;

@Autowired
TarifRep trep;

@Autowired
PfvalideService pfvalideService;

@GetMapping("/AjoutReservation")
public  ModelAndView AjoutReservation(HttpSession session,Model m,
		@RequestParam(name = "idParking",required = false) String idParking,
		@RequestParam(name = "idVehicule",required = false) String idVehicule,
		@RequestParam(name = "idTarif",required = false) String idTarif,
		@RequestParam(name = "idReservation",required = false) String idReservation,
		@RequestParam(name = "numeroparking",required = false) String numeroparking,
		@RequestParam(name = "nom",required = false) String nom,
		@RequestParam(name = "prenom",required = false) String prenom,
		@RequestParam(name = "montant",required = false) String montant,
		@RequestParam(name = "duree",required = false) String duree,
		@RequestParam(name = "datedebut",required = false) String datedebut,
		HttpServletResponse response) throws DocumentException, IOException
{		
	
	String vue = "";
	
	int idP = Integer.parseInt(idParking);
	int idT = Integer.parseInt(idTarif);
	int idClient = Integer.parseInt(session.getAttribute("idClient").toString()) ;
	java.util.Date date = new Date(Timestamp.valueOf(LocalDateTime.parse(datedebut)).getTime());
	
	//Paiement
	ArrayList<Pfvalide> volaActuelle = (ArrayList<Pfvalide>)session.getAttribute("montantPF");
	double vActu = volaActuelle.get(0).getMontant();	
	Tarif tarif = new Tarif();
	tarif = trep.getById(Integer.parseInt(idTarif));
	
	double volaTarif = tarif.getMontant();	
	double reste = vActu - volaTarif;
	
	if(reste >= 0) {
		
		
		
		reservationRep.save(new Reservation(idP,idClient,idT,idVehicule,date));
		
		vue ="client/index";
		pfr.save(new Pfvalide(idClient,0,reste));
		session.setAttribute("montantPF", pfvalideService.listProduit(idClient));
		session.setAttribute("listinfos", ifnserv.listProduit());	
		/*
		
		
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		PDFGenerator generator = new PDFGenerator(idReservation,idVehicule,numeroparking,nom,prenom,"3000",duree);
		generator.generate(response);*/
		
	}else {
		reste = 0-reste;
		String error = "Tsy ampy"+reste+" ny volanao";
		vue = "client/reservation";
		m.addAttribute("error",error );
		m.addAttribute("idVehicule", idVehicule);
		
	}
	
	
	
	
  return new ModelAndView (vue);
}

@Autowired
TarifService ts;

@GetMapping("/PageAjoutReservation")
public  ModelAndView PageAjoutReservation(Model m,HttpSession session,
		@RequestParam(name = "idParking",required = false) String idParking,
		@RequestParam(name = "idReservation",required = false) String idReservation,
		@RequestParam(name = "idVehicule",required = false) String idVehicule,
		@RequestParam(name = "numeroparking",required = false) String numeroparking,
		@RequestParam(name = "nom",required = false) String nom,
		@RequestParam(name = "prenom",required = false) String prenom,
		@RequestParam(name = "montant",required = false) String montant,
		@RequestParam(name = "duree",required = false) String duree) {		
	
	
	m.addAttribute("idParking", idParking);
	m.addAttribute("idReservation", idReservation);
	m.addAttribute("idVehicule", idVehicule);
	m.addAttribute("numeroparking", numeroparking);
	m.addAttribute("nom", nom);
	m.addAttribute("prenom", prenom);
	m.addAttribute("montant", montant);
	m.addAttribute("duree", duree);
	
	
	session.setAttribute("idParking", idParking);
	session.setAttribute("listTarif", ts.listTarif());
	
	
  return new ModelAndView ("client/reservation");
}


}
