package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Client;
import com.example.demo.model.Pfvalide;
import com.example.demo.repository.Adminsrepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.DatenowService;
import com.example.demo.service.InfosParkingsevice;
import com.example.demo.service.PfvalideService;




@Controller

public class LoginController {
		
	@Autowired
	  Adminsrepository adminRepository;
	
	@Autowired
	  ClientRepository chauffeurRepository;

	
	@Autowired
	  PfvalideService pfvalideService;
	
	@Autowired
	DatenowService dtnservice;
		 
	@PostMapping("/login/loginadmins")
	public  ModelAndView LoginAdmin(Model model,@RequestParam(name = "nom",required = false) String name,@RequestParam(name = "mdp",required = false) String mdp,HttpSession session) {
		String vue="";
	Iterable<Integer> countadmin =adminRepository.findCount(name,mdp);
	
	int countmdp = mdp.length();

	   if (countadmin.toString().equals("[1]")) {
		   vue = "administrateur/index" ;
		   }else {
			   String error = "erreur";
			   model.addAttribute("error",error);
			   vue="login";}
	  return new ModelAndView (vue);
	}
	
	@GetMapping(path = "/login/pagination")
	  public ModelAndView pagination(HttpSession session,@RequestParam(name = "numeropage",required = false) String numeropage) {
			session.setAttribute("offset", numeropage);
			session.setAttribute("numero", Integer.parseInt(numeropage));
			String off = session.getAttribute("offset").toString();
			int offs = Integer.parseInt(off); 
			offs = (offs-1)*12;
			
			return new ModelAndView("administrateur/index");
		}
	
	
	@GetMapping(path = "/login/next")
	  public ModelAndView next(HttpSession session) {
			int numero = (int)session.getAttribute("numero");
			numero = numero + 1;
			//session.setAttribute("numero", numero);
			
			String off = session.getAttribute("offset").toString();
			System.out.print("shhhhhhhhhhhh=="+off);
			int debut = (int)session.getAttribute("debut");
			debut = debut + 5;
			int fin = (int)session.getAttribute("fin");
			fin = fin + 5;
			
			session.setAttribute("debut", debut);
			session.setAttribute("fin",fin);
			
			int offs = Integer.parseInt(off); 
			//offs = offs+12;
			
			//session.setAttribute("offset", offs);
			
			
			return new ModelAndView("administrateur/index");
		}
	
	@GetMapping(path = "/login/previous")
	  public ModelAndView previous(HttpSession session) {
		
			int numero = (int)session.getAttribute("numero");
			numero = numero - 1;
			
			String off = session.getAttribute("offset").toString();
			System.out.print("tayeeeeeeeeeeee"+off);
			int debut = (int)session.getAttribute("debut");
			debut = debut - 5;
			int fin = (int)session.getAttribute("fin");
			fin = fin - 5;
			int offs = Integer.parseInt(off); 
			//offs = offs-12;
			
			System.out.print("ty le debut"+debut);
			if (debut < 1){
				debut = 1 ;	
				fin = fin + 1;
							
			}
			System.out.println("ty le offset :"+offs);
			
			if (offs < 0) {
				offs=0;
				numero = 1;
			}
			System.out.print("ty le offset"+offs);
			//session.setAttribute("offset", offs);
			//session.setAttribute("numero", numero);
			session.setAttribute("debut", debut);
			session.setAttribute("fin",fin);
			
			
			return new ModelAndView("administrateur/index");
		}
	
	
	@GetMapping("/pageClient")
	public  ModelAndView pageClient (HttpSession session){
									
	  return new ModelAndView ("client/index");
	}
	
	@GetMapping("/pageAdmin")
	public  ModelAndView pageAdmin (HttpSession session){
									
	  return new ModelAndView ("administrateur/index");
	}
	
	@Autowired
	InfosParkingsevice ifnserv;
	
	@PostMapping("/loginClient")
	public  ModelAndView LoginClient(Model model,@RequestParam(name = "nom",required = false) String name,@RequestParam(name = "mdp",required = false) String mdp,HttpSession session) {
		String vue="";
	Iterable<Integer> countadmin =chauffeurRepository.Login(name, mdp);
	String id =chauffeurRepository.getId(name, mdp).toString().replace("]","");
	id = id.replace("[","");
	
	System.out.println("tayyy"+id);
	 if (countadmin.toString().equals("[1]")) {
		   System.out.println("tAFIDITRA"+id);
		   vue = "client/index" ;
		   
		   session.setAttribute("idClient", id);
		   session.setAttribute("listepf", ifnserv.listProduit());
		   
		   
		    String off = session.getAttribute("idClient").toString();
		    session.setAttribute("listinfos", ifnserv.listProduit());
		    
		    
			int offs = Integer.parseInt(off);
			
			
			if(pfvalideService.listProduit(offs).toString() != "[]") {
				System.out.println(pfvalideService.listProduit(offs));
				session.setAttribute("montantPF", pfvalideService.listProduit(offs));
				
			}else {
				ArrayList<Pfvalide> pfv = new ArrayList<Pfvalide>();
				Pfvalide p = new Pfvalide();
				p.setMontant(0.0);
				pfv.add(p);
				session.setAttribute("montantPF", pfv);
			}
			
		
			
			System.out.println("session Pf"+session.getAttribute("montantPF"));
			
		  
		  // session.setAttribute("type", this.listType_echeance());
		  // session.setAttribute("dispoList", this.listVehiculeDispo());
		  // session.setAttribute("disponibite", 1);
		  // session.setAttribute("listnondispo", this.listVehiculeExpire());	
	 }else 
	 {
		 System.out.println("tSY TAFIDITRA"+id);
		 String error = "erreur";
		 model.addAttribute("error",error);
		 vue ="client/login";
		 
	 }
		   
			  
	  return new ModelAndView (vue);
	}

	@GetMapping("/deconnexion")
	public  ModelAndView Deconnexion(HttpSession session) {		
		session.setAttribute("idClient",-1);
		session.removeAttribute("montantPF");		
	  return new ModelAndView ("client/index");
	}
	
	@Autowired
	ClientRepository cl;
	
	@GetMapping("/pageInscription")
	public  ModelAndView inscription (){
			
	  return new ModelAndView ("client/inscription");
	}
	
	
	@GetMapping("/inscription")
	public  ModelAndView inscription (HttpSession session ,
			@RequestParam(name = "nom",required = false) String nom,
			@RequestParam(name = "prenom",required = false) String prenom,
			@RequestParam(name = "mail",required = false) String mail,
			@RequestParam(name = "mdp",required = false) String mdps){
		
		cl.save(new Client(nom,prenom,mail,mdps));
			
	  return new ModelAndView ("client/inscription");
	}
	





}
