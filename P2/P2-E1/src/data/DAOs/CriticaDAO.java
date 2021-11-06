package data.DAOs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import business.DTOs.CriticaDTO;
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
			query=query.replaceAll("varid", Integer.toString(newCritica.getId()));
			query=query.replaceAll("vartitulo", newCritica.getTitle());
			query=query.replaceAll("varresena", newCritica.getResena()); 
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
			query=query.replaceAll("vartitulo", updateCritica.getTitle());
			query=query.replaceAll("varresena", updateCritica.getResena()); 
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
			query=query.replaceAll("varid", Integer.toString(id));
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
			query=query.replaceAll("varid", Integer.toString(id));
			
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
	
	public ArrayList<CriticaDTO> requestCriticas(){
		ArrayList<CriticaDTO> listCriticas = new ArrayList<CriticaDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllCriticas");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				float puntuacion = rs.getFloat("puntuacion");
				String resena = rs.getString("resena");
				int id = rs.getInt("id");
				String mail = rs.getString("mail");
				listCriticas.add(new CriticaDTO(titulo,puntuacion,resena,id,mail));
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listCriticas;
	}

}
	
