package business.DTOs;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoMultDTO extends EspectaculoDTO{
		private ArrayList<LocalDateTime> fechas;
		
		public EspectaculoMultDTO() {
			
		}	
		public EspectaculoMultDTO(int id, String titulo, String categoria,String descripcion, int localidades_vendida, ArrayList<LocalDateTime> fechasE) {
			super(id,titulo,categoria,descripcion); 
			this.fechas = fechasE; 
		}	
		public ArrayList<LocalDateTime> getFechas() {
			return this.fechas;
		}
		public void setFechas(ArrayList<LocalDateTime> fechas) {
			this.fechas = fechas;
		}
		
}
