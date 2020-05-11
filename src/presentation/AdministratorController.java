package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import businessLogic.AnimalsBLL;
import businessLogic.Report;
import businessLogic.ReportFactory;
import businessLogic.UserBLL;
import model.Animal;
import model.User;

public class AdministratorController {

	private AdministratorView administratorView;
	private InsertUserView insertUserView;
	private DeleteUserView deleteUserView;
	private EditUserView editUserView;
	private InsertAnimalView insertAnimalView;
	private DeleteAnimalView deleteAnimalView;
	private EditAnimalView editAnimalView;
	
	AdministratorController(AdministratorView administratorView) {

        this.administratorView = administratorView;

    }

    public AdministratorController(InsertUserView insertUserView) {
    	 this.insertUserView = insertUserView;
	}

    public AdministratorController(DeleteUserView deleteUserView) {
    	this.deleteUserView = deleteUserView;
	}

	public AdministratorController(EditUserView editUserView) {
		this.editUserView = editUserView;
	}

	public void insertUser() {
    	
    	try {
    	String name=insertUserView.getName();
    	String email=insertUserView.getEmail();
    	String username=insertUserView.getUsername();
    	String password=insertUserView.getPassword();
    	
    	boolean ok1=false,ok2=false,ok3=false;
    	
			if(Pattern.matches("[a-zA-Z]+" ,name)&&!name.isEmpty()) {
				ok1=true;
			}
			else {
				insertUserView.showMessage( "Check again name!");
			}
			
			if (Pattern.matches("[a-zA-Z0-9]+",username) && !username.isEmpty() ) {
	           
	            ok2=true;
	        }
	        else
	        {
	        	insertUserView.showMessage("Check again username!");
	            ok2=false;
	        }
			if(Pattern.matches("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)" ,email)&&!email.isEmpty()) {
				ok3=true;
			}
			else {
				insertUserView.showMessage("Check again email!");
			}
			if(ok3&&ok1&&ok2) {
				User u=new User(name, email, username, password);
				UserBLL.insertUser(u);
				insertUserView.showMessage("User successfully added.");}
    	
    	}catch(Exception ex) {
			ex.printStackTrace();
			insertUserView.showMessage("Sorry, cannot insert user. Check again name, email, username&password");
		}
   	 }
	
public void editUser() {
    	
    	try {
    		int id=Integer.parseInt(editUserView.getId());
    	String name=editUserView.getName();
    	String email=editUserView.getEmail();
    	String username=editUserView.getUsername();
    	String password=editUserView.getPassword();
    	
    	boolean ok1=false,ok2=false,ok3=false;
    	
			if(Pattern.matches("[a-zA-Z]+" ,name)&&!name.isEmpty()) {
				ok1=true;
			}
			else {
				editUserView.showMessage( "Check again name!");
			}
			
			if (Pattern.matches("[a-zA-Z0-9]+",username) && !username.isEmpty() ) {
	           
	            ok2=true;
	        }
	        else
	        {
	        	editUserView.showMessage("Check again username!");
	            ok2=false;
	        }
			if(Pattern.matches("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)" ,email)&&!email.isEmpty()) {
				ok3=true;
			}
			else {
				editUserView.showMessage("Check again email!");
			}
			if(ok3&&ok1&&ok2) {
				User u=new User(id,name, email, username, password);
				UserBLL.editUser(u);
				editUserView.showMessage("User successfully edited.");}
    	
    	}catch(Exception ex) {
			ex.printStackTrace();
			editUserView.showMessage("Sorry, cannot edit user. Check again name, email, username&password");
		}
   	 }
    
	public void deleteUser() {
		try {
	    	int id=Integer.parseInt(deleteUserView.getID());
	    	if (Pattern.matches("[0-9]+",deleteUserView.getID()) && !deleteUserView.getID().isEmpty() ) {
		     
	    		UserBLL.deleteUser(id);
	    		deleteUserView.showMessage("User successfully deleted.");}
	    	
	    	}catch(Exception ex) {
				ex.printStackTrace();
				deleteUserView.showMessage("Sorry, cannot delete user.Check id");
			}
	}
	
	public void viewAllUsers() {
    	
    	try {
    	List<User> users = new ArrayList<>();
    	users=UserBLL.viewAllUsers();
    	administratorView.showMessage("Users: "+users.toString());
    //	System.out.println(users.toString());
    	}catch(Exception ex) {
			ex.printStackTrace();
			administratorView.showMessage("Sorry, cannot show users informations");
		}
   	 }
      
    public void view1User() {
    	try {
    		int id=Integer.parseInt(administratorView.getID()); 
    		if (Pattern.matches("[0-9]+",administratorView.getID()) && !administratorView.getID().isEmpty() ) {
   		     
    			User u=new User();
        		u=UserBLL.viewUser(id);
        		administratorView.showMessage(u.toString());}
	    	
    	
    	}catch(Exception ex) {
    		ex.printStackTrace();
			administratorView.showMessage("Sorry, cannot show user information. Check ID");
    	}
    }
    
    public void generateReport() {
    	try {
    		String type=administratorView.getTypeReport();
    		int id=Integer.parseInt(administratorView.getIDReport());
    		String location=administratorView.getReportLocation();
    		System.out.println("txt");
    		if(type.equals("txt")) {
    			System.out.println("txt");
    			Report r=ReportFactory.generateReport("txt");
    			r.generateReport(location, 1); //double '\' -> '\\' in location
    		}
    		else if(type.equals("pdf")) {
    			System.out.println("pdf");
    			Report r=ReportFactory.generateReport("pdf");
    			r.generateReport(location, id);
    		}
    	}catch(Exception ex) {
    		ex.printStackTrace();
			administratorView.showMessage("Sorry, cannot generate report. Check ID&type&location");
    	}
    	
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
    	administratorView.showMessage("Animals: "+animals.toString());
    //	System.out.println(users.toString());
    	}catch(Exception ex) {
			ex.printStackTrace();
			administratorView.showMessage("Sorry, cannot show animals informations");
		}
   	 }
      
    public void view1Animal() {
    	try {
    		int id=Integer.parseInt(administratorView.getID2()); 
    		if (Pattern.matches("[0-9]+",administratorView.getID2()) && !administratorView.getID2().isEmpty() ) {
   		     
    			Animal a=new Animal();
        		a=AnimalsBLL.viewAnimal(id);
        		administratorView.showMessage(a.toString());}
	    	
    	
    	}catch(Exception ex) {
    		ex.printStackTrace();
			administratorView.showMessage("Sorry, cannot show Animal information. Check ID");
    	}
    }
    
   
	
}
