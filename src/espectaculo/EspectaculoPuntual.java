package espectaculo;

import java.time.LocalDate;

public class EspectaculoPuntual extends AbstractEspectaculo {
	private LocalDate horaFecha;
	
	public EspectaculoPuntual() {
		
	}
	
	public LocalDate getHoraFecha() {
		return this.horaFecha;
	}
	public void setHoraFecha(LocalDate horaFecha) {
		this.horaFecha = horaFecha;
	}
}
