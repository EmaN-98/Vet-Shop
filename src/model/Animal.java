package model;


public class Animal {
	
	private int animalId;
	private String name;
	private String species;
	private String owner;
	private int age;
	private String diseases;
	private String treatments;
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDiseases() {
		return diseases;
	}
	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}
	public String getTreatments() {
		return treatments;
	}
	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}
	public Animal(int animalId, String name, String species, String owner, int age, String diseases,
			String treatments) {
		super();
		this.animalId = animalId;
		this.name = name;
		this.species = species;
		this.owner = owner;
		this.age = age;
		this.diseases = diseases;
		this.treatments = treatments;
	}
	public Animal(String name, String species, String owner, int age, String diseases, String treatments) {
		super();
		this.name = name;
		this.species = species;
		this.owner = owner;
		this.age = age;
		this.diseases = diseases;
		this.treatments = treatments;
	}
	public Animal() {
		super();
	}
	@Override
	public String toString() {
		return "Animal [animalId=" + animalId + ", name=" + name + ", species=" + species + ", owner=" + owner
				+ ", age=" + age + ", diseases=" + diseases + ", treatments=" + treatments + "]\n";
	}
	
	
	
}
