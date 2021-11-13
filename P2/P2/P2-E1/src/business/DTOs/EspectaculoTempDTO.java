package business.DTOs;

import java.util.ArrayList;

public class EspectaculoTempDTO extends EspectaculoDTO{
	private ArrayList<PasesDTO> pases;
	
	public EspectaculoTempDTO() {
		
	}
	public EspectaculoTempDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,ArrayList<PasesDTO> pases ) 
	{
		super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
		this.pases = pases; 
	}
	public EspectaculoTempDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas) 
	{
		super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
	}
	
	
	/*public LocalDateTime getFechaInicio() {
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
	}*/
	public ArrayList<PasesDTO> getPases() {
		return this.pases;
	}
	public void setPases(ArrayList<PasesDTO> listPases) {
		this.pases = listPases;
	}
}
