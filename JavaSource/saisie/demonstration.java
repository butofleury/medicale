package saisie;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class demonstration extends HttpServlet implements Servlet {

	
	ByteArrayOutputStream creationPDF(){
		
		ByteArrayOutputStream op=null;
		PdfWriter secr=null;
		Document doc=null;
		op=new ByteArrayOutputStream();
		
		doc=new Document(PageSize.A4);
		
		try {
			secr=PdfWriter.getInstance(doc, op);
			
			doc.addTitle("Demonstration de la page PDF");
			doc.addProducer();
			doc.addCreationDate();
			
			doc.add(new Paragraph("Hello woorld"));
			
	        doc.close();		
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return op;
		
		
	}
	
	public void doPost(HttpServletRequest requete,HttpServletResponse reponse){
		
		
		ByteArrayOutputStream pdf=creationPDF();
		
		reponse.setHeader("Cache-Control", "max-age=30");
		reponse.setContentType("application/pdf");
		reponse.setHeader("Content-disposition", "inline;filename=jhjk.pdf");
		
		reponse.setContentLength(pdf.size());
		
		try {
			pdf.writeTo(reponse.getOutputStream());
			pdf.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			
			if(pdf!=null)
				pdf.reset();
		}
		
		
		
		
		
	}
	
	
	private Element createTable(){
		
		Table db=null;
		Cell col=null;
		int widthCollone[]={30,60,30};
		  try {
			db=new Table(3);
			
			db.setWidths(widthCollone);
			
			col=new Cell("Nom");
			col.setVerticalAlignment(Element.ALIGN_MIDDLE);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			
			col=new Cell("Prénom");
			col.setVerticalAlignment(Element.ALIGN_MIDDLE);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			
			col=new Cell("Age");
			col.setVerticalAlignment(Element.ALIGN_MIDDLE);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			
			
			col=new Cell("Nkundimana");
			
			col.setVerticalAlignment(Element.ALIGN_CENTER);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			col=new Cell("Claude");
			
			col.setVerticalAlignment(Element.ALIGN_CENTER);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			col=new Cell("35");
			
			col.setVerticalAlignment(Element.ALIGN_CENTER);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
		} catch (BadElementException e) {
		
			e.printStackTrace();
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		return db;
	}
	
	public void testPDF(){
		
		FacesContext pdf=FacesContext.getCurrentInstance();
		
		if(pdf!=null)
			try {
				
				pdf.getExternalContext().dispatch("/test.xhtml");
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			finally{
				
				pdf.responseComplete();
				
			}
	}
}
