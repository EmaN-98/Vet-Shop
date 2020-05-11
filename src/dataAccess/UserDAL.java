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
import model.User;

public class UserDAL {

	private static Connection conn;
	private final static String insertUser = "INSERT INTO user (name,email,username,password)" + " VALUES (?,?,?,?)";
	private final static String deleteUser = "DELETE FROM user WHERE userId = ? ";
	private final static String editUser= "UPDATE user SET name=?, email=?, username=?, password=? WHERE userId= ? ";
	private final static String findStatementString = "SELECT * FROM user where userId = ?";

	public static int insertUser(User u) {
	
		PreparedStatement stmt = null;
		ResultSet res;
		
		int userId = 0 ;
		try {
			conn = connection.ConnectionMake.getConnection();

			String name=u.getName();
			String email=u.getEmail();
			String username=u.getUsername();
			String password=u.getPassword();
						
			stmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
	
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, username);
			stmt.setString(4, password);
			
			stmt.executeUpdate();

			res = stmt.getGeneratedKeys();

		} catch (SQLException exc) {

			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot insert user. Try another ID");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		System.out.println("userId::::"+userId);
		return userId;
		
	}

	public static void deleteUser(int id) {
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(deleteUser, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sorry, cannot delete user.");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
	}
	
	public static User editUser(User u) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionMake.getConnection();
			stmt = conn.prepareStatement(editUser, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getPassword());
			stmt.setInt(5, u.getUserId());
			
			int changes =stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

            if(changes > 0) { 
            	System.out.println(changes);
                return u;
            } else {
                return null;
            }

		} catch (SQLException exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Sorry, cannot edit user. Check again the data desired");

		} finally {
			ConnectionMake.close(stmt);
			ConnectionMake.close(conn);
		}
		return null;
	}

	
	 public static List<User> findAll() {
	        
	        List<User> users = new ArrayList<>();
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM animals");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	User u = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
	            	users.add(u);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	 
	 public static User findById(int userId) {
	        
	        try {
	        	conn = ConnectionMake.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(findStatementString);
	            preparedStatement.setInt(1, userId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	User u = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
	                return u;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }
	
}
