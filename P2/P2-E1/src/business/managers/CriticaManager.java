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
	
	public Boolean createCritica(String titulo, float puntuacion, String resena) {
		CriticaDAO newCritica = new CriticaDAO();
		//TODO funcion id;
		int id = 0;
		if(!this.CriticaExist(id)) {
			CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,id,this.getMail());  
			newCritica.createCritica(newCriticaDTO);	
			return true;
		}
		return false;
	}
	
	public Boolean updateCritica(String titulo, float puntuacion, String resena, String mail, int id) {
			if(this.CriticaExist(id)) {
				CriticaDTO critica = this.requestCritica(id);
				if(critica.getMail().equals(this.getMail())) {
					CriticaDAO newCritica = new CriticaDAO();			
					CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,id,this.getMail());  
					newCritica.updateCritica(newCriticaDTO);
				return true;		
			}
		}
		return false;
	}
	
	public Boolean deleteCritica(int id) {
		if(this.CriticaExist(id)) {
			CriticaDTO critica = this.requestCritica(id);
			if(critica.getMail().equals(this.getMail())) {
				CriticaDAO deleteCritica = new CriticaDAO();
				deleteCritica.deleteCritica(id);
				return true;				
			}
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
	
	public Boolean CriticaExist(int id) {
		ArrayList<CriticaDTO> Criticas = this.requestCriticas();
		for(CriticaDTO u : Criticas) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;	
	}
	
	
}
