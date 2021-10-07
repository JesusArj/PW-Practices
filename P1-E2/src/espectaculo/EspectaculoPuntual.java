package espectaculo;

public class EspectaculoPuntual extends AbstractEspectaculo {
	private Pair horaFecha;
	
	public EspectaculoPuntual() {
		
	}
	
	public Pair getHoraFecha() {
		return this.horaFecha;
	}
	public void setHoraFecha(Pair horaFecha) {
		this.horaFecha = horaFecha;
	}
}
