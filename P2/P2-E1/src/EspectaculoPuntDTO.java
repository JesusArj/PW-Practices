package business.DTOs;

import java.time.LocalDateTime;

public class EspectaculoPuntDTO extends EspectaculoDTO {
	private LocalDateTime horaFecha;
	
	public EspectaculoPuntDTO() {
		
	}
	
public EspectaculoPuntDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fecha) 
	{
		super(id, titulo, categoria,descripcion);
		this.horaFecha = fecha; 
	}
	
	public LocalDateTime getHoraFecha() {
		return this.horaFecha;
	}
	public void setHoraFecha(LocalDateTime horaFecha) {
		this.horaFecha = horaFecha;
	}
}