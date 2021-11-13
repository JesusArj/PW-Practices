package data.DAOs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import business.DTOs.UserDTO;
import data.common.DBConnection;

public class UserDAO {

	String ruta ="C:\\Users\\jesus\\eclipse-workspace\\P2\\P2\\P2-E1\\src\\sql.properties";
	public void createUser(UserDTO newUser) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createNewUser");
			query=query.replaceAll("varmail", newUser.getMail());
			query=query.replaceAll("varpass", newUser.getPasswd());
			query=query.replaceAll("varname", newUser.getName());
			query=query.replaceAll("varuser", newUser.getUsername());
			query=query.replaceAll("varrol", newUser.getRol());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			String formattedDateTime = newUser.getRegisterTime().format(formatter);
			query = query.replaceAll("varfecharegistro", formattedDateTime);
			query = query.replaceAll("varfechaultimaconex", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserDTO> selectByRol(String rol){
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectByRol");
			query = query.replace("varrol", rol);
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("mail");
				String username = rs.getString("username");
				users.add(new UserDTO(name, email,username));
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return users;
	}
	
	public String requestCredenciales(String mail) {
		String password = null;
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectPass");
			query=query.replaceAll("varmail", mail);
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			if(rs.next())
			{
			password = rs.getString("password");
			}
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return password;
	}
	
	public void deleteUser(String mail) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteUser");
			query=query.replaceAll("varmail", mail);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateUser(UserDTO updateUser) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateUser");
			query=query.replaceAll("varmail", updateUser.getMail());
			query=query.replaceAll("varpass", updateUser.getPasswd());
			query=query.replaceAll("varname", updateUser.getName());
			query=query.replaceAll("varuser", updateUser.getUsername());
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public UserDTO requestUser(String email) {
		UserDTO userRequest = new UserDTO();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataUserMail");
			query=query.replaceAll("varmail", email);
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			if(rs.next())
			{
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String username = rs.getString("username");
				String rol = rs.getString("rol");
				
				userRequest.setMail(mail);
				userRequest.setName(name);
				userRequest.setUsername(username);
				userRequest.setRol(rol);
			}
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return userRequest;
	}
	
	public UserDTO requestUserByUsername(String userName) {
		UserDTO userRequest = new UserDTO();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataUserName");
			query=query.replaceAll("varuser", userName);
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			String name = rs.getString("name");
			String mail = rs.getString("mail");
			String username = rs.getString("username");
			String rol = rs.getString("rol");
			
			userRequest.setMail(mail);
			userRequest.setName(name);
			userRequest.setUsername(username);
			userRequest.setRol(rol);
			
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return userRequest;
	}
	
	public ArrayList<UserDTO> requestUsers(){
		ArrayList<UserDTO> listUsers = new ArrayList<UserDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllUsers");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("mail");
				String username = rs.getString("username");
				String rol = rs.getString("rol");
				listUsers.add(new UserDTO(name, email,username,rol));
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

}
