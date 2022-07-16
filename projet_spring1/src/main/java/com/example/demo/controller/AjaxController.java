package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AjaxController {

	
	@RequestMapping(value = "/formShow", method = RequestMethod.POST)
	public String getTags(@RequestParam("name") String name, @RequestParam("lastname") String lastname) 
	{
	    System.out.println("name: " + name+ " lastname: "+lastname);
	    String fullName = name + lastname;
	   ArrayList  f = new ArrayList();
	   f.add(name);
	   f.add(name);
	    fullName = f.toString();
	    return fullName;
	}
	
	 @GetMapping(path = "/pageAjax")
	  public ModelAndView firstPage() {
			return new ModelAndView("ecommerce/ajax");
		}
}
