//TODO: RELACIONAR USERNAME ESPECTADOR/CRITICA

package critica;

public class Critica{

	public enum puntuacion{
		MuyBaja, Baja, Normal, Alta, muyAlta
	}
	
	private String tittle; 
	private puntuacion puntuacion; 
	private String resena; 
	private int like; 
	private int dislike;
	private String username; 
	
	public Critica(String tittle, puntuacion puntuacion, String resena)
	{
		this.tittle = tittle; 
		this.puntuacion = puntuacion; 
		this.resena=resena; 
		this.like = 0; 
		this.dislike =0; 
	}
	
	//GETTERS
	public String getTittle()
	{
		return this.tittle; 
	}
	public puntuacion getPuntuacion()
	{
		return this.puntuacion; 
	}
	public String getResena()
	{
		return this.resena; 
	}
	public int getLike()
	{
		return this.like; 
	}
	
	public int getDislike()
	{
		return this.dislike; 
	}
	
	//SETTERS 
	public void setTittle(String tittle)
	{
		this.tittle = tittle; 
	}
	public void setPuntuacion(puntuacion puntuacion)
	{
		this.puntuacion=puntuacion; 
	}
	public void setResena(String resena)
	{
		this.resena=resena; 
	}
	public void setLike()
	{
		this.like ++; 
	}
	public void voidsetDislike()
	{
		this.dislike ++; 
	}
	
}
