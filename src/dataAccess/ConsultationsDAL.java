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
import model.Consultation;


public class ConsultationsDAL {

	private static Connection conn;
	private final static String insertConsultation = "INSERT INTO consultations (animalName,doctorName,date,diagnosis,treatment)" + " VALUES (?,?,?,?,?)";
	private final static String deleteConsultation = "DELETE FROM consultations WHERE consultationId = ? ";
	private final static String editConsultation= "UPDATE consultations SET animalName=?, doctorName=?, date=?, diagnosis=?, treatment=? WHERE consultationId= ? ";
	private final static String findStatementString = "SELECT * FROM consultations where consultationId = ?";

	public static int insertConsultation(Consultation c) {
	
		PreparedStatement stmt = null;
		ResultSet res;
		
		int consultationId = 0 ;
		try {
			conn = connection.ConnectionMake.getConnection();
			//userId=u.getUserId();
			String animalName=c.getAnimalName();
			String doctorName=c.getDoctorName();
			String date=c.getDate();
			String diagnosis=c.getDiagnosis();
			String treatment=c.getTreatment();
						
			stmt = conn.prepareStatement(insertConsultation, Statement.RETURN_GENERATED_KEYS);
	
			stmt.setString(1, animalName);
			stmt.setString(2, doctorName);
			stmt.setString(3, date);
			stmt.setString(4, diagnosis);
			stmt.setString(5, treatment);
			
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert consultation. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		System.out.println("consultationId::::"+consultationId);
		return consultationId;
		
	}

	public static void deleteConsultation(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteConsultation, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();



		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete consultation.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static Consultation editConsultation(Consultation c) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editConsultation, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, c.getAnimalName());
			stmt.setString(2, c.getDoctorName());
			stmt.setString(3, c.getDate());
			stmt.setString(5, c.getDiagnosis());
			stmt.setString(6, c.getTreatment());
			stmt.setInt(7, c.getConsultationId());
						
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

            if(changes > 0) { 
            	System.out.println(changes);
                return c;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit consultation. Check again the data desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<Consultation> findAll() {
	        
	        List<Consultation> consultations = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM consultations");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	Consultation c = new Consultation(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
	            	consultations.add(c);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return consultations;
	    }
	 
	 public static Consultation findById(int consultationId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, consultationId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	Consultation a = new Consultation(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
	                return a;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
