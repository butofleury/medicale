package saisie;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
public class TestIText23 {

	
	public static void main(String[] args) {
		
		//mysqldump -uroot -pmundanikure gestionpetrole > C:\Users\Remeny\Desktop\Backup\gestionpetrole_backup.sql
		
		Document document = new Document(PageSize.A4);
		try {
		PdfWriter.getInstance(document, new FileOutputStream("Ttest.pdf"));
		document.open();
		
		Table tableau = new Table(3,6);
		
		tableau.setPadding(2);
		
		
		tableau.setAutoFillEmptyCells(true);
		tableau.setPadding(2);
		Cell cell = new Cell("colonne 1");
		cell.setHeader(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableau.addCell(cell);
		cell = new Cell("colonne 2");
		cell.setHeader(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableau.addCell(cell);
		
		cell = new Cell("colonne 3");
		cell.setHeader(true);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableau.addCell(cell);
		tableau.endHeaders();
		 
		cell = new Cell("1.1");
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		//cell.setRowspan(2);
		tableau.addCell(cell);
		tableau.addCell("1.2");
		tableau.addCell("2.1");
		tableau.addCell("2.2");
		
		document.add(tableau);
		
		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Ttest.pdf");

		} catch (DocumentException de) {
		de.printStackTrace();
		} catch (IOException ioe) {
		ioe.printStackTrace();
		}
		document.close();
	}

}
