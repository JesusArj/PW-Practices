package espectaculo;

import java.time.LocalDate;
import java.util.ArrayList;

public class EspectaculoTemporada extends AbstractEspectaculo{
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private ArrayList<LocalDate> fechas;
	
	public EspectaculoTemporada() {
		
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(LocalDate inicio) {
		this.fechaInicio = inicio;
	}
	public LocalDate getFechaFinal() {
		return this.fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFin) {
		this.fechaFinal = fechaFin;
	}
	public ArrayList<LocalDate> getFechas() {
		return this.fechas;
	}
	public void setPases(ArrayList<LocalDate> fechas) {
		this.fechas = fechas;
	}
}
