package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionMake;
import model.Animal;

public class AnimalsDAL {

	private static Connection conn;
	private final static String insertAnimal = "INSERT INTO animals (name,species,owner,age,diseases,treatments)" + " VALUES (?,?,?,?,?,?)";
	private final static String deleteAnimal = "DELETE FROM animals WHERE animalId = ? ";
	private final static String editAnimal= "UPDATE animals SET name=?, species=?, owner=?, age=?, diseases=?, treatments=? WHERE animalId= ? ";
	private final static String findStatementString = "SELECT * FROM animals where animalId = ?";

	public static int insertAnimal(Animal a) {
	
		//Animal a=new Animal("name1","species1@yahoo.com","owner1",1,"diseases1","treatments1");
		PreparedStatement stmt = null;
		ResultSet res;
		
		int animalId = 0 ;
		try {
			conn = connection.ConnectionMake.getConnection();
			//userId=u.getUserId();
			String name=a.getName();
			String species=a.getSpecies();
			String owner=a.getOwner();
			int age=a.getAge();
			String diseases=a.getDiseases();
			String treatments=a.getTreatments();
						
			stmt = conn.prepareStatement(insertAnimal, Statement.RETURN_GENERATED_KEYS);
			//stmt.setInt(1, animalId);
			stmt.setString(1, name);
			stmt.setString(2, species);
			stmt.setString(3, owner);
			stmt.setInt(4,age);
			stmt.setString(5, diseases);
			stmt.setString(6, treatments);
			
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert animal. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		System.out.println("animalId::::"+animalId);
		return animalId;
		
	}

	public static void deleteAnimal(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteAnimal, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();



		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete animal.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static Animal editAnimal(Animal a) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editAnimal, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, a.getName());
			stmt.setString(2, a.getSpecies());
			stmt.setString(3, a.getOwner());
			stmt.setInt(4, a.getAge());
			stmt.setString(5, a.getDiseases());
			stmt.setString(6, a.getTreatments());
			stmt.setInt(7, a.getAnimalId());
			
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

            if(changes > 0) { 
            	System.out.println(changes);
                return a;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit animal. Check again the data desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<Animal> findAll() {
	        
	        List<Animal> animals = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM animals");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Animal a = new Animal(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7));
	                
	                animals.add(a);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return animals;
	    }
	 
	 public static Animal findById(int animalId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, animalId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                Animal a = new Animal(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7));
	                return a;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
