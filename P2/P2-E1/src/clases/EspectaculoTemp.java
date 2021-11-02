package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoTemp extends Espectaculo{
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFinal;
	private ArrayList<LocalDateTime> fechas;
	
	public EspectaculoTemp() {
		
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
