package espectaculo;

import java.util.ArrayList;

public class EspectaculoTemporada extends AbstractEspectaculo{
	private Pair fechaInicio;
	private Pair fechaFinal;
	private ArrayList<Pair> fechas;
	
	public EspectaculoTemporada() {
		
	}
	
	public Pair getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(Pair inicio) {
		this.fechaInicio = inicio;
	}
	public Pair getFechaFinal() {
		return this.fechaFinal;
	}
	public void setFechaFinal(Pair fechaFin) {
		this.fechaFinal = fechaFin;
	}
	public ArrayList<Pair> getFechas() {
		return this.fechas;
	}
	public void setPases(ArrayList<Pair> fechas) {
		this.fechas = fechas;
	}
}
