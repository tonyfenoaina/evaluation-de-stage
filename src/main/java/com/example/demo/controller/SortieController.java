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

import com.example.demo.model.Amende;
import com.example.demo.model.AmendePayee;
import com.example.demo.model.InfosParking;
import com.example.demo.model.PDFGenerator;
import com.example.demo.model.Pfvalide;
import com.example.demo.model.Sortie;
import com.example.demo.repository.AmendePayeRep;
import com.example.demo.repository.AmendeRep;
import com.example.demo.repository.PfvalideRepository;
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

@Autowired
AmendeRep amenderep;

@Autowired
AmendePayeRep amendepayerep;

@Autowired
PfvalideRepository pfvalideRepository;




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
		@RequestParam(name = "datedebut",required = false) String datedebut,
		@RequestParam(name = "etat",required = false) String etat,
		HttpServletResponse response
		 
		) 
{		
	System.out.println("ty le date debut "+datedebut);
	System.out.println("ty le date sortie "+datesortie);
	java.util.Date sdatesortie = new Date(Timestamp.valueOf(LocalDateTime.parse(datesortie)).getTime());
	java.util.Date sdatedebut = new Date(Timestamp.valueOf(datedebut).getTime());
	System.out.println("ty le date debut vaovao "+sdatedebut);
	System.out.println("ty le date sortie vaovao"+sdatesortie);

	ArrayList<Pfvalide> volaActuelle = (ArrayList<Pfvalide>)session.getAttribute("montantPF");	
	double vActu = volaActuelle.get(0).getMontant();
	double reste = vActu - 15000;
	
	System.out.println("ty le d "+sdatedebut.compareTo(sdatesortie));
	
		
		if(sdatedebut.compareTo(sdatesortie)<0) {
				
			System.out.println("tafiditra isortie");
			srp.save(new Sortie(Integer.parseInt(idReservation),sdatesortie));			
			//rrep.deleteById(Integer.parseInt(idReservation));
			session.setAttribute("listinfos", ifnserv.listProduit());
		
			//insert  amendeeeeeeeeeeeeeeeeeeeeeee 
			if(etat.equals("infraction")==true) {
				
				if(reste>=0) {	
					System.out.println("id reservaaaaaaaaaa ="+Integer.parseInt(idReservation));
					double volaloha =100000;
					Amende amende = new Amende();
					amende = amenderep.save(new Amende(Integer.parseInt(idReservation),idVehicule,volaloha,Integer.parseInt(session.getAttribute("idClient").toString())));
					//payee amendeeeeeeeeeeeeeeeeeeeeeee 
					amendepayerep.save(new AmendePayee(amende.getIdclient(),amende.getId()));
					
					}
						else 					
							{
								m.addAttribute("errorVola","tsy ampy "+reste+"ny volanao");		
							}	
				
			}
			
		}else
			{
				m.addAttribute("errordate","le date ");
				m.addAttribute("datesortie", datesortie);		
			}
		
	
		
	
  return new ModelAndView ("client/index");
}



}
