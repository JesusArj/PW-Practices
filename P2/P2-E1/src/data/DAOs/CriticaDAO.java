package data.DAOs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import business.DTOs.CriticaDTO;
import business.DTOs.UserDTO;
import data.common.DBConnection;

public class CriticaDAO {

	public void createCritica(CriticaDTO newCritica)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createCritica");
			query.replace("varid", Integer.toString(newCritica.getId()));
			query.replace("vartitulo", newCritica.getTitle());
			query.replace("varresena", newCritica.getResena()); 
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateCritica(CriticaDTO updateCritica)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateCritica");
			query.replace("vartitulo", updateCritica.getTitle());
			query.replace("varresena", updateCritica.getResena()); 
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public void deleteCritica(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteCritica");
			query.replace("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public CriticaDTO requestCritica(int id)
	{
		CriticaDTO criticaRequest = new CriticaDTO();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataCritica");
			query.replace("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			int iduser = Integer.parseInt(rs.getString("id"));
			float puntuacion = Float.parseFloat(rs.getString("mail"));
			String titulo = rs.getString("titulo");
			String resena= rs.getString("resena");
			String mail = rs.getString("mail"); 
			
			criticaRequest.setMail(mail);
			criticaRequest.setId(iduser);
			criticaRequest.settitle(titulo);
			criticaRequest.setResena(resena);
			criticaRequest.setPuntuacion(puntuacion); 
			
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return criticaRequest;
	}
	
}
