package espectador;
import fichero.users.IOUsers;

public class Espectador extends IOUsers{

	private String name; 
	private String mail;
	private String username; 
	
	//Constructor parametrizado
	public Espectador(String name, String mail, String username)
	{
		this.name=name; 
		this.mail=mail;
		this.username = username;
		userToFich(this.name, this.mail, this.username); 
	}
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
