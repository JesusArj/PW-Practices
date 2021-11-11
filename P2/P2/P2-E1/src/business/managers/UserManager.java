package business.managers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import business.DTOs.UserDTO;
import data.DAOs.UserDAO;

public class UserManager {
	
	public Boolean login(String mail, String passwd) {
		if(this.UserExist(mail)) {
			UserDAO login = new UserDAO();
			String password = login.requestCredenciales(mail);
			if(passwd.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean createUser(String mail, String username, String name, String passwd, String rol, LocalDateTime fechaRegistro, LocalDateTime fechaConex) {	
		if(!this.UserExist(mail)) {
			UserDAO newUser = new UserDAO();
			UserDTO newUserDTO = new UserDTO(name,mail,username,passwd, rol, fechaRegistro, fechaConex);  
			newUser.createUser(newUserDTO);
			return true;
		}
		return false;
	}
	
	public Boolean updateUser(String mail, String username, String name, String passwd) {
		if(this.UserExist(mail)) {
			UserDAO newUser = new UserDAO();
			UserDTO newUserDTO = new UserDTO(name,mail,username);
			newUserDTO.setPasswd(passwd);
			newUser.updateUser(newUserDTO);
			return true;
		}
		return false;
	}
	
	public Boolean deleteUser(String mail) {
		if(this.UserExist(mail)) {
			UserDAO deleteUser = new UserDAO();
			deleteUser.deleteUser(mail);
			return true;
		}	
		return false;
	}
	
	public UserDTO requestUser(String mail) {
		UserDAO requestUser = new UserDAO();
		UserDTO requestedUser = new UserDTO();
		if(this.UserExist(mail)) {
			requestedUser = requestUser.requestUser(mail);	
		}
		return requestedUser;
	}
	
	public UserDTO requestUserByUsername(String username) {
		UserDAO requestUser = new UserDAO();
		UserDTO requestedUser = new UserDTO();
		if(this.UserExistByUsername(username)) {
			requestedUser = requestUser.requestUserByUsername(username);	
		}
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
	
	public ArrayList<String> readUser(String mail){
		ArrayList<String> userS =  new ArrayList<String>();
		if(this.UserExist(mail)) {
			UserDTO user = this.requestUser(mail);
			userS.add(user.getMail());
			userS.add(user.getName());
			userS.add(user.getUsername());	
		}
		return userS;
	}
	
	public ArrayList<UserDTO> requestByRol(String rol){
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		UserDAO requestByRol = new UserDAO();
		users = requestByRol.selectByRol(rol);		
		return users;
	}
	
	public Boolean checkAdmin(String mail) {
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		users = this.requestByRol("admin");
		for(UserDTO u : users) {
			if(u.getMail().equals(mail))
				return true;
		}
		return false;
	}
}
