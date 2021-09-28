//TODO: RELACIONAR USERNAME ESPECTADOR/CRITICA

package critica;

public class Critica{

	public enum puntuacion{
		MuyBaja, Baja, Normal, Alta, muyAlta
	}
	
	private String title; 
	private puntuacion puntuacion; 
	private String resena; 
	private int like; 
	private int dislike;
	private String username; 
	
	public Critica(String title, puntuacion puntuacion, String resena)
	{
		this.title = title; 
		this.puntuacion = puntuacion; 
		this.resena=resena; 
		this.like = 0; 
		this.dislike =0; 
	}
	
	//GETTERS
	public String getTitle()
	{
		return this.title; 
	}
	public String getUsername() 
	{
		return this.username;
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
	public void settitle(String title)
	{
		this.title = title; 
	}
	public void setUsername(String username)
	{
		this.username=username;
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
