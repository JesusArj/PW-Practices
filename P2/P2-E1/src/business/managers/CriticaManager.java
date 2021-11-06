package business.managers;

import java.util.ArrayList;
import business.DTOs.CriticaDTO;
import data.DAOs.CriticaDAO;
	

public class CriticaManager {
	private String mail;
	
	public CriticaManager(String mail) {
		this.mail = mail;
	}
	
	private String getMail() {
		return this.mail;
	}
	
	public void createCritica(String titulo, float puntuacion, String resena) {
		CriticaDAO newCritica = new CriticaDAO();
		//TODO funcion id;
		int id = 0;
		CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,id,this.getMail());  
		newCritica.createCritica(newCriticaDTO);
	}
	
	public Boolean updateCritica(String titulo, float puntuacion, String resena, String mail) {
		if(!this.getMail().equals(mail)) {
			CriticaDAO newCritica = new CriticaDAO();
			//TODO funcion id;
			int id = 0;
			CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,id,this.getMail());  
			newCritica.updateCritica(newCriticaDTO);
			return true;
			}
		return false;
		}
	
	public Boolean deleteCritica(int id) {
		if(!this.getMail().equals(mail)) {	
			CriticaDAO deleteCritica = new CriticaDAO();
			deleteCritica.deleteCritica(id);
			return true;
		}
		return false;
	}
	
	public CriticaDTO requestCritica(int id) {
		CriticaDAO requestCritica = new CriticaDAO();
		CriticaDTO requestedCritica = new CriticaDTO();
		requestedCritica = requestCritica.requestCritica(id);
		return requestedCritica;
	}
	
	public ArrayList<CriticaDTO> requestCriticas(){
		CriticaDAO requestCritica = new CriticaDAO();
		ArrayList<CriticaDTO> requestedCriticas = new ArrayList<CriticaDTO>();
		requestedCriticas = requestCritica.requestCriticas();
		return requestedCriticas;
	}
	
	public Boolean CriticaExist(String mail) {
		ArrayList<CriticaDTO> Criticas = this.requestCriticas();
		for(CriticaDTO u : Criticas) {
			if(u.getMail().equals(mail)) {
				return true;
			}
		}
		return false;	
	}
	
	
}
