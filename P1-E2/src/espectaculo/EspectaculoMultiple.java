package espectaculo;

import java.util.ArrayList;

public class EspectaculoMultiple extends AbstractEspectaculo {
	private ArrayList<Pair> pases;
	
	public EspectaculoMultiple() {
		
	}	
	public ArrayList<Pair> getPases() {
		return this.pases;
	}
	public void setPases(ArrayList<Pair> pases) {
		this.pases = pases;
	}
	
}
