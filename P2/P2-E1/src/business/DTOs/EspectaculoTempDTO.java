package business.DTOs;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoTempDTO extends EspectaculoDTO{
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFinal;
	private ArrayList<LocalDateTime> fechas;
	
	public EspectaculoTempDTO() {
		
	}
	public EspectaculoTempDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fechaInicio,LocalDateTime fechaFinal,ArrayList<LocalDateTime> fechas ) 
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
	public ArrayList<LocalDateTime> getFechas() {
		return this.fechas;
	}
	public void setFechas(ArrayList<LocalDateTime> fechas) {
		this.fechas = fechas;
	}
}
