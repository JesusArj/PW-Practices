package data.DAOs;

import java.sql.*;
import java.util.ArrayList;
import business.DTOs.UserDTO;
import data.common.DBConnection;

public class UserDAO {

	public void createUser() {
		
	}
	
	public void deleteUser(UserDTO user) {
		
	}
	
	public void updateUser(UserDTO user) {
		
	}
	
	public UserDTO readUser(String email) {
		UserDTO placeHolder = null;
		return placeHolder;
	}
	
	public ArrayList<UserDTO> requestUsers(){
		ArrayList<UserDTO> listUsers = new ArrayList<UserDTO>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			String query = "A"; //Aqui usaremos las funciones del sql.properties.
			
			// Podemos hacer esto o en el DBConnection meter un metodo para cada 
				//CRUD y nos ahorramos esto.
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String username = rs.getString("username");
				listUsers.add(new UserDTO(name, email,username));
			}

			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listUsers;
	}
	
	//TODO todas las funciones que necesitemos en 
	//las que hagamos uso de BD o la cambiemos. 
}
