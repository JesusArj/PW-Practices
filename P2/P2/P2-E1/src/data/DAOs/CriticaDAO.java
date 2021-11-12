package data.DAOs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import business.DTOs.CriticaDTO;
import business.DTOs.EspectaculoDTO;
import business.DTOs.VotantesCriticaDTO;
import data.common.DBConnection;

public class CriticaDAO {

	String ruta ="D:\\Descargas\\PW-Practices-master\\P2\\P2\\P2-E1\\src\\sql.properties";
	public String selectTituloEsp(int id) {
		String titulo = null;
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectTituloEsp");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			titulo = rs.getString("titulo");
			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return titulo;
	}
	
	private boolean existIdCritica(int id)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("existIDCriticas");
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
	
	public int generarIDCritica()
	{
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existIdCritica(id) == true)
		{
			generarIDCritica();
		}
		return id;
	}
	
	public void createCritica(CriticaDTO newCritica)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("createCritica");
			query=query.replaceAll("varid", Integer.toString(generarIDCritica()));
			query=query.replaceAll("vartitulo", newCritica.getTitle());
			query=query.replaceAll("varresena", newCritica.getResena()); 
			query=query.replaceAll("varmail", newCritica.getMail());
			query=query.replaceAll("varidesp", Integer.toString(newCritica.getIdEsp()));
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void addVotanteCritica(String mail, int id, String voto) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateVC");
			query=query.replaceAll("varmail", mail);
			query=query.replaceAll("varid", Integer.toString(id));
			query=query.replaceAll("varvoto", voto);
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void removeVotantesCritica(int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteVC");
			query=query.replaceAll("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public void removeVotanteCritica(String mail, int id) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteUSERVC");
			query=query.replaceAll("varmail", mail);
			query=query.replaceAll("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public ArrayList<VotantesCriticaDTO> requestVotantes(int id){
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		ArrayList<VotantesCriticaDTO> votantes = new ArrayList<VotantesCriticaDTO>();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataVC");
			query=query.replaceAll("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while(rs.next()) {
				VotantesCriticaDTO votCri = new VotantesCriticaDTO();
				String votante = rs.getString("mail");
				String voto = rs.getString("voto");
				votCri.setId(id);
				votCri.setVotante(votante);
				votCri.setVoto(voto);
				votantes.add(votCri);
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return votantes;
	}
	
	public void updateCritica(CriticaDTO updateCritica)
	{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("updateCritica");
			query=query.replaceAll("vartitulo", updateCritica.getTitle());
			query=query.replaceAll("varresena", updateCritica.getResena());
			query=query.replaceAll("varresena", updateCritica.getResena());
			query=query.replaceAll("varlike", Integer.toString(updateCritica.getLike()));
			query=query.replaceAll("vardislike", Integer.toString(updateCritica.getDislike()));
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
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("deleteCritica");
			query=query.replaceAll("varid", Integer.toString(id));
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			
			String query2 = prop.getProperty("deleteVC");
			query2=query2.replaceAll("varid", Integer.toString(id));
			Statement stmt2 = connection.createStatement();
			stmt2.executeQuery(query2);
			
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
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataCritica");
			query=query.replaceAll("varid", Integer.toString(id));
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			int iduser = Integer.parseInt(rs.getString("id"));
			float puntuacion = Float.parseFloat(rs.getString("puntuacion"));
			String titulo = rs.getString("titulo");
			String resena= rs.getString("resena");
			String mail = rs.getString("mail");
			int like = rs.getInt("vlike");
			int dislike =rs.getInt("dislike");
			ArrayList<VotantesCriticaDTO> votantes = this.requestVotantes(id);
			int idEsp = Integer.parseInt(rs.getString("idEsp")); 

			criticaRequest.setMail(mail);
			criticaRequest.setId(iduser);
			criticaRequest.settitle(titulo);
			criticaRequest.setResena(resena);
			criticaRequest.setPuntuacion(puntuacion); 
			criticaRequest.setLike(like);
			criticaRequest.setDislike(dislike);
			criticaRequest.setVotantes(votantes);
			criticaRequest.setIdEsp(idEsp);

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
		try(InputStream input = new FileInputStream(ruta)){
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
				int like = rs.getInt("vlike");
				int dislike = rs.getInt("dislike");
				ArrayList<VotantesCriticaDTO> votantes = this.requestVotantes(id);
				int idEsp = Integer.parseInt(rs.getString("idEsp"));
				
				CriticaDTO critic = new CriticaDTO(titulo,puntuacion,resena,id,mail,like,dislike, idEsp);
				critic.setVotantes(votantes);
				listCriticas.add(critic);
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

	public ArrayList<CriticaDTO> requestCriticasExUser(String mail){
		ArrayList<CriticaDTO> listCriticas = new ArrayList<CriticaDTO>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectAllCriticasPermit");
			query = query.replace("varmail", mail);
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				float puntuacion = rs.getFloat("puntuacion");
				String resena = rs.getString("resena");
				int id = rs.getInt("id");
				String mailW = rs.getString("mail");
				int like = rs.getInt("vlike");
				int dislike = rs.getInt("dislike");
				ArrayList<VotantesCriticaDTO> votantes = this.requestVotantes(id);
				int idEsp = Integer.parseInt(rs.getString("idEsp"));
				CriticaDTO critic = new CriticaDTO(titulo,puntuacion,resena,id,mailW,like,dislike, idEsp);
				critic.setVotantes(votantes);
				listCriticas.add(critic);
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

	public ArrayList<String> requestWriters(){
		ArrayList<String> listWriters = new ArrayList<String>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectWriters");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				String writer = rs.getString("mail");
				listWriters.add(writer);
			}
			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listWriters;
	}
	
	public ArrayList<EspectaculoDTO> requestEspPuntPast(){
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEspPuntPast");
			query = query.replace("varfechaactual", LocalDateTime.now().toString());
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String categoria = rs.getString("categoria");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				
				EspectaculoDTO espPunt = new EspectaculoDTO(id,titulo,categoria,descripcion);
				esp.add(espPunt);
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return esp;
	}

	public ArrayList<EspectaculoDTO> requestEspMultPast(){
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEspMultPast");
			query = query.replace("varfechaactual", LocalDateTime.now().toString());
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String categoria = rs.getString("categoria");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				
				EspectaculoDTO espMult = new EspectaculoDTO(id,titulo,categoria,descripcion);
				esp.add(espMult);
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return esp;
	}
	
	public ArrayList<EspectaculoDTO> requestEspTempPast(){
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try(InputStream input = new FileInputStream(ruta)){
			Properties prop = new Properties();
			prop.load(input);
			String query = prop.getProperty("selectDataEspTempPast");
			query = query.replace("varfechaactual", LocalDateTime.now().toString());
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String categoria = rs.getString("categoria");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				
				EspectaculoDTO espTemp = new EspectaculoDTO(id,titulo,categoria,descripcion);
				esp.add(espTemp);
			}

			if (stmt != null){ 
				stmt.close(); 
			}

			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		
		return esp;
	}

}
	
