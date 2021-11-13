package business.DTOs;
import java.util.ArrayList;

public class EspectaculoMultDTO extends EspectaculoDTO{
		private ArrayList<FechasDTO> fechas;
		
		public EspectaculoMultDTO() {
			
		}	
		public EspectaculoMultDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendida, ArrayList<FechasDTO> fechas) {
			super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendida); 
			this.fechas = fechas;
		}
		public EspectaculoMultDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas) 
		{
			super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
		}
		
		public ArrayList<FechasDTO> getFechas() {
			return this.fechas;
		}
		public void setFechas(ArrayList<FechasDTO> fechas) {
			this.fechas = fechas;
		}
		
}
