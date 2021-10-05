package credenciales;
/**
 * La clase credenciales comprende las variables privadas usuario y passwd
 * necesarias para ejecutar el sistema y para que funcione correctamente.
 * <p> Además cuenta con dos constructores diferentes y los getters y 
 * setters correspondientes
 * @author Antonio Lujano Luna
 * 
 */
public class Credenciales {
	/**
	 * Cadena User para almacenar el usuario registrado
	 */
	private String email;
	
	/**
	 * Cadena password asociada al user, se almacena en texto plano
	 */
	private String Passwd;
	
	/**
	 * Constructor parametrizado
	 * @param User el usuario con el que queremos trabajar 
	 * @param Passwd la contraseña del usuario
	 */
	public Credenciales(String email, String Passwd) {
		this.email= email;
		this.Passwd = Passwd;
	}
	
	/**
	 * Constructor sin parámetros. Usado para inicializar variables
	 * antes de contar con los datos con los que queremos inicializar.
	 */
	public Credenciales() {
	}
	
	/**
	 * Setter de la cadena del user
	 * @param User Username
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Setter de la contraseña
	 * @param Passwd Contraseña del user
	 */
	public void setPasswd(String Passwd) {
		this.Passwd = Passwd;
	}
	
	/**
	 * Getter de la cadena del user
	 * @return Cadena que contiene el username
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Getter de la contraseña. Usado para hacer login. 
	 * No es seguro que sea public y la contraseña 
	 * esté almacenada en texto plano.
	 * @return Cadena que contiene la contraseña
	 */
	public String getPasswd() {
		return this.Passwd;
	}
}
