//TODO: RELACIONAR USERNAME ESPECTADOR/CRITICA

package critica;

public class Critica{

	public enum puntuacion{
		MuyBaja, Baja, Normal, Alta, muyAlta
	}
	
	private String title; 
	private String puntuacion; 
	private String resena; 
	private int like; 
	private int dislike;
	private String username; 
	
	public Critica(String title, String puntuacion, String resena)
	{
		this.title = title; 
		this.puntuacion = puntuacion; 
		this.resena=resena; 
		this.like = 0; 
		this.dislike =0; 
	}
	
	public Critica() {
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
	public String getPuntuacion()
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
	public void setPuntuacion(String puntuacion)
	{
		this.puntuacion=puntuacion; 
	}
	public void setResena(String resena)
	{
		this.resena=resena; 
	}
	public void setLike(int Like)
	{
		this.like = Like; 
	}
	public void setDislike(int Dislike)
	{
		this.dislike = Dislike; 
	}
	public void addLike()
	{
		this.like ++; 
	}
	public void addDislike()
	{
		this.dislike ++; 
	}
	
}
