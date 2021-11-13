package business.DTOs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EspectaculoPuntDTO extends EspectaculoDTO {
	private LocalDateTime horaFecha;
	
	public EspectaculoPuntDTO() {
		
	}
	
public EspectaculoPuntDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fecha) 
	{
		super(id, titulo, categoria,descripcion, localidades_venta, localidades_vendidas);
		this.horaFecha = fecha; 
	}
	
	public LocalDateTime getHoraFecha() {
		return this.horaFecha;
	}
	public String getHoraFechaString()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		String formattedDateTime = this.getHoraFecha().format(formatter);
		return formattedDateTime; 
	}
	public void setHoraFecha(LocalDateTime horaFecha) {
		this.horaFecha = horaFecha;
	}
}