package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import businessLogic.AnimalsBLL;
import businessLogic.ConsultationsBLL;
import model.Animal;
import model.Consultation;


public class UserController {
	private UserView userView;
	private InsertAnimalView insertAnimalView;
	private DeleteAnimalView deleteAnimalView;
	private EditAnimalView editAnimalView;
	private InsertConsultationView insertConsultationView;
	private DeleteConsultationView deleteConsultationView;
	private EditConsultationView editConsultationView;
	
	UserController(UserView userView) {

        this.userView = userView;

    }

    public UserController(InsertAnimalView insertAnimalView) {
    	 this.insertAnimalView = insertAnimalView;
	}

    public UserController(DeleteAnimalView deleteAnimalView) {
    	this.deleteAnimalView = deleteAnimalView;
	}

	public UserController(EditConsultationView editConsultationView) {
		this.editConsultationView = editConsultationView;
	}
	
	public UserController(InsertConsultationView insertConsultationView) {
   	 this.insertConsultationView = insertConsultationView;
	}

   public UserController(DeleteConsultationView deleteConsultationView) {
   	this.deleteConsultationView = deleteConsultationView;
	}

	public UserController(EditAnimalView editAnimalView) {
		this.editAnimalView = editAnimalView;
	}

	public void insertAnimal() {
    	
    	try {
    	String name=insertAnimalView.getName();
    	String species=insertAnimalView.getSpecies();
    	String owner=insertAnimalView.getOowner();
    	String age=insertAnimalView.getAge();
    	int agei=Integer.parseInt(age);
    	String diseases=insertAnimalView.getDiseases();
    	String treatments=insertAnimalView.getTreatments();
    	
    	boolean ok1=false,ok2=false,ok3=false,ok4=false,ok5=false,ok6=false;
    	
			if(Pattern.matches("[a-z A-Z]+" ,name)&&!name.isEmpty()) {
				ok1=true;
			}
			else {
				insertAnimalView.showMessage( "Check again name!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,species)&&!species.isEmpty()) {
				ok2=true;
			}
			else {
				insertAnimalView.showMessage( "Check again species!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,owner)&&!owner.isEmpty()) {
				ok3=true;
			}
			else {
				insertAnimalView.showMessage( "Check again owner!");
			}
			
			if (Pattern.matches("[0-9]+",age) && !age.isEmpty() ) {
	           
	            ok4=true;
	        }
	        else
	        {
	        	insertAnimalView.showMessage("Check again age!");
	        }
	        
	        if(Pattern.matches("[a-zA-Z]+" ,diseases)&&!diseases.isEmpty()) {
				ok5=true;
			}
			else {
				insertAnimalView.showMessage( "Check again diseases!");
			}
			if(Pattern.matches("[a-z A-Z]+" ,treatments)&&!treatments.isEmpty()) {
				ok6=true;
			}
			else {
				insertAnimalView.showMessage( "Check again treatments!");
			}
			
			if(ok3&&ok1&&ok2&&ok4&&ok5&&ok6) {
				Animal a=new Animal(name, species, owner, agei, diseases, treatments);
				AnimalsBLL.insertAnimal(a);
				insertAnimalView.showMessage("Animal successfully added.");}
    	
    	}catch(Exception ex) {
			ex.printStackTrace();
			insertAnimalView.showMessage("Sorry, cannot insert animal. Check again name, species, owner, age, diseases&treatments");
		}
   	 }
	
public void editAnimal() {
    	
    	try {
    		String id=editAnimalView.getID();
        	int idi=Integer.parseInt(id);
    	String name=editAnimalView.getName();
    	String species=editAnimalView.getSpecies();
    	String owner=editAnimalView.getOowner();
    	String age=editAnimalView.getAge();
    	int agei=Integer.parseInt(age);
    	String diseases=editAnimalView.getDiseases();
    	String treatments=editAnimalView.getTreatments();
    	
    	boolean ok1=false,ok2=false,ok3=false,ok4=false,ok5=false,ok6=false, ok7=false;
    	
			if(Pattern.matches("[a-z A-Z]+" ,name)&&!name.isEmpty()) {
				ok1=true;
			}
			else {
				editAnimalView.showMessage( "Check again name!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,species)&&!species.isEmpty()) {
				ok2=true;
			}
			else {
				editAnimalView.showMessage( "Check again species!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,owner)&&!owner.isEmpty()) {
				ok3=true;
			}
			else {
				editAnimalView.showMessage( "Check again owner!");
			}
			
			if (Pattern.matches("[0-9]+",age) && !age.isEmpty() ) {
	           
	            ok4=true;
	        }
	        else
	        {
	        	editAnimalView.showMessage("Check again age!");
	        }
	        
	        if(Pattern.matches("[a-z A-Z]+" ,diseases)&&!diseases.isEmpty()) {
				ok5=true;
			}
			else {
				editAnimalView.showMessage( "Check again diseases!");
			}
			if(Pattern.matches("[a-z A-Z]+" ,treatments)&&!treatments.isEmpty()) {
				ok6=true;
			}
			else {
				editAnimalView.showMessage( "Check again treatments!");
			}
			if (Pattern.matches("[0-9]+",id) && !id.isEmpty() ) {
		           
	            ok7=true;
	        }
	        else
	        {
	        	editAnimalView.showMessage("Check again ID!");
	        }
			
			if(ok3&&ok1&&ok2&&ok4&&ok5&&ok6&&ok7) {
				Animal a=new Animal(idi, name, species, owner, agei, diseases, treatments);
				AnimalsBLL.editAnimal(a);
				editAnimalView.showMessage("Animal successfully edited.");}
    	
    	}catch(Exception ex) {
			ex.printStackTrace();
			editAnimalView.showMessage("Sorry, cannot edit animal. Check again id, name, species, owner, age, diseases&treatments");
		}
   	 }
	

    
	public void deleteAnimal() {
		try {
	    	int id=Integer.parseInt(deleteAnimalView.getID());
	    	if (Pattern.matches("[0-9]+",deleteAnimalView.getID()) && !deleteAnimalView.getID().isEmpty() ) {
		     
	    		AnimalsBLL.deleteAnimal(id);
	    		deleteAnimalView.showMessage("Animal successfully deleted.");}
	    	
	    	}catch(Exception ex) {
				ex.printStackTrace();
				deleteAnimalView.showMessage("Sorry, cannot delete animal.Check id");
			}
	}
	
	public void viewAllAnimals() {
    	
    	try {
    	List<Animal> animals = new ArrayList<>();
    	animals=AnimalsBLL.viewAllAnimals();
    	userView.showMessage("Animals: "+animals.toString());

    	}catch(Exception ex) {
			ex.printStackTrace();
			userView.showMessage("Sorry, cannot show animals informations");
		}
   	 }
      
    public void view1Animal() {
    	try {
    		int id=Integer.parseInt(userView.getIDanimal()); 
    		if (Pattern.matches("[0-9]+",userView.getIDanimal()) && !userView.getIDanimal().isEmpty() ) {
   		     
    			Animal u=new Animal();
        		u=AnimalsBLL.viewAnimal(id);
        		userView.showMessage(u.toString());}
	    	
    	
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		userView.showMessage("Sorry, cannot show animal information. Check ID");
    	}
    }
    
    
public void insertConsultation() {
    	
    	try {
    	String animalName=insertConsultationView.getAnimalName();
    	String doctorName=insertConsultationView.getDoctorName();
    	String date=insertConsultationView.getDate();
    	String diagnosis=insertConsultationView.getDiagnosis();
    	String treatment=insertConsultationView.getTreatment();
    	
    	boolean ok1=false,ok2=false,ok3=false,ok4=false,ok5=false;
    	
			if(Pattern.matches("[a-z A-Z]+" ,animalName)&&!animalName.isEmpty()) {
				ok1=true;
			}
			else {
				insertConsultationView.showMessage( "Check again animalName!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,doctorName)&&!doctorName.isEmpty()) {
				ok2=true;
			}
			else {
				insertConsultationView.showMessage( "Check again doctorName!");
			}
			
			if(Pattern.matches("^\\d?\\d.\\d{2}.\\d{4}$" ,date)&&!date.isEmpty()) {
				ok3=true;
			}
			else {
				insertConsultationView.showMessage( "Check again date!");
			}
			
			if (Pattern.matches("[a-z A-Z]+",diagnosis) && !diagnosis.isEmpty() ) {
	           
	            ok4=true;
	        }
	        else
	        {
	        	insertConsultationView.showMessage("Check again diagnosis!");
	        }
	        
	        if(Pattern.matches("[a-z A-Z]+" ,treatment)&&!treatment.isEmpty()) {
				ok5=true;
			}
			else {
				insertConsultationView.showMessage( "Check again treatment!");
			}
			
			
			if(ok3&&ok1&&ok2&&ok4&&ok5) {
				Consultation c=new Consultation(animalName, doctorName, date, diagnosis, treatment);
				ConsultationsBLL.insertConsultation(c); 
				insertConsultationView.showMessage("Consultation successfully added.");}
    	
    	}catch(Exception ex) {
			ex.printStackTrace();
			insertConsultationView.showMessage("Sorry, cannot insert Consultation. Check again animalName, doctorName, date, diagnosis, treatment");
		}
   	 }
    

public void editConsultation() {
  	
  	try {
  	String animalName=editConsultationView.getAnimalName();
  	String doctorName=editConsultationView.getDoctorName();
  	String date=editConsultationView.getDate();
  	String diagnosis=editConsultationView.getDiagnosis();
  	String treatment=editConsultationView.getTreatment();
  	String id=editConsultationView.getID();
  	int idi=Integer.parseInt(id);
  	
  	boolean ok1=false,ok2=false,ok3=false,ok4=false,ok5=false,ok6=false;
  	
			if(Pattern.matches("[a-z A-Z]+" ,animalName)&&!animalName.isEmpty()) {
				ok1=true;
			}
			else {
				editConsultationView.showMessage( "Check again animalName!");
			}
			
			if(Pattern.matches("[a-z A-Z]+" ,doctorName)&&!doctorName.isEmpty()) {
				ok2=true;
			}
			else {
				editConsultationView.showMessage( "Check again doctorName!");
			}
			
			if(Pattern.matches("^\\d?\\d.\\d{2}.\\d{4}$" ,date)&&!date.isEmpty()) {
				ok3=true;
			}
			else {
				editConsultationView.showMessage( "Check again date!");
			}
			
			if (Pattern.matches("[a-z A-Z]+",diagnosis) && !diagnosis.isEmpty() ) {
	           
	            ok4=true;
	        }
	        else
	        {
	        	editConsultationView.showMessage("Check again diagnosis!");
	        }
	        
	        if(Pattern.matches("[a-z A-Z]+" ,treatment)&&!treatment.isEmpty()) {
				ok5=true;
			}
			else {
				editConsultationView.showMessage( "Check again treatment!");
			}
	        
	        if(Pattern.matches("[0-9]+" ,id)&&!id.isEmpty()) {
				ok6=true;
			}
			else {
				editConsultationView.showMessage( "Check again ID!");
			}
			
			
			if(ok3&&ok1&&ok2&&ok4&&ok5&&ok6) {
				Consultation c=new Consultation(idi, animalName, doctorName, date, diagnosis, treatment);
				ConsultationsBLL.editConsultation(c); 
				editConsultationView.showMessage("Consultation successfully edited.");}
  	
  	}catch(Exception ex) {
			ex.printStackTrace();
			editConsultationView.showMessage("Sorry, cannot edit Consultation. Check again animalName, doctorName, date, diagnosis, treatment");
		}
 	 }

	public void deleteConsultation() {
		try {
			int id=Integer.parseInt(deleteConsultationView.getID());
			if (Pattern.matches("[0-9]+",deleteConsultationView.getID()) && !deleteConsultationView.getID().isEmpty() ) {
	     
				ConsultationsBLL.deleteConsultation(id);
    		deleteConsultationView.showMessage("Consultation successfully deleted.");}
			
    	}catch(Exception ex) {
			ex.printStackTrace();
			deleteConsultationView.showMessage("Sorry, cannot delete Consultation.Check id");
		}
}

	public void viewAllConsultations() {
    	
    	try {
    	List<Consultation> consultations = new ArrayList<>();
    	consultations=ConsultationsBLL.viewAllConsultations();
    	userView.showMessage("Consultations: "+consultations.toString());

    	}catch(Exception ex) {
			ex.printStackTrace();
			userView.showMessage("Sorry, cannot show consultations informations");
		}
   	 }
      
    public void view1Consultation() {
    	try {
    		int id=Integer.parseInt(userView.getIDconsultation()); 
    		if (Pattern.matches("[0-9]+",userView.getIDconsultation()) && !userView.getIDconsultation().isEmpty() ) {
   		     
    			Consultation u=new Consultation();
        		u=ConsultationsBLL.viewConsultation(id);
        		userView.showMessage(u.toString());}
	    	
    	
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		userView.showMessage("Sorry, cannot show consultation information. Check ID");
    	}
    }
    
    
}
