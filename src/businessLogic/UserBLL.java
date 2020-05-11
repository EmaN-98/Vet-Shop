package businessLogic;

import java.util.List;

import dataAccess.UserDAL;
import model.User;

public class UserBLL {
	
	public static List<User> viewAllUsers() {

		return UserDAL.findAll();
	}
	
	public static User viewUser(int id) {

		return UserDAL.findById(id);
	}
	
	public static int insertUser(User user) {
		
		return UserDAL.insertUser(user);
	}

	public static User editUser(User user) {

		 return UserDAL.editUser(user);
	}

	public static void deleteUser(int id) {

		UserDAL.deleteUser(id);
	}

}
