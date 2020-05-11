package model;

public class Consultation {

	private int consultationId;
	private String animalName;
	private String doctorName;
	private String date;
	private String diagnosis;
	private String treatment;
	
	public int getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(int consultationId) {
		this.consultationId = consultationId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public Consultation(int consultationId, String animalName, String doctorName, String date, String diagnosis,
			String treatment) {
		super();
		this.consultationId = consultationId;
		this.animalName = animalName;
		this.doctorName = doctorName;
		this.date = date;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}
	public Consultation(String animalName, String doctorName, String date, String diagnosis, String treatment) {
		super();
		this.animalName = animalName;
		this.doctorName = doctorName;
		this.date = date;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}
	public Consultation() {
		super();
	}
	@Override
	public String toString() {
		return "Consultation [consultationId=" + consultationId + ", animalName=" + animalName + ", doctorName="
				+ doctorName + ", date=" + date + ", diagnosis=" + diagnosis + ", treatment=" + treatment + "]\n";
	}
	
	
	
	
}
