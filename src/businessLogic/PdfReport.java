package businessLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import dataAccess.ConsultationsDAL;
import model.Consultation;

	public class PdfReport {
		
		public static void generatePdfReport(String path, int consultationId) {
			
			try {										
				Consultation c=new Consultation();
				c=ConsultationsDAL.findById(consultationId);
				
				 PDDocument document = new PDDocument();
				 PDPage pg=new PDPage();
			      document.addPage(pg);
			     //document.save("D:\\Ema ^_^\\VetShop.BlankPdf.pdf");
			   // pg.setContents(contents);
			      PDPageContentStream cont = new PDPageContentStream(document, pg);

		                cont.beginText();

		                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
		                cont.setLeading(14.5f);

		                cont.newLineAtOffset(25, 700);
		              
		                cont.showText("Report for consultation no."+c.getConsultationId());
		                cont.newLine();		                cont.newLine();

		                cont.showText("Animal's name: "+c.getAnimalName());
		                cont.newLine();

		                cont.showText("Doctor's name: "+c.getDoctorName());
		                cont.newLine();
		                
		                cont.showText("Date: "+c.getDate());
		                cont.newLine();
		                
		                cont.showText("Diagnosis: "+c.getDiagnosis());
		                cont.newLine();
		                
		                cont.showText("Treatment: "+c.getTreatment());
		                cont.newLine();
		                
		                cont.endText();
		               cont.close();
		            
			      document.save(path+"\\PdfReport.pdf");
			      System.out.println("PDF created");
			      document.close();
				
				}
				catch(FileNotFoundException ex) {
					 System.out.println(
				                "Unable to open file 'PdfReport.pdf'");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		

	  
	//   public static void main(String args[]) {
	//		generatePdfReport("D:\\Ema ^_^\\VetShop",1);
	//	}
}
