package business.DTOs;

import java.time.LocalDateTime;

public class EspectaculoPuntDTO extends EspectaculoDTO {
	private LocalDateTime horaFecha;
	
	public EspectaculoPuntDTO() {
		
	}
	
	public LocalDateTime getHoraFecha() {
		return this.horaFecha;
	}
	public void setHoraFecha(LocalDateTime horaFecha) {
		this.horaFecha = horaFecha;
	}
}