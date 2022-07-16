package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DatenowService;
import com.example.demo.service.InfosParkingsevice;
import com.example.demo.service.PfvalideService;
import com.example.demo.service.TarifService;

@Controller
public class PageController {
	@Autowired
	  PfvalideService pfvalideService;
	
	@Autowired
	DatenowService dtnservice;
	
	
	 @GetMapping(path = "/")
	  public ModelAndView firstPage(HttpSession session,@RequestParam(name = "data",required = false) String data) {
		 	session.setAttribute("data", data);
			return new ModelAndView("login");
		}
	 
	 @GetMapping(path = "/login")
	  public ModelAndView AdminLoginPage() {
			return new ModelAndView("administrateur/login");
		}
	 	 
	 @GetMapping(path = "/client")
	  public ModelAndView ClientPage( HttpSession session) {
		 session.setAttribute("listinfos", ifnserv.listProduit());
		 session.setAttribute("idClient", -1);
		// System.out.println("ty le daty androany"+dtnservice.getdateNow());
		 if(dtnservice.getdateNow()!=null) {
		 session.setAttribute("datenow",dtnservice.getdateNow().get(0).getDatenowvalue());
		 System.out.println("ty le daty androany"+session.getAttribute("datenow"));
		 }
		 if(session.getAttribute("datenow")==null)
         {
			 System.out.println("tsisy le daty androany");
			 java.util.Date now = new Date(Timestamp.valueOf(LocalDateTime.now()).getTime());
             session.setAttribute("datenow",now);	
         } 
		 
			return new ModelAndView("client/index");
		}
	  	 
	 
	 
	 @Autowired
		InfosParkingsevice ifnserv;
		
	 @GetMapping(path = "/PageLogin")
	  public ModelAndView pageLogin(HttpSession session) {
		 	
			return new ModelAndView("client/login");
		}
	 
	 @GetMapping(path = "/PageAjoutPf")
	  public ModelAndView PageAjoutPf() {
			return new ModelAndView("ecommerce/ajoutpf");
		}
	 
	 @GetMapping(path = "/actualiser")
	  public ModelAndView actualiser(HttpSession session) {
		 	String off = session.getAttribute("idClient").toString();
			int offs = Integer.parseInt(off); 
			System.out.println(pfvalideService.listProduit(offs));
			session.setAttribute("montantPF", pfvalideService.listProduit(offs));
			return new ModelAndView("client/index");
		}
	 
	 @GetMapping("/Depot")
		public  ModelAndView Depot (){				
		  return new ModelAndView ("client/depot");
		}
	 
	 @Autowired
	 TarifService tService;
	 @GetMapping("/ListTarif")
		public  ModelAndView ListTarif (HttpSession session){
		 
		 session.setAttribute("ListTarif", tService.listTarif());
		  return new ModelAndView ("administrateur/listeTarif");
		}
	 
	 
	 
	 @GetMapping("/simulationParking")
		public  ModelAndView simulationParking (HttpSession session){
		 
		 session.setAttribute("listinfos", ifnserv.listProduit());
		  return new ModelAndView ("administrateur/simulationparking");
		}
	 
	 @GetMapping("/simulationAvecDate")
		public  ModelAndView simulationAvecDate (HttpSession session,
				@RequestParam(name = "temp",required = false) String temp){
		 	
		 
		 
		 String tempNew = temp.replace("T", " ") + ":00.881";
		 session.setAttribute("temp", tempNew);
		 
		 System.out.println("ty le format anleh date:"+session.getAttribute("temp"));
		 
		  return new ModelAndView ("administrateur/simulationparking");
		}
	 
	 
	 
	
	 
	 
	 
}
