package credenciales;
/**
 * La clase credenciales comprende las variables privadas usuario y passwd
 * necesarias para ejecutar el sistema y para que funcione correctamente.
 * <p> Adem�s cuenta con dos constructores diferentes y los getters y 
 * setters correspondientes
 * @author Antonio Lujano Luna
 * 
 */
public class Credenciales {
	/**
	 * Cadena User para almacenar el usuario registrado
	 */
	private String User;
	
	/**
	 * Cadena password asociada al user, se almacena en texto plano
	 */
	private String Passwd;
	
	/**
	 * Constructor parametrizado
	 * @param User el usuario con el que queremos trabajar 
	 * @param Passwd la contrase�a del usuario
	 */
	public Credenciales(String User, String Passwd) {
		this.User = User;
		this.Passwd = Passwd;
	}
	
	/**
	 * Constructor sin par�metros. Usado para inicializar variables
	 * antes de contar con los datos con los que queremos inicializar.
	 */
	public Credenciales() {
	}
	
	/**
	 * Setter de la cadena del user
	 * @param User Username
	 */
	public void setUser(String User) {
		this.User = User;
	}
	
	/**
	 * Setter de la contrase�a
	 * @param Passwd Contrase�a del user
	 */
	public void setPasswd(String Passwd) {
		this.Passwd = Passwd;
	}
	
	/**
	 * Getter de la cadena del user
	 * @return Cadena que contiene el username
	 */
	public String getUser() {
		return this.User;
	}
	
	/**
	 * Getter de la contrase�a. Usado para hacer login. 
	 * No es seguro que sea public y la contrase�a 
	 * est� almacenada en texto plano.
	 * @return Cadena que contiene la contrase�a
	 */
	public String getPasswd() {
		return this.Passwd;
	}
}