package business.managers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import business.DTOs.EspectaculoMultDTO;
import business.DTOs.EspectaculoPuntDTO;
import business.DTOs.EspectaculoTempDTO;
import business.DTOs.FechasDTO;
import business.DTOs.PasesDTO;
import data.DAOs.EspectaculoDAO;

public class EspectaculoManager
{
	

	public Boolean PuntExist(int id) {
		ArrayList<EspectaculoPuntDTO> Punt = this.requestEPs();
		for(EspectaculoPuntDTO u : Punt) {
			if(u.getID() == id) {
				return true;
			}
		}
		return false;	
	}
	
	public Boolean MultExist(int id) {
		ArrayList<EspectaculoMultDTO> Mult = this.requestEMs();
		for(EspectaculoMultDTO u : Mult) {
			if(u.getID() == id) {
				return true;
			}
		}
		return false;	
	}
	
	public Boolean TempExist(int id) {
		ArrayList<EspectaculoTempDTO> Criticas = this.requestETs();
		for(EspectaculoTempDTO u : Criticas) {
			if(u.getID() == id) 
			{
				return true;
			}
		}
		return false;	
	}
	
	public Boolean paseExist(int id) {
		ArrayList<PasesDTO> pases = this.requestPases();
		for(PasesDTO u : pases) {
			if(u.getID() == id) 
			{
				return true;
			}
		}
		return false;	
	}
	public Boolean fechaExist(int id) {
		ArrayList<FechasDTO> fechas = this.requestFechas();
		for(FechasDTO u : fechas) {
			if(u.getID() == id) 
			{
				return true;
			}
		}
		return false;	
	}
	
	public Boolean createEspectaculoPunt(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fecha) {
		EspectaculoDAO newPuntDAO = new EspectaculoDAO();
		if(!this.PuntExist(id)) 
		{
			EspectaculoPuntDTO newPuntDTO = new EspectaculoPuntDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, fecha);  
			newPuntDAO.createEspectaculoPuntual(newPuntDTO);	
			return true;
		}
		return false;
	}
	
	public Boolean updateEspectaculoPunt(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fecha) {
			if(this.PuntExist(id)) 
			{
				EspectaculoDAO newEspectaculo = new EspectaculoDAO();			
				EspectaculoPuntDTO newPuntDTO = new EspectaculoPuntDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, fecha);  
				newEspectaculo.updateEspectaculoPuntual(newPuntDTO);
				return true;		
		}
		return false;
	}
	
	public Boolean deleteEspectaculoPunt(int id) {
		if(this.PuntExist(id)) 
		{
			EspectaculoDAO deletePunt = new EspectaculoDAO();
			deletePunt.deleteEspectaculoPuntual(id);
			return true;				
		}	
		return false;
	}
	
	public EspectaculoPuntDTO requestEspectaculoPunt(int id) 
	{
		EspectaculoDAO requestPunt = new EspectaculoDAO();
		EspectaculoPuntDTO requestedPunt = new EspectaculoPuntDTO();
		requestedPunt = requestPunt.requestEspectaculoPuntual(id);
		return requestedPunt;
	}
	
	public ArrayList<EspectaculoPuntDTO> requestEPs()
	{
		EspectaculoDAO requestPunt = new EspectaculoDAO();
		ArrayList<EspectaculoPuntDTO> requestedPunt = new ArrayList<EspectaculoPuntDTO>();
		requestedPunt = requestPunt.requestEPs();
		return requestedPunt;
	}
	
	public Boolean createEspectaculoMult(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas, ArrayList<FechasDTO> fechas) {
		EspectaculoDAO newMultDAO = new EspectaculoDAO();
		if(!this.MultExist(id)) 
		{
			EspectaculoMultDTO newMultDTO = new EspectaculoMultDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, fechas);  
			newMultDAO.createEspectaculoMultiple(newMultDTO);	
			return true;
		}
		return false;
	}
	
	public Boolean updateEspectaculoMultiple(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,ArrayList<FechasDTO> fechas) {
			if(this.MultExist(id)) 
			{
				EspectaculoDAO newEspectaculo = new EspectaculoDAO();			
				EspectaculoMultDTO newMultDTO = new EspectaculoMultDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, fechas);  
				newEspectaculo.updateEspectaculoMultiple(newMultDTO);
				return true;		
		}
		return false;
	}
	
	public Boolean deleteEspectaculoMultiple(int id) {
		if(this.MultExist(id)) 
		{
			EspectaculoDAO deleteMult = new EspectaculoDAO();
			deleteMult.deleteEspectaculoMultiple(id);
			return true;				
		}	
		return false;
	}
	
	public EspectaculoMultDTO requestEspectaculoMultiple(int id) 
	{
		EspectaculoDAO requestMult = new EspectaculoDAO();
		EspectaculoMultDTO requestedMult = new EspectaculoMultDTO();
		requestedMult = requestMult.requestEspectaculoMultiple(id);
		return requestedMult;
	}
	
	public ArrayList<EspectaculoMultDTO> requestEMs()
	{
		EspectaculoDAO requestMult = new EspectaculoDAO();
		ArrayList<EspectaculoMultDTO> requestedMult = new ArrayList<EspectaculoMultDTO>();
		requestedMult = requestMult.requestEMs();
		return requestedMult;
	}

	public ArrayList<FechasDTO> requestFechas()
	{
		EspectaculoDAO requestFechas = new EspectaculoDAO();
		ArrayList<FechasDTO> requestedFechas = new ArrayList<FechasDTO>();
		requestedFechas = requestFechas.requestFechas();
		return requestedFechas;
	}
	
	public ArrayList<PasesDTO> requestPases()
	{
		EspectaculoDAO requestPases = new EspectaculoDAO();
		ArrayList<PasesDTO> requestedPases = new ArrayList<PasesDTO>();
		requestedPases = requestPases.requestPases();
		return requestedPases;
	}
	
	public Boolean createEspectaculoTemp(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas, ArrayList<PasesDTO> pases) {
		EspectaculoDAO newTempDAO = new EspectaculoDAO();
			EspectaculoTempDTO newTempDTO = new EspectaculoTempDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, pases);  
			newTempDAO.createEspectaculoTemporada(newTempDTO);	
			return true;
	}
	
	public Boolean updateEspectaculoTemp(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,ArrayList<PasesDTO> pases) {
			if(this.TempExist(id)) 
			{
				EspectaculoDAO newEspectaculo = new EspectaculoDAO();			
				EspectaculoTempDTO newTempDTO = new EspectaculoTempDTO(id, titulo, categoria, descripcion, localidades_venta, localidades_vendidas, pases);  
				newEspectaculo.updateEspectaculoTemporada(newTempDTO);
				return true;		
		}
		return false;
	}
	
	public Boolean deleteEspectaculoTemp(int id) {
		if(this.PuntExist(id)) 
		{
			EspectaculoDAO deleteTemp = new EspectaculoDAO();
			deleteTemp.deleteEspectaculoTemporada(id);
			return true;				
		}	
		return false;
	}
	
	public EspectaculoTempDTO requestEspectaculoTemporada(int id) 
	{
		EspectaculoDAO requestTemp = new EspectaculoDAO();
		EspectaculoTempDTO requestedTemp = new EspectaculoTempDTO();
		requestedTemp = requestTemp.requestEspectaculoTemporada(id);
		return requestedTemp;
	}
	
	public ArrayList<EspectaculoTempDTO> requestETs()
	{
		EspectaculoDAO requestTemp = new EspectaculoDAO();
		ArrayList<EspectaculoTempDTO> requestedTemp = new ArrayList<EspectaculoTempDTO>();
		requestedTemp = requestTemp.requestETs();
		return requestedTemp;
	}
	
	//TODO: No necesitarias un sesión terminada de Puntuales?
	
	public boolean sesionTerminadaMult(EspectaculoMultDTO espect)
	{
		for(int i=0; i<espect.getFechas().size(); i++)
		{
			if(espect.getFechas().get(i).getFecha().isBefore(LocalDateTime.now()))
			{
				return true; 
			}
		}
		return false; 
	}
	
	public boolean sesionTerminadaTemp(EspectaculoTempDTO espect)
	{
		for(int i=0; i<espect.getPases().size(); i++)
		{
			if(espect.getPases().get(i).getFechaInicio().isBefore(LocalDateTime.now()))
			{
				return true; 
			}
		}
		return false; 
	}
	
	public Boolean createFecha(int id, LocalDateTime fecha, int idE) 
	{
		EspectaculoDAO newPuntDAO = new EspectaculoDAO();
		if(!this.MultExist(idE)) 
		{
			FechasDTO newFecha = new FechasDTO(id, fecha);
			newPuntDAO.createFecha(newFecha, idE);
			return true;
		}
		return false;
	}
	
	public Boolean createPase(int id, LocalDateTime fechaInicio, String diaSemana, LocalDateTime fechaFinal, int idE) 
	{
		EspectaculoDAO newPuntDAO = new EspectaculoDAO();
		if(!this.TempExist(idE)) 
		{
			PasesDTO newPase = new PasesDTO(id, fechaInicio, diaSemana, fechaFinal);
			newPuntDAO.createPase(newPase, idE);
			return true;
		}
		return false;
	}

}
