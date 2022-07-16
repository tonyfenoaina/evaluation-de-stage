package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.PDFGenerator;

import com.lowagie.text.DocumentException;

@Controller
public class Pdfcontroller {

	
    @GetMapping("/pdf/students")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
	//	List<Vehicule> studentList = service.findAll();
		
		PDFGenerator generator = new PDFGenerator();
		//generator.setStudentList(studentList);
		generator.generate(response);
		
	}
}
