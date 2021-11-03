package business.managers;

import java.util.ArrayList;

import business.DTOs.UserDTO;
import data.DAOs.UserDAO;

public class UserManager {
	
	public UserManager() {
	}
	
	public String findAdultUsers(){
		UserDAO userByAge = new UserDAO();
		String usersInfo = "";
			ArrayList<UserDTO> users = userByAge.requestUsers();
			for (UserDTO u: users) {
				usersInfo += u.toString() + "\n";
			}
			return usersInfo;
	}
	
	
	// Other methods to manage users...
	
}
