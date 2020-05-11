package businessLogic;

import java.util.List;

import dataAccess.AnimalsDAL;
import model.Animal;


public class AnimalsBLL {
	
	public static List<Animal> viewAllAnimals() {

		return AnimalsDAL.findAll();
	}
	
	public static Animal viewAnimal(int id) {

		return AnimalsDAL.findById(id);
	}
	
	public static int insertAnimal(Animal animal) {
		
		return AnimalsDAL.insertAnimal(animal);
	}

	public static Animal editAnimal(Animal animal) {

		 return AnimalsDAL.editAnimal(animal);
	}

	public static void deleteAnimal(int id) {

		AnimalsDAL.deleteAnimal(id);
	}
	
	

}
