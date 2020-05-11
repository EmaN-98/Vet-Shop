package businessLogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import dataAccess.ConsultationsDAL;
import model.Consultation;

public class TxtReport {

	public static void generateTxtReport(String path, int consultationId) {
	
	try {										
	
		File file = new File(path, "TxtReport.txt");
		FileWriter fileWriter = 
	            new FileWriter(file);
		BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
		
		Consultation c=new Consultation();
		c=ConsultationsDAL.findById(consultationId);
		bufferedWriter.write("Report for consultation no."+c.getConsultationId()+"\nAnimal's name: "+c.getAnimalName()+"\nDoctor's name: "+c.getDoctorName()+"\ndate: "+c.getDate()+"\ndiagnosis: "+c.getDiagnosis()+"\ntreatment: "+c.getTreatment());
		
		bufferedWriter.close();
		}
		catch(FileNotFoundException ex) {
			 System.out.println(
		                "Unable to open file 'TxtReport.txt'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	//public static void main(String args[]) {
	//	generateTxtReport("D:\\Ema ^_^",1);
	//}
	
}
