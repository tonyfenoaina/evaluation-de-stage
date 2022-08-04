package com.example.demo.controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.PdfAdmin;
import com.example.demo.model.Situation;
import com.example.demo.repository.ReservationRep;
import com.example.demo.repository.SituationRep;
import com.example.demo.service.SituationService;
import com.lowagie.text.DocumentException;

@Controller
public class SituationController {
 @Autowired
 SituationService situationService;
 
 @Autowired
 SituationRep situationRep;
 
 @Autowired
 ReservationRep reservationRep;
 
 
 
 
 
 @GetMapping(path = "/situation")
 public ModelAndView listeVehicule(HttpSession session) {		
		session.setAttribute("listesituation", situationService.listProduit());
		return new ModelAndView("administrateur/situation");
	}
 
 
 
 @GetMapping(path = "/situationexportpdf")
 public ModelAndView situationexportpdf(HttpSession session,
		 HttpServletResponse response,
		 @RequestParam(name = "id",required = false) String id)  throws DocumentException, IOException, ParseException {	
	  
	 Situation s = new Situation();
	// s = situationRep.getById(id);
	 s = situationRep.getparId(id);
	 	 
	 	String matricule = s.getId();
		String montant = String.valueOf(s.getMontant());
		String montantTarif = String.valueOf(s.getMontanttarif());
		String amende = String.valueOf(s.getAmende());
		String datefin = s.getDatefin().toString();
		String datesortie = "";
		if(s.getDatesortie()!=null) {
			
			 datesortie = s.getDatesortie().toString();
				}
		
		
		String datedebut = s.getDatedebut().toString();
		String durree = s.getDurree().toString();
		String durreenormalTarif = s.getDurreenormaltarif().toString();
		String remise = "0%";
		String enplus = "0%";
		String heuregratuit = "0";  
	 
	 if(s.getMontanttarif()<s.getMontant()) {
		 
		 System.out.println("payement en plus");
		 enplus = "10%";
	 }
	 
	 if(s.getMontanttarif()>s.getMontant()) {
		 
		 System.out.println("remise");
		  remise = "15%";
	 }
	 
	 
	 
	 
	 
	 DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	 	Time timebonus = new java.sql.Time(formatter.parse("18:00:00").getTime());
		Time timebonus2 = new java.sql.Time(formatter.parse("06:00:00").getTime());
		Time timebonus15h = new java.sql.Time(formatter.parse("15:00:00").getTime());
		Time timebonus16h = new java.sql.Time(formatter.parse("16:00:00").getTime());
		Time tempbonus = new java.sql.Time (formatter.parse("00:00:00").getTime());
		Time durreee = new java.sql.Time(formatter.parse(s.getDurree().toString()+":00").getTime());
		java.util.Date date = new Date(Timestamp.valueOf(s.getDatedebut().toString()).getTime());
		long times = date.getTime();
		int heuredebut = date.getHours();
		int minutedebut = date.getMinutes();
		int secondedebut = date.getSeconds();
		String timevao =heuredebut +":"+minutedebut+":"+secondedebut;
		Time timedebutvao = new java.sql.Time(formatter.parse(timevao).getTime());
		
		/* if ((timedebutvao.compareTo(timebonus)>=0 || timedebutvao.compareTo(timebonus2)<0) || ((timedebutvao.compareTo(timebonus15h)>=0) && (timedebutvao.compareTo(timebonus16h)<=0)))  {			
		 System.out.println("atooooo ah zao");
			if(durreee.compareTo(tempbonus)<=0 ) {			
				montant= "0";
				
			}else {
				System.out.println("atooooooooo");
				int payant = durreee.getHours() - 1;
				 durreee.setHours(payant);		 
				 montant = reservationRep.getVolaPayena(durreee).toString();
				 
			}
			
			
			heuregratuit = "35minute";
			
			//duree = tarif.getDuree().plusHours(1).plusMinutes(0).toString();		
			
			System.out.println("duree"+durree);			
		}*/
	 
	 DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		PdfAdmin generator = new  PdfAdmin( matricule,  montant,  montantTarif,  amende,  datefin,
				 datesortie,  datedebut,  durree,  durreenormalTarif,  remise,  enplus,
				 heuregratuit);
		generator.generate(response);
	
	 
	 System.out.println(s.getId());
	 System.out.println(s.getMontant());
	 System.out.println(s.getAmende());
	 System.out.println(s.getDatefin());
	 System.out.println(s.getDatedebut());
	 System.out.println(s.getDatesortie());
	 System.out.println(s.getDurree());
	 System.out.println(s.getMontanttarif());
	 System.out.println(s.getDurreenormaltarif());
	 
	 
	 
	return new ModelAndView("administrateur/situation");
	}
}
