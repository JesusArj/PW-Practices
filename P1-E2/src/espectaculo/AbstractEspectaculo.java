package espectaculo;

import critica.Critica;

public class AbstractEspectaculo {
	protected String title;
	protected String descripcion;
	protected String categoria;
	protected int aforo;
	protected int localidadesVendidas;
	protected Critica critic;
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return this.descripcion;
	}
	public void setDesc(String desc) {
		this.descripcion = desc;
	}
	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getAforo() {
		return this.aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public int getLoc() {
		return this.localidadesVendidas;
	}
	public void setLoc(int loc) {
		this.localidadesVendidas = loc;
	}
	public void venderLoc() {
		this.localidadesVendidas++;
	}
	public Critica getCritica() {
		return this.critic;
	}
	public void setCritica(Critica c) {
		this.critic = c;
	}
	
}
