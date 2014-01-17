package saisie;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;


public class Chap0508 {

	
	public static void main(String[] args) {
		
		     System.out.println("Chapter 5 example 8: table splitting");
	        // step 1: creation of a document-object
	        Document document = new Document();
	        try {
	        	
	            // step 2:
	            // we create a writer that listens to the document
	            // and directs a PDF-stream to a file
	            PdfWriter.getInstance(document, new FileOutputStream("Chap0508.pdf"));
	            // step 3: we open the document
	            document.open();
	            // step 4: we create a table and add it to the document
	           
	            Table table = new Table(5);
	            table.setAutoFillEmptyCells(true);
	            table.setBorderWidth(1);
	            table.setBorderColor(new Color(0, 0, 255));
	            table.setPadding(5);
	            //table.setSpacing(5);
	            Cell cell = new Cell("Liste des etudiants Boursiers de l'IPA");
	            cell.setHeader(true);
	           
	            
	            cell.setColspan(5);
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell.setBackgroundColor(Color.CYAN);
	            
	            
	            table.addCell(cell);
	            cell = new Cell("Province");
	           // cell.setRowspan(2);
	            cell.setBorderColor(new Color(255, 0, 0));
	            table.addCell(cell);
	            table.addCell("Nom de la  Commune");
	            table.addCell("Nombre de Femmes");
	            table.addCell("Nombre d'hommes");
	            table.addCell("Total");
	            
	            cell = new Cell("");
	            cell.setRowspan(3);
	            table.addCell(cell);
	           
	            Paragraph rg=new Paragraph("repeating the same table 10 times:");
	            rg.setAlignment(Element.ALIGN_CENTER);
	            document.add(rg);
	            document.add(table);
	            
	            
	            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Chap0508.pdf");

	        }
	        catch(DocumentException de) {
	            System.err.println(de.getMessage());
	        }
	        catch(IOException ioe) {
	            System.err.println(ioe.getMessage());
	        }
	        // step 5: we close the document
	        document.close();
	        
	        
	}

}
