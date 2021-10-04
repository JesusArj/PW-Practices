package espectador;
import fichero.users.IOUsers;

/**
 * Clase que implementa un espectador con sus variables privadas 
 * y metodos
 * @author Antonio Lujano Luna
 *
 */
public class Espectador extends IOUsers{

	/**
	 * Cadena que almacena el nombre del usuario
	 */
	private String name; 
	/**
	 * Cadena que almacena el mail del usuario
	 */
	private String mail;
	/**
	 * Cadena que almacena el username del usuario
	 */
	private String username; 
	
	/**
	 * Constructor sin parametros usado en inicializacion
	 * de variables
	 */
	public Espectador()
	{
	}
	/**
	 * Constructor parametrizado.
	 * @param name Nombre del usuario
	 * @param mail Mail del usuario
	 * @param username Username del usuario
	 */
	public Espectador(String name, String mail, String username)
	{
		this.name=name; 
		this.mail=mail;
		this.username = username;
		userToFich(this.name, this.mail, this.username); 
	}
	//OBSERVADORES
	/**
	 * Getter del nombre del usuario
	 * @return Cadena con el nombre del usuario
	 */
	public String getName()
	{
		return this.name; 
	}
	/**
	 * Getter del mail del usuario
	 * @return Cadena con el mail del usuario
	 */
	public String getMail()
	{
		return this.mail; 
	}
	/**
	 * Getter del username del usuario
	 * @return Cadena con el username del usuario
	 */
	public String getUsername()
	{
		return this.username; 
	}
	
	//MODIFICADORES
	/**
	 * Setter del nombre del usuario
	 * @param name Nombre del usuario
	 */
	public void setName(String name)
	{
		this.name = name; 
	}
	/**
	 * Setter del mail del usuario
	 * @param mail Mail del usuario
	 */
	public void setMail(String mail)
	{
		this.mail = mail; 
	}
	/**
	 * Setter del username del usuario
	 * @param username Username del usuario
	 */
	public void setUsername(String username)
	{
		this.username = username; 
	}	
}
