package com.example.demo.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFGenerator {
	
	String idReservation;
	String idVehicule;
	String numeroparking;
	String nom;
	String prenom;
	String montant;
	String duree;
	 
	
	public PDFGenerator(String idReservation, String idVehicule, String numeroparking, String nom, String prenom,
			String montant, String duree) {
		super();
		this.idReservation = idReservation;
		this.idVehicule = idVehicule;
		this.numeroparking = numeroparking;
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
		this.duree = duree;
	}	

	



	// List to hold all Students
	/*private List<Vehicule> studentList;

	public List<Vehicule> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Vehicule> studentList) {
		this.studentList = studentList;
	}*/

	public String getIdVehicule() {
		return idVehicule;
	}



	public void setIdVehicule(String idVehicule) {
		this.idVehicule = idVehicule;
	}



	public String getNumeroparking() {
		return numeroparking;
	}



	public void setNumeroparking(String numeroparking) {
		numeroparking = numeroparking;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getMontant() {
		return montant;
	}



	public void setMontant(String montant) {
		this.montant = montant;
	}



	public PDFGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PDFGenerator(String idVehicule, String numeroparking, String nom, String prenom, String montant) {
		super();
		this.idVehicule = idVehicule;
		this.numeroparking = numeroparking;
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
	}



	public void generate(HttpServletResponse response) throws DocumentException, IOException {

		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Ticket Reservation Parking", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);
		
	
		Paragraph reservation = new Paragraph("Reservation numero : " +idReservation , fontTiltle);
		document.add(reservation);
		
		Paragraph parking = new Paragraph("Parking numero : "+numeroparking, fontTiltle);
		document.add(parking);
		
		Paragraph Client = new Paragraph("Client :"+nom+" "+prenom, fontTiltle);
		document.add(Client);
		
		Paragraph vehicule = new Paragraph("Numero du Vehicule :"+idVehicule, fontTiltle);
		document.add(vehicule);
		
		Paragraph Duree = new Paragraph("Durree : "+duree, fontTiltle);
		document.add(Duree);
		
		Paragraph Tarif = new Paragraph("Montant : "+montant, fontTiltle);
		document.add(Tarif);
		
		

		
		
		

		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(3);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		// Adding Cell to table
		/*cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Student Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Section", font));
		table.addCell(cell);*/

		// Iterating over the list of students
		/*for (Vehicule student : studentList) {
			// Adding student id
			table.addCell(String.valueOf(student.getId()));
			// Adding student name
			table.addCell(student.getMarque());
			// Adding student section
			table.addCell(student.getModele());
		}*/
		
		// Adding the created table to document
		//document.add(table);

		// Closing the document
		document.close();

	}
}