package espectador;

public class Espectador {

	private String name; 
	private String mail;
	private String username; 
	
	
	//OBSERVADORES
	
	public String getName()
	{
		return this.name; 
	}
	public String getMail()
	{
		return this.mail; 
	}
	public String getUsername()
	{
		return this.username; 
	}
	
	//MODIFICADORES
	public void setName(String name)
	{
		this.name = name; 
	}
	public void setMail(String mail)
	{
		this.mail = mail; 
	}
	public void setUsername(String username)
	{
		this.username = username; 
	}	
	
}
