package business.managers;

import java.util.ArrayList;
import business.DTOs.CriticaDTO;
import business.DTOs.EspectaculoDTO;
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
	
	public ArrayList<EspectaculoDTO> requestEspCriticablesPunt(){
		ArrayList<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		CriticaDAO requestEsp = new CriticaDAO();
		espectaculos = requestEsp.requestEspPuntPast();
		return espectaculos;
	}
	
	public ArrayList<EspectaculoDTO> requestEspCriticablesMult(){
		ArrayList<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		CriticaDAO requestEsp = new CriticaDAO();
		espectaculos = requestEsp.requestEspMultPast();
		return espectaculos;
	}
	
	public ArrayList<EspectaculoDTO> requestEspCriticablesTemp(){
		ArrayList<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		CriticaDAO requestEsp = new CriticaDAO();
		espectaculos = requestEsp.requestEspTempPast();
		return espectaculos;
	}
	
	public Boolean createCritica(String titulo, float puntuacion, String resena,int idEsp) {
		CriticaDAO newCritica = new CriticaDAO();
		
			CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,this.getMail(), idEsp);  
			newCritica.createCritica(newCriticaDTO);	
		return true;
	}
	/*
	public Boolean updateCritica(String titulo, float puntuacion, String resena, String mail, int id, int idEsp) {
			if(this.CriticaExist(id)) {
				CriticaDTO critica = this.requestCritica(id);
				if(critica.getMail().equals(this.getMail())) {
					CriticaDAO newCritica = new CriticaDAO();			
					CriticaDTO newCriticaDTO = new CriticaDTO(titulo,puntuacion,resena,id,this.getMail(),idEsp);  
					newCritica.updateCritica(newCriticaDTO);
				return true;		
			}
		}
		return false;
	}
	*/
	
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
	public ArrayList<CriticaDTO> requestAllCriticasUser(String mail)
	{
		CriticaDAO requestCritica = new CriticaDAO();
		ArrayList<CriticaDTO> requestedCriticas = new ArrayList<CriticaDTO>();
		requestedCriticas = requestCritica.requestCriticasUser(mail); 
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
			CriticaDAO Like = new CriticaDAO();
			if(!this.getMail().equals(critica.getMail())) {
				for(VotantesCriticaDTO v : critica.getVotantes()) {
					if(v.getVotante().equals(this.getMail())) {
						if(v.getVoto().equals("like")) {
							return false;
						}
						else {
							critica.lessDislike();
							critica.addLike();
							Like.updateCritica(critica);
							Like.removeVotanteCritica(this.getMail(), id);
							Like.addVotanteCritica(this.getMail(), id, "like");
							return true;	
						}
					}
				}
				critica.addLike();
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
			CriticaDAO Like = new CriticaDAO();
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
							Like.updateCritica(critica);
							Like.removeVotanteCritica(this.getMail(), id);
							Like.addVotanteCritica(this.getMail(), id, "dislike");
							return true; 
							
						}
					}
				}
				Like.updateCritica(critica);
				Like.removeVotanteCritica(this.getMail(), id);
				Like.addVotanteCritica(this.getMail(), id, "dislike");
				return true;	
			}				
		}	
		return false;	
	}
	
	public String selectTituloEsp(int id) {
		CriticaDAO selectTituloEspectaculo = new CriticaDAO();
		String titulo = selectTituloEspectaculo.selectTituloEsp(id);
		return titulo;
	}
	
	public ArrayList<String> requestWriters(){
		CriticaDAO requestW = new CriticaDAO();
		ArrayList<String> requestedWriters = new ArrayList<String>();
		requestedWriters = requestW.requestWriters();
		return requestedWriters;
	}
	
}
