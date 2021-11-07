package business.managers;

import java.util.ArrayList;
import business.DTOs.CriticaDTO;
import business.DTOs.VotantesCriticaDTO;
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
				deleteCritica.removeVotantesCritica(id);
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
	
	public ArrayList<CriticaDTO> requestCriticasExUser(){
		CriticaDAO requestCritica = new CriticaDAO();
		ArrayList<CriticaDTO> requestedCriticas = new ArrayList<CriticaDTO>();
		requestedCriticas = requestCritica.requestCriticasExUser(this.getMail());
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
	
	public ArrayList<String> readCritica(int id){
		ArrayList<String> critica = new ArrayList<String>();
		return critica;
	}
	
	public Boolean darLike(int id) {
		if(this.CriticaExist(id)) {
			CriticaDTO critica = this.requestCritica(id);
			if(!this.getMail().equals(critica.getMail())) {
				for(VotantesCriticaDTO v : critica.getVotantes()) {
					if(v.getVotante().equals(this.getMail())) {
						if(v.getVoto().equals("like")) {
							return false;
						}
						else {
							critica.lessDislike();
							critica.addLike();
						}
					}
				}
				CriticaDAO Like = new CriticaDAO();
				Like.updateCritica(critica);
				Like.removeVotanteCritica(this.getMail(), id);
				Like.addVotanteCritica(this.getMail(), id, "like");
				return true;	
			}				
		}	
		return false;
	}
	
	public Boolean darDislike(int id) {
		if(this.CriticaExist(id)) {
			CriticaDTO critica = this.requestCritica(id);
			if(!this.getMail().equals(critica.getMail())) {
				for(VotantesCriticaDTO v : critica.getVotantes()) {
					if(v.getVotante().equals(this.getMail())) {
						if(v.getVoto().equals("dislike")) {
							return false;
						}
						else {
							critica.lessLike();
							critica.addDislike();
							
						}
					}
				}
				CriticaDAO Like = new CriticaDAO();
				Like.updateCritica(critica);
				Like.removeVotanteCritica(this.getMail(), id);
				Like.addVotanteCritica(this.getMail(), id, "dislike");
				return true;	
			}				
		}	
		return false;	
	}
	
	public ArrayList<String> requestWriters(){
		CriticaDAO requestW = new CriticaDAO();
		ArrayList<String> requestedWriters = new ArrayList<String>();
		requestedWriters = requestW.requestWriters();
		return requestedWriters;
	}
	
}
