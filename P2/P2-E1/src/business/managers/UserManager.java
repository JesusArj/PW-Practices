package business.managers;

import java.util.ArrayList;

import business.DTOs.UserDTO;
import data.DAOs.UserDAO;

public class UserManager {
	
	public UserManager() {
	}
	
	public void createUser(String mail, String username, String name, String passwd) {
		UserDAO newUser = new UserDAO();
		UserDTO newUserDTO = new UserDTO(name,mail,username,passwd);  
		newUser.createUser(newUserDTO);
	}
	
	public void updateUser(String mail, String username, String name, String passwd) {
		UserDAO newUser = new UserDAO();
		UserDTO newUserDTO = new UserDTO(name,mail,username,passwd);  
		newUser.updateUser(newUserDTO);
	}
	
	public void deleteUser(String mail) {
		UserDAO deleteUser = new UserDAO();
		deleteUser.deleteUser(mail);
	}
	
	public UserDTO requestUser(String mail) {
		UserDAO requestUser = new UserDAO();
		UserDTO requestedUser = new UserDTO();
		requestedUser = requestUser.requestUser(mail);
		return requestedUser;
	}
	
	public UserDTO requestUserByUsername(String username) {
		UserDAO requestUser = new UserDAO();
		UserDTO requestedUser = new UserDTO();
		requestedUser = requestUser.requestUserByUsername(username);
		return requestedUser;
	}
	
	public ArrayList<UserDTO> requestUsers(){
		UserDAO requestUser = new UserDAO();
		ArrayList<UserDTO> requestedUsers = new ArrayList<UserDTO>();
		requestedUsers = requestUser.requestUsers();
		return requestedUsers;
	}
	
	public Boolean UserExist(String mail) {
		ArrayList<UserDTO> users = this.requestUsers();
		for(UserDTO u : users) {
			if(u.getMail().equals(mail)) {
				return true;
			}
		}
		return false;	
	}
	
	public Boolean UserExistByUsername(String username) {
		ArrayList<UserDTO> users = this.requestUsers();
		for(UserDTO u : users) {
			if(u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;	
	}
	
}
