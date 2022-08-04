package com.example.demo.model;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfAdmin {
	
	String matricule;
	String montant;
	String montantTarif;
	String amende;
	String datefin;
	String datesortie;
	String datedebut;
	String durree;
	String durreenormalTarif;
	String remise ;
	String enplus ;
	String heuregratuit;
	
	
	
	

	public PdfAdmin(String matricule, String montant, String montantTarif, String amende, String datefin,
			String datesortie, String datedebut, String durree, String durreenormalTarif, String remise, String enplus,
			String heuregratuit) {
		super();
		this.matricule = matricule;
		this.montant = montant;
		this.montantTarif = montantTarif;
		this.amende = amende;
		this.datefin = datefin;
		this.datesortie = datesortie;
		this.datedebut = datedebut;
		this.durree = durree;
		this.durreenormalTarif = durreenormalTarif;
		this.remise = remise;
		this.enplus = enplus;
		this.heuregratuit = heuregratuit;
	}





	public PdfAdmin() {
		super();
		// TODO Auto-generated constructor stub
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
		Font fontTiltle = FontFactory.getFont(FontFactory.COURIER);
		Font font = FontFactory.getFont(FontFactory.COURIER);
		fontTiltle.setSize(20);
		font.setSize(15);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Ticket Reservation Parking", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);
		
	
		
		
		Paragraph parking = new Paragraph("Matricule : "+matricule, font);
		parking.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(parking);
		
	
		
		Paragraph vehicule = new Paragraph("Montant final et duree final :"+montant +"Ariary pour "+durree, font);
		vehicule.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(vehicule);
		
		
		Paragraph Duree = new Paragraph("Tarif choisie :"+montantTarif +"Ariary pour "+durreenormalTarif, font);
		Duree.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Duree);
		
		
		Paragraph Tarif = new Paragraph("Montant Parking: "+montant, font);
		Tarif.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Tarif);
		
		Paragraph Tarif1 = new Paragraph("amende : "+amende, font);
		Tarif1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Tarif1);
		
		Paragraph datefin1 = new Paragraph("datefinprevue : "+datefin, font);
		datefin1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(datefin1);
		

		Paragraph datesortie1 = new Paragraph("datedepart : "+datesortie, font);
		datesortie1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(datesortie1);
		
		Paragraph datedebut1 = new Paragraph("datedebut : "+datedebut, font);
		datedebut1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(datedebut1);
		
		Paragraph durree1 = new Paragraph("remise : "+remise, font);
		durree1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(durree1);
		
		Paragraph durree2 = new Paragraph(" enplus: "+enplus, font);
		durree2.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(durree2);
		
		Paragraph heuregratuit1 = new Paragraph(" heuregratuit: "+heuregratuit, font);
		heuregratuit1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(heuregratuit1);



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
		Font fonta = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fonta.setColor(CMYKColor.WHITE);

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
