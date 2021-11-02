package clases;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoMult extends Espectaculo{
		private ArrayList<LocalDateTime> pases;
		
		public EspectaculoMult() {
			
		}	
		public ArrayList<LocalDateTime> getPases() {
			return this.pases;
		}
		public void setPases(ArrayList<LocalDateTime> pases) {
			this.pases = pases;
		}
		
}
