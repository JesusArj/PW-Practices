package business.managers;

import java.util.ArrayList;
import business.DTOs.CriticaDTO;
import data.DAOs.CriticaDAO;
	

public class CriticaManager {

	
	public void createCritica(String titulo, float puntuacion, String resena) {
		CriticaDAO newCritica = new CriticaDAO();
		CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena);  
		newCritica.createCritica(newCriticaDTO);
	}
	
	public void updateCritica(String titulo, float puntuacion, String resena) {
		CriticaDAO newCritica = new CriticaDAO();
		CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena);  
		newCritica.updateCritica(newCriticaDTO);
	}
	
	public void deleteCritica(int id) {
		CriticaDAO deleteCritica = new CriticaDAO();
		deleteCritica.deleteCritica(id);
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
