package data.DAOs;

import business.DTOs.EspectaculoMultDTO;
import business.DTOs.EspectaculoPuntDTO;
import business.DTOs.UserDTO;
import data.common.DBConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

public class EspectaculoDAO {

	public void createEspectaculoPuntual(EspectaculoPuntDTO newPunt) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createEP");
			query=query.replaceAll("varid", Integer.toString(newPunt.getID()));
			query=query.replaceAll("vartitulo", newPunt.getTitulo());
			query=query.replaceAll("vardescripcion", newPunt.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(newPunt.getLocalidadesVenta()));
			query=query.replaceAll("varlocalidadesvendidas", Integer.toString(newPunt.getLocalidadesVendidas())); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			String formattedDateTime = newPunt.getHoraFecha().format(formatter);
			query=query.replaceAll("varfecha",	formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteEspectaculoPuntual(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteEP");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateEspectaculoPuntual(EspectaculoPuntDTO updatePunt) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("D:/Descargas/PW-Practices-master/P2/P2-E1/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateEP"); 
			query=query.replaceAll("varid", Integer.toString(updatePunt.getID()));
			query=query.replaceAll("vartitulo", updatePunt.getTitulo());
			query=query.replaceAll("vardescripcion", updatePunt.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(updatePunt.getLocalidadesVenta()));
			query=query.replaceAll("varlocalidadesvendidas", Integer.toString(updatePunt.getLocalidadesVendidas())); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
			String formattedDateTime = updatePunt.getHoraFecha().format(formatter);
			query=query.replaceAll("varfecha", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public EspectaculoPuntDTO requestEspectaculoPuntual(int id) {
		EspectaculoPuntDTO epRequest = new EspectaculoPuntDTO();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEP");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			//TODO: Falta el ID
			String ident = rs.getString("id");
			String titulo = rs.getString("titulo");
			String descripcion = rs.getString("descripcion");
			String localidades = rs.getString("localidades");
			String localidadesvendidas = rs.getString("localidadesvendidas");
			String fecha = rs.getString("fecha");
			
			//TODO: Falta el ID
			epRequest.setTitulo(titulo);
			epRequest.setDescripcion(descripcion);
			epRequest.setLocalidadesVenta(Integer.parseInt(localidades));
			epRequest.setLocalidadesVendidas(Integer.parseInt(localidadesvendidas));
			//Pasar de string a LocalDateTime
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime fecha_date = LocalDateTime.parse(fecha, formatter);
			epRequest.setHoraFecha(fecha_date);
			
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return epRequest;
	}
	
	public ArrayList<EspectaculoPuntDTO> requestEPs(){
		ArrayList<EspectaculoPuntDTO> listEPs = new ArrayList<EspectaculoPuntDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllEp");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String localidades = rs.getString("localidades");
				String localidadesvendidas = rs.getString("localidadesvendidas");
				String fecha = rs.getString("fecha");
				String categoria = rs.getString("categoria"); //Esto funcionara cuando se meta el valor categoria en la BD
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime fecha_date = LocalDateTime.parse(fecha, formatter);
				listEPs.add(new EspectaculoPuntDTO(Integer.parseInt(ident), titulo, categoria, descripcion, Integer.parseInt(localidades), Integer.parseInt(localidadesvendidas), fecha_date)); 
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listEPs;
	}
	
	public void createEspectaculoMultiple(EspectaculoMultDTO newMult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("/src/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createEM"); 
			// TODO: Falta el ID
			query=query.replaceAll("vartitulo", newMult.getTitulo());
			query=query.replaceAll("vardescripcion", newMult.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(newMult.getLocalidadesVenta()));
			query=query.replaceAll("varlocalidadesvendidas", Integer.toString(newMult.getLocalidadesVendidas())); 
			
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			
			//TODO: Query y Query3 en un bucle, por cada fecha que se quiera crear. El tamaño del bucle nos lo dirá el user, con "Cuantas fechas quiere crear"
			String query2 = prop.getProperty("createFecha");
			//TODO: ID debe ser random, con el de criticas
			query=query.replaceAll("varid", /*TODO: ???*/));
			query=query.replaceAll("varfecha", Integer.toString(newMult.getFechas())); //Pasar de String a LocalDateTime
			
			String query3 = prop.getProperty("createMFecha");
			query=query.replaceAll("varid", Integer.toString(newMult.getID())); // Este debe ser el id del espectaculo
			query=query.replaceAll("varidF", /*TODO: ???*/)); // Este debe ser el ID de la fecha
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}

}

