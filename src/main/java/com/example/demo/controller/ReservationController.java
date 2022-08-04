package com.example.demo.controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.example.demo.model.Pfvalide;
import com.example.demo.model.Reservation;
import com.example.demo.model.Tarif;
import com.example.demo.repository.AmendeRep;
import com.example.demo.repository.DatenowRep;
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

@Autowired
DatenowRep datenowRep;


@Autowired
AmendeRep amenderep;

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
		HttpServletResponse response) throws DocumentException, IOException, ParseException
{		
	
	String vue = "";
	
	int idP = Integer.parseInt(idParking);
	int idT = Integer.parseInt(idTarif);
	int idClient = Integer.parseInt(session.getAttribute("idClient").toString()) ;
	
	java.util.Date date = new Date(Timestamp.valueOf(LocalDateTime.parse(datedebut)).getTime());
	
	long times = date.getTime();
	int heuredebut = date.getHours();
	int minutedebut = date.getMinutes();
	int secondedebut = date.getSeconds();
	
	
	
	Time timedebut = new Time(times);
	
	String timevao =heuredebut +":"+minutedebut+":"+secondedebut;
	
	
	DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	
	Time timedebutvao = new java.sql.Time(formatter.parse(timevao).getTime());
	
	Time timeremisemin = new java.sql.Time(formatter.parse("06:00:00").getTime());
	Time timeremisemax = new java.sql.Time(formatter.parse("08:00:00").getTime());
	
	Time timeenplusmin = new java.sql.Time(formatter.parse("12:00:00").getTime());
	Time timeenplusmax = new java.sql.Time(formatter.parse("14:00:00").getTime());
	
	
	
	
	String bonus = "0 heure";
	
	System.out.println("ty le dateamn 18: "+timedebut);
	
	
	//Paiement
	
	ArrayList<Pfvalide> volaActuelle = (ArrayList<Pfvalide>)session.getAttribute("montantPF");
	double vActu = volaActuelle.get(0).getMontant();
	
	Tarif tarif = new Tarif();
	tarif = trep.getById(Integer.parseInt(idTarif));
	
	duree = tarif.getDuree().toString();
	
	
	double volaTarif = tarif.getMontant();	
	
	montant = String.valueOf(volaTarif);
	
	
	
	double remise1 = volaTarif*15/100;
	double enplus = volaTarif *10/100;
	
	
	System.out.println("timedebutvao"+timedebutvao);
	System.out.println("timeremisemin"+timeremisemin);
	System.out.println("timeremisemax"+timeremisemax);
	
	
	
	
	///solona avec minute
	
	if (timedebutvao.compareTo(timeremisemin)>=0			
		&& timedebutvao.compareTo(timeremisemax)<=0 ){		
		System.out.println("remise tsika zao");
		volaTarif = volaTarif - remise1;
		System.out.println("ty le vola remise :" +remise1);
		System.out.println("ty le volatarif :" +volaTarif);
	}
		
	if (timedebutvao.compareTo(timeenplusmin)>=0
		&& timedebutvao.compareTo(timeenplusmax)<=0) {		
		System.out.println("en plus tsika zao");
		volaTarif = volaTarif + enplus;
	}
	
	
	
	Time timebonus = new java.sql.Time(formatter.parse("18:00:00").getTime());
	Time timebonus2 = new java.sql.Time(formatter.parse("06:00:00").getTime());
	
	Time durreee = new java.sql.Time(formatter.parse(tarif.getDuree().toString()+":00").getTime());
	
	Time tempbonus = new java.sql.Time (formatter.parse("01:00:00").getTime());

	System.out.println("valinle comparaison"+timedebutvao.compareTo(timebonus));
	System.out.println("valinle comparaison"+timedebutvao.compareTo(timebonus2));
	
	duree = tarif.getDuree().toString();
	if(amenderep.countAmende(idVehicule)<3) {
	if (timedebutvao.compareTo(timebonus)>=0 || timedebutvao.compareTo(timebonus2)<0) {			
		
			if(durreee.compareTo(tempbonus)<=0) {			
				volaTarif = 0;
				duree = "1";
			}else {
				int payant = durreee.getHours() - 1;
				 durreee.setHours(payant);					
				 volaTarif =  reservationRep.getVolaPayena(durreee);
			}
			
			
			bonus = "1heure";
			
			//duree = tarif.getDuree().plusHours(1).plusMinutes(0).toString();		
			
			System.out.println("duree"+duree);			
		}
	
	System.out.println("ty le volatarif :" +volaTarif);
	System.out.println("ty le volaActuelle :" +vActu);

	double reste = vActu - volaTarif;
	System.out.println("ty le reste :" +reste);
	if(reste >= 0) {
		System.out.println("afaka mividy");
		Reservation resv = new Reservation();
		resv = reservationRep.save(new Reservation(idP,idClient,idT,idVehicule,volaTarif,date));
		
		vue ="client/index";
		pfr.save(new Pfvalide(idClient,0,reste));
		
		System.out.println("ty le nom louny e"+nom);
		
		session.setAttribute("montantPF", pfvalideService.listProduit(idClient));
		session.setAttribute("listinfos", ifnserv.listProduit());	
			
		//response.setContentType("application/pdf");
		/*DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		PDFGenerator generator = new PDFGenerator(idReservation,idVehicule,numeroparking,nom,prenom,String.valueOf(volaTarif),duree);
		generator.generate(response);*/
		
	}
	
	else {
		//reste = 0-reste;
		String error = "Tsy ampy le volanao";
		vue = "client/reservation";
		m.addAttribute("error",error );
		m.addAttribute("idVehicule", idVehicule);
		
	}
	
	}else {
		//reste = 0-reste;
		String error = "Tsy afaka mampiditr anio enao";
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
