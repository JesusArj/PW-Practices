package business.DTOs;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoMultDTO extends EspectaculoDTO{
		private ArrayList<LocalDateTime> pases;
		
		public EspectaculoMultDTO() {
			
		}	
		public ArrayList<LocalDateTime> getPases() {
			return this.pases;
		}
		public void setPases(ArrayList<LocalDateTime> pases) {
			this.pases = pases;
		}
		
}
