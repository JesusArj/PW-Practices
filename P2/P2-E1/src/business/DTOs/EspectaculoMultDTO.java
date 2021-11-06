package business.DTOs;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoMultDTO extends EspectaculoDTO{
		private ArrayList<LocalDateTime> fechas;
		
		public EspectaculoMultDTO() {
			
		}	
		public ArrayList<LocalDateTime> getFechas() {
			return this.fechas;
		}
		public void setFechas(ArrayList<LocalDateTime> fechas) {
			this.fechas = fechas;
		}
		
}
