package business.DTOs;
import java.util.ArrayList;

public class EspectaculoMultDTO extends EspectaculoDTO{
		private ArrayList<FechasDTO> fechas;
		
		public EspectaculoMultDTO() {
			
		}	
		public EspectaculoMultDTO(int id, String titulo, String categoria,String descripcion, int localidades_vendida, ArrayList<FechasDTO> fechasE) {
			super(id,titulo,categoria,descripcion); 
			this.fechas = fechasE; 
		}	
		public ArrayList<FechasDTO> getFechas() {
			return this.fechas;
		}
		public void setFechas(ArrayList<FechasDTO> fechas) {
			this.fechas = fechas;
		}
		
}
