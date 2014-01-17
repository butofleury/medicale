package saisie;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class Main {

	public static void main(String[] args) {
		
		
		 		Document doc = new Document();
	        try {
	            PdfWriter.getInstance(doc,new FileOutputStream("ImageScaling.pdf"));
	            
	            HeaderFooter footer = new HeaderFooter(	new Phrase("DIRECTION ACADEMIQUE DE L'UNIVERSITE DU BURUNDI"),true);
	             footer.setAlignment(Element.ALIGN_CENTER);
	            HeaderFooter header=new HeaderFooter(new Phrase("DIRECTION ACADEMIQUE DE L'UNIVERSITE DU BURUNDI"),false);
	            header.setAlignment(Element.ALIGN_CENTER);
	            
	            //header.setBackgroundColor(Color.cyan);
	            
	            //header.setBorder(0);
	             doc.setFooter(footer);
	             
				doc.setHeader(header);
				
	            doc.open();           
	            String filename ="E:\\DAC\\PDF\\portrait.jpg";
	            Image image = Image.getInstance(filename);
	            
	           
			
	           image.scaleAbsolute(100f, 100f);
	           
	           image.setAlignment(Element.ALIGN_TOP);
	          image.setAlignment(Element.ALIGN_RIGHT);
	           doc.add(image);
	           Paragraph pgr=new Paragraph("Matricule:");
	           //pgr.setAlignment(1);
	           doc.add(pgr);
	           pgr=new Paragraph("Matricule1:",new Font(BaseFont.createFont(BaseFont.COURIER_OBLIQUE, BaseFont.CP1250,	BaseFont.EMBEDDED)));
	           pgr.setAlignment(0);
	           doc.add(pgr);	            
	           Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler ImageScaling.pdf");

	            
	        } catch (DocumentException  e) {
	            e.printStackTrace();
	        } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            doc.close();
	        }
	}

}
