package business.DTOs;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoTempDTO extends EspectaculoDTO{
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFinal;
	private ArrayList<PasesDTO> fechas;
	
	public EspectaculoTempDTO() {
		
	}
	public EspectaculoTempDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fechaInicio,LocalDateTime fechaFinal,ArrayList<PasesDTO> fechas ) 
	{
		super(id,titulo,categoria,descripcion); 
		this.fechaInicio = fechaInicio; 
		this.fechaFinal = fechaFinal; 
		this.fechas = fechas; 
	}
	
	public LocalDateTime getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(LocalDateTime inicio) {
		this.fechaInicio = inicio;
	}
	public LocalDateTime getFechaFinal() {
		return this.fechaFinal;
	}
	public void setFechaFinal(LocalDateTime fechaFin) {
		this.fechaFinal = fechaFin;
	}
	public ArrayList<PasesDTO> getFechas() {
		return this.fechas;
	}
	public void setFechas(ArrayList<PasesDTO> fechas) {
		this.fechas = fechas;
	}
}
