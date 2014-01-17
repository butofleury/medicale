package saisie;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class testRep extends HttpServlet implements Servlet{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public testRep() {
		
	}
	
	
	public void testPDF(){
		
		FacesContext pdf=FacesContext.getCurrentInstance();
		
		try {
			
			pdf.getExternalContext().dispatch("/test.xhtml?partest=buja&par2=125");
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			
			pdf.responseComplete();
		}
		
	}
	
	
	/*private void createTable(){
			
			Table db=null;
			Cell col=null;
			int widthCollone[]={30,60,30};
			  try {
				db=new Table(3);
			} catch (com.lowagie.text.BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				db.setWidths(widthCollone);
			} catch (com.lowagie.text.DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.setPadding(2);
			col=new Cell("Nom");
			col.setVerticalAlignment(Element.ALIGN_MIDDLE);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			
			col=new Cell("Prénom");
			
			col.setVerticalAlignment(Element.ALIGN_MIDDLE);
			col.setHorizontalAlignment(Element.ALIGN_CENTER);
			db.addCell(col);
			
			col=new Cell("Age");
			
			db.addCell(col);
			
			
			col=new Cell("Nkundimana");
			db.addCell(col);
			col=new Cell("Claude");
			
			db.addCell(col);
			col=new Cell("35");
			
			
			db.addCell(col);
			
			//return db;
		}*/


	public void doPost(HttpServletRequest requete,HttpServletResponse reponse ) throws ServletException,IOException{
		
		System.out.println(requete.getParameter("partest")+" "+requete.getParameter("par2"));
		
		ByteArrayOutputStream op=creationDocumentPDF();
		
		reponse.setHeader("Cache-control", "max-age=30");
		reponse.setContentType("application/pdf");
		reponse.setHeader("content-disposition", "inline;filename=bj.pdf");
		
		reponse.setContentLength(op.size());
		op.writeTo(reponse.getOutputStream());
		
		op.flush();
		
		if (op != null)
		{
		  op.reset();
		}
		
		
		
		
	}
	
	private ByteArrayOutputStream creationDocumentPDF(){
		
		ByteArrayOutputStream op=null;
		PdfWriter secr=null;
		
		Document doc =new Document(PageSize.A4);
		
		op=new ByteArrayOutputStream();
		try {
			secr=PdfWriter.getInstance(doc, op);
			
			doc.addTitle("Test d'une page ");
			doc.addCreationDate();
			doc.addAuthor("Nahimana Rémeny");
			doc.addProducer();
			doc.open();
			
			doc.add(new Paragraph("Hello word mbuzi pro"));
			
			//doc.add(createTable());
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		doc.close();
		
		return op;
		
	}

}
