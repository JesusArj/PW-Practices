package data.DAOs;

import business.DTOs.EspectaculoMultDTO;
import business.DTOs.EspectaculoPuntDTO;
import business.DTOs.EspectaculoTempDTO;
import business.DTOs.FechasDTO;
import business.DTOs.PasesDTO;
import data.common.DBConnection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class EspectaculoDAO {

	String ruta ="/home/valentin/Downloads/PW-Practices-master/P2/P2/P2-E1/src/sql.properties";
	private boolean existIdPunt(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDEP");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}
	
	private boolean existIdMult(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDEM");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}
	
	private boolean existIdTemp(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDET");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}

	private boolean existIdFecha(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDFecha");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}

	private boolean existIdMultFechas(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDMF");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}

	private boolean existIdPases(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDPases");
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next())
			{
				if(Integer.parseInt(rs.getString("id"))==id)
				{
					return true; 
				}
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return false; 
	}
	
	public int generarIdPases()
	{
		
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdPases(id) == true)
		{
			generarIdPases();
		}
		return id;
	}
	
	public int generarIDMultFechas()
	{
		
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdMultFechas(id) == true)
		{
			generarIDMultFechas();
		}
		return id;
	}
	
	public int generarIDFecha()
	{
		
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdFecha(id) == true)
		{
			generarIDFecha();
		}
		return id;
	}
	
	public int generarIDMult()
	{
		
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdMult(id) == true)
		{
			generarIDMult();
		}
		return id;
	}

	public int generarIDPunt()
	{
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdPunt(id) == true)
		{
			generarIDPunt();
		}
		return id;
	}
	
	public int generarIDTemp()
	{
		
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdTemp(id) == true)
		{
			generarIDTemp();
		}
		return id;
	}
	
	public void createEspectaculoPuntual(EspectaculoPuntDTO newPunt) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createEP");
			query=query.replaceAll("varid", Integer.toString(newPunt.getID())); 
			query=query.replaceAll("vartitulo", newPunt.getTitulo());
			query=query.replaceAll("vardescripcion", newPunt.getDescripcion());
			System.out.println(newPunt.getLocalidadesVenta());
			query=query.replaceAll("varlocalidades", Integer.toString(newPunt.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(newPunt.getLocalidadesVendidas())); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = newPunt.getHoraFecha().format(formatter);
			query=query.replaceAll("varfecha",	formattedDateTime);
			query=query.replaceAll("varcategoria", newPunt.getCategoria());
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteEspectaculoPuntual(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteEP");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateEspectaculoPuntual(EspectaculoPuntDTO updatePunt) { 
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("D:/Descargas/PW-Practices-master/P2/P2-E1/home/valentin/Downloads/PW-Practices-master/P2/P2/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateEP"); 
			query=query.replaceAll("varid", Integer.toString(updatePunt.getID()));
			query=query.replaceAll("vartitulo", updatePunt.getTitulo());
			query=query.replaceAll("vardescripcion", updatePunt.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(updatePunt.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(updatePunt.getLocalidadesVendidas())); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = updatePunt.getHoraFecha().format(formatter);
			query=query.replaceAll("varfecha", formattedDateTime);
			query=query.replaceAll("varcategoria", updatePunt.getCategoria());
			
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
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEP");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			
			String ident = rs.getString("id");
			String titulo = rs.getString("titulo");
			String descripcion = rs.getString("descripcion");
			String localidades = rs.getString("localidades");
			String localidadesvendidas = rs.getString("localidadesvendidas");
			String fecha = rs.getString("fecha");
			String categoria = rs.getString("categoria");
			
			epRequest.setId(Integer.parseInt(ident));
			epRequest.setTitulo(titulo);
			epRequest.setDescripcion(descripcion);
			epRequest.setLocalidadesVenta(Integer.parseInt(localidades));
			epRequest.setLocalidadesVendidas(Integer.parseInt(localidadesvendidas));
			//Pasar de string a LocalDateTime
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDateTime fecha_date = LocalDateTime.parse(fecha, formatter);
			epRequest.setHoraFecha(fecha_date);
			epRequest.setCategoria(categoria);
			
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
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllEP");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String localidades = rs.getString("localidades");
				String localidadesvendidas = rs.getString("localidadesvendidas");
				String fecha = rs.getString("fecha");
				String categoria = rs.getString("categoria");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
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
	
	
	//Espectaculo Multiple
	public void createEspectaculoMultiple(EspectaculoMultDTO newMult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createEM");
			query=query.replaceAll("varid", Integer.toString(generarIDMult())); //TODO: Make sense?
			query=query.replaceAll("vartitulo", newMult.getTitulo());
			query=query.replaceAll("vardescripcion", newMult.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(newMult.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(newMult.getLocalidadesVendidas())); 
			query=query.replaceAll("categoria", newMult.getCategoria());
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void createFecha(FechasDTO newFecha, int idEspectaculo) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			
			String query = prop.getProperty("createFecha");
			query=query.replaceAll("varid", Integer.toString(generarIDFecha())); //TODO: Make sense?
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = newFecha.getFecha().format(formatter);
			query=query.replaceAll("varfecha", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			String query2=prop.getProperty("createMFecha");
			query2=query2.replaceAll("varid", Integer.toString(idEspectaculo));
			query2=query2.replaceAll("varidfecha",Integer.toString(newFecha.getID()));
			stmt.executeUpdate(query2);
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteEspectaculoMultiple(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteEM");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			String query2 = prop.getProperty("deleteFecha");
			query2 = query2.replaceAll("varid", Integer.toString(id));
			stmt.executeUpdate(query2);
			
			String query3 = prop.getProperty("deleteMFecha2");
			query3 = query3.replaceAll("varid", Integer.toString(id));
			stmt.executeUpdate(query3);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public void deleteFecha(FechasDTO deleteFecha) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteFecha");
			query=query.replaceAll("varid", Integer.toString(deleteFecha.getID()));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteMFecha(int idfecha) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteMFecha");
			query=query.replaceAll("varid", Integer.toString(idfecha));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateEspectaculoMultiple(EspectaculoMultDTO updateMult) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("D:/Descargas/PW-Practices-master/P2/P2-E1/home/valentin/Downloads/PW-Practices-master/P2/P2/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateEM"); 
			query=query.replaceAll("varid", Integer.toString(updateMult.getID()));
			query=query.replaceAll("vartitulo", updateMult.getTitulo());
			query=query.replaceAll("vardescripcion", updateMult.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(updateMult.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(updateMult.getLocalidadesVendidas())); 
			query=query.replaceAll("varcategoria", updateMult.getCategoria());
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateFecha(FechasDTO updateFecha, int idEspectaculo) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			
			String query = prop.getProperty("updateFecha");
			query=query.replaceAll("varid", Integer.toString(idEspectaculo));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = updateFecha.getFecha().format(formatter);
			query=query.replaceAll("varfecha", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public EspectaculoMultDTO requestEspectaculoMultiple(int id) {
		EspectaculoMultDTO emRequest = new EspectaculoMultDTO();
		ArrayList<FechasDTO> listFechas = new ArrayList<FechasDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEM");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			String ident = rs.getString("id");
			String titulo = rs.getString("titulo");
			String descripcion = rs.getString("descripcion");
			String localidades = rs.getString("localidades");
			String localidadesvendidas = rs.getString("localidadesvendidas");
			String categoria = rs.getString("categoria");
			
			emRequest.setId(Integer.parseInt(ident));
			emRequest.setTitulo(titulo);
			emRequest.setDescripcion(descripcion);
			emRequest.setLocalidadesVenta(Integer.parseInt(localidades));
			emRequest.setLocalidadesVendidas(Integer.parseInt(localidadesvendidas));
			emRequest.setCategoria(categoria);
			
			String query2 = prop.getProperty("selectFechasEspMul");
			query2 = query2.replaceAll("varid", Integer.toString(id));
			
			ResultSet rs2 = (ResultSet) stmt.executeQuery(query);
			
			while (rs2.next()) {
				String idf = rs.getString("id");
				String fecha = rs.getString("fecha");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fecha_date = LocalDateTime.parse(fecha, formatter);
				listFechas.add(new FechasDTO(Integer.parseInt(idf), fecha_date));
			}
			
			emRequest.setFechas(listFechas);
			
			if (stmt != null){ 
				stmt.close(); 
			}
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return emRequest;
	}
	
	public ArrayList<EspectaculoMultDTO> requestEMs(){
		ArrayList<EspectaculoMultDTO> listEMs = new ArrayList<EspectaculoMultDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllEM");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String localidades = rs.getString("localidades");
				String localidadesvendidas = rs.getString("localidadesvendidas");
				String categoria = rs.getString("categoria");
				int identEsp = Integer.parseInt(ident);
				
				listEMs.add(new EspectaculoMultDTO(identEsp, titulo, categoria, descripcion, Integer.parseInt(localidades), Integer.parseInt(localidadesvendidas), requestFechasEsp(identEsp)));
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listEMs;
	}
	
	//Espectaculos Temporada
	
	public void createEspectaculoTemporada(EspectaculoTempDTO newTemp) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createET");
			query=query.replaceAll("varid", Integer.toString(generarIDTemp()));
			query=query.replaceAll("vartitulo", newTemp.getTitulo()); 
			query=query.replaceAll("vardescripcion", newTemp.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(newTemp.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(newTemp.getLocalidadesVendidas())); 
			query=query.replaceAll("categoria", newTemp.getCategoria());
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void createPase(PasesDTO newPase, int idEspectaculo) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			
			String query = prop.getProperty("createPases");
			query=query.replaceAll("varid", Integer.toString(generarIdPases()));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = newPase.getFechaInicio().format(formatter);
			query=query.replaceAll("varfechaInicio", formattedDateTime);
			
			query = query.replaceAll("diaSemana", newPase.getDiaSemana());
			
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			formattedDateTime = newPase.getFechaFinal().format(formatter);
			query=query.replaceAll("varfechaFinal", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			String query2=prop.getProperty("createMPase");
			query2=query2.replaceAll("varid", Integer.toString(idEspectaculo));
			query2=query2.replaceAll("varidpase",Integer.toString(newPase.getID()));
			stmt.executeUpdate(query2);
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteEspectaculoTemporada(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteET");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			
			String query2 = prop.getProperty("deletePases");
			query2 = query2.replaceAll("varid", Integer.toString(id));
			stmt.executeUpdate(query2);
			
			String query3 = prop.getProperty("deleteMPases2");
			query3 = query3.replaceAll("varid", Integer.toString(id));
			stmt.executeUpdate(query3);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public void deletePase(PasesDTO deletePase) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deletePase");
			query=query.replaceAll("varid", Integer.toString(deletePase.getID()));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void deleteTPase(int idpase) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteMPase");
			query=query.replaceAll("varid", Integer.toString(idpase));
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updateEspectaculoTemporada(EspectaculoTempDTO updateTemp) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream("D:/Descargas/PW-Practices-master/P2/P2-E1/home/valentin/Downloads/PW-Practices-master/P2/P2/sql.properties")){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateET"); 
			query=query.replaceAll("varid", Integer.toString(updateTemp.getID()));
			query=query.replaceAll("vartitulo", updateTemp.getTitulo());
			query=query.replaceAll("vardescripcion", updateTemp.getDescripcion());
			query=query.replaceAll("varlocalidades", Integer.toString(updateTemp.getLocalidadesVenta()));
			query=query.replaceAll("varvendidas", Integer.toString(updateTemp.getLocalidadesVendidas())); 
			query=query.replaceAll("varcategoria", updateTemp.getCategoria());
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void updatePase(PasesDTO updatePase, int idEspectaculo) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			
			String query = prop.getProperty("updatePase");
			query=query.replaceAll("varid", Integer.toString(idEspectaculo));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			String formattedDateTime = updatePase.getFechaInicio().format(formatter);
			query=query.replaceAll("varfechaInicio", formattedDateTime);
			
			query=query.replaceAll("diaSemana", updatePase.getDiaSemana());
			
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
			formattedDateTime = updatePase.getFechaInicio().format(formatter);
			query=query.replaceAll("varfechaFinal", formattedDateTime);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public EspectaculoTempDTO requestEspectaculoTemporada(int id) {
		EspectaculoTempDTO etRequest = new EspectaculoTempDTO();
		ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataET");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			String ident = rs.getString("id");
			String titulo = rs.getString("titulo");
			String descripcion = rs.getString("descripcion");
			String localidades = rs.getString("localidades");
			String localidadesvendidas = rs.getString("localidadesvendidas");
			String categoria = rs.getString("categoria");
			
			etRequest.setId(Integer.parseInt(ident));
			etRequest.setTitulo(titulo);
			etRequest.setDescripcion(descripcion);
			etRequest.setLocalidadesVenta(Integer.parseInt(localidades));
			etRequest.setLocalidadesVendidas(Integer.parseInt(localidadesvendidas));
			etRequest.setCategoria(categoria);
			
			String query2 = prop.getProperty("selectPasesEspTemp");
			query2 = query2.replaceAll("varid", Integer.toString(id));
			
			ResultSet rs2 = (ResultSet) stmt.executeQuery(query);
			
			while (rs2.next()) {
				String idf = rs.getString("id");
				String fecha = rs.getString("fechaInicio");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaInicio = LocalDateTime.parse(fecha, formatter);
				String diaSemana = rs.getString("diaSemana");
				fecha = rs.getString("fechaFinal");
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaFinal = LocalDateTime.parse(fecha, formatter);
				listPases.add(new PasesDTO(Integer.parseInt(idf), fechaInicio, diaSemana, fechaFinal));
			}
			
			etRequest.setPases(listPases);
			
			if (stmt != null){ 
				stmt.close(); 
			}
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return etRequest;
	}
	
	public ArrayList<EspectaculoTempDTO> requestETs(){
		ArrayList<EspectaculoTempDTO> listETs = new ArrayList<EspectaculoTempDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllET");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String localidades = rs.getString("localidades");
				String localidadesvendidas = rs.getString("localidadesvendidas");
				String categoria = rs.getString("categoria");
				int identEsp = Integer.parseInt(ident);
				
				listETs.add(new EspectaculoTempDTO(identEsp, titulo, categoria, descripcion, Integer.parseInt(localidades), Integer.parseInt(localidadesvendidas),requestPasesEsp(identEsp)));
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listETs;
	}
	
	public ArrayList<FechasDTO> requestFechas(){
		ArrayList<FechasDTO> listFechas = new ArrayList<FechasDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllFechas");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String fechaBD =  rs.getString("fecha");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fecha = LocalDateTime.parse(fechaBD, formatter);
				listFechas.add(new FechasDTO(Integer.parseInt(ident), fecha));
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listFechas;
	}
	
	public ArrayList<PasesDTO> requestPases(){
		ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllPases");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String fechaBD =  rs.getString("fechaInicio");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaInicio = LocalDateTime.parse(fechaBD, formatter);
				String diaSemana = rs.getString("diaSemana");
				fechaBD =  rs.getString("fechaFinal");		
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaFinal = LocalDateTime.parse(fechaBD, formatter);
				listPases.add(new PasesDTO(Integer.parseInt(ident), fechaInicio, diaSemana,fechaFinal));
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listPases;
	}
	
	public FechasDTO requestFecha(int id)
	{
		FechasDTO fechaRequest = new FechasDTO();

		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataFechaAdmin");
			query=query.replaceAll("varid", Integer.toString(id));
			System.out.println(query);
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			
			String ident = rs.getString("id");
			String fechaDB = rs.getString("fechaFinal");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDateTime fecha = LocalDateTime.parse(fechaDB, formatter);
			
			fechaRequest.setID(Integer.parseInt(ident));
			fechaRequest.setFecha(fecha);
			
			if (stmt != null){ 
				stmt.close(); 
			}
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return fechaRequest;	
	}

	public PasesDTO requestPase(int id)
	{
		PasesDTO paseRequest = new PasesDTO();

		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataPases");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			String idf = rs.getString("id");
			String fecha = rs.getString("fechaInicio");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDateTime fechaInicio = LocalDateTime.parse(fecha, formatter);
			String diaSemana = rs.getString("diaSemana");
			fecha = rs.getString("fechaFinal");
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDateTime fechaFinal = LocalDateTime.parse(fecha, formatter);
			
			paseRequest.setID(Integer.parseInt(idf));
			paseRequest.setFechaInicio(fechaInicio);
			paseRequest.setDiaSemana(diaSemana);
			paseRequest.setFechaInicio(fechaFinal);

			if (stmt != null){ 
				stmt.close(); 
			}
			
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return paseRequest;	
	}

	
	public ArrayList<FechasDTO> requestFechasEsp(int id){
		ArrayList<FechasDTO> listFechas = new ArrayList<FechasDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectFechasEspMul");
			query = query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String ident = rs.getString("id");
				String fechaBD =  rs.getString("fecha");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fecha = LocalDateTime.parse(fechaBD, formatter);
				listFechas.add(new FechasDTO(Integer.parseInt(ident), fecha));
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listFechas;
	}
	
	public ArrayList<PasesDTO> requestPasesEsp(int id){
		ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectPasesEspTemp");
			query = query.replaceAll("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) 
			{
				String ident = rs.getString("id");
				String fechaBD =  rs.getString("fechaInicio");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaInicio = LocalDateTime.parse(fechaBD, formatter);
				String diaSemana = rs.getString("diaSemana");
				fechaBD =  rs.getString("fechaFinal");		
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDateTime fechaFinal = LocalDateTime.parse(fechaBD, formatter);
				listPases.add(new PasesDTO(Integer.parseInt(ident), fechaInicio, diaSemana,fechaFinal));
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listPases;
	}
}