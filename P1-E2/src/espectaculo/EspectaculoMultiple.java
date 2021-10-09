00package espectaculo;

import java.time.LocalDate;
import java.util.ArrayList;

public class EspectaculoMultiple extends AbstractEspectaculo {
	private ArrayList<LocalDate> pases;
	
	public EspectaculoMultiple() {
		
	}	
	public ArrayList<LocalDate> getPases() {
		return this.pases;
	}
	public void setPases(ArrayList<LocalDate> pases) {
		this.pases = pases;
	}
	
}
