package businessLogic;

import java.util.List;

import dataAccess.ConsultationsDAL;
import model.Consultation;

public class ConsultationsBLL {

	public static List<Consultation> viewAllConsultations() {

		return ConsultationsDAL.findAll();
	}
	
	public static Consultation viewConsultation(int id) {

		return ConsultationsDAL.findById(id);
	}
	
	public static int insertConsultation(Consultation consultation) {
		
		return ConsultationsDAL.insertConsultation(consultation);
	}

	public static Consultation editConsultation(Consultation consultation) {

		 return ConsultationsDAL.editConsultation(consultation);
	}

	public static void deleteConsultation(int id) {

		ConsultationsDAL.deleteConsultation(id);
	}
	
}
