package clases;

import java.time.LocalDateTime;

public class EspectaculoPunt extends Espectaculo {
	private LocalDateTime horaFecha;
	
	public EspectaculoPunt() {
		
	}
	
	public LocalDateTime getHoraFecha() {
		return this.horaFecha;
	}
	public void setHoraFecha(LocalDateTime horaFecha) {
		this.horaFecha = horaFecha;
	}
}