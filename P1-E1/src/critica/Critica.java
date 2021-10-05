//TODO: RELACIONAR USERNAME ESPECTADOR/CRITICA

package critica;

import fichero.criticas.IOCriticas;

/**
 * Clase que implementa una critica con sus variables 
 * privadas y metodos.
 * @author Antonio Lujano Luna
 *
 */
public class Critica extends IOCriticas{
/**
 * Enumeracion que contiene los valores posibles que puede tener
 * la variable puntuacion.
 * @author Antonio Lujano Luna
 *
 */
	public static enum puntuaciones{
		MuyBaja, Baja, Normal, Alta, muyAlta
	}
	
	/**
	 * Cadena para almacenar el titulo del espectaculo
	 */
	private String title; 
	/**
	 * Cadena que almacena la puntuacion. Solo puede tomar 
	 * los valores de la enumeracion puntuacion.
	 */
	private String puntuacion; 
	/**
	 * Cadena con la resena del espectaculo
	 */
	private String resena; 
	/**
	 * Int con el numero de likes que ha recibido la critica
	 */
	private int like; 
	/**
	 * Int con el numero de dislikes que ha recibido la critica
	 */
	private int dislike;
	/**
	 * Autor de la critica
	 */
	private String username; 
	
	/**
	 * Constructor parametrizado de la clase. Inicializamos los
	 * contadores de likes y dislikes a 0.
	 * @param title Titulo de la critica
	 * @param puntuacion Puntuacion dada
	 * @param resena Rese�a
	 */
	public Critica(String title, String puntuacion, String resena)
	{
		this.title = title; 
		this.puntuacion = puntuacion; 
		this.resena=resena; 
		this.like = 0; 
		this.dislike =0; 
	}
	
	/**
	 * Constructor sin parametros. Usado para inicializacion 
	 * de variables.
	 */
	public Critica() {
	}

	//GETTERS
	/**
	 * Getter del titulo.
	 * @return Titulo de la critica
	 */
	public String getTitle()
	{
		return this.title; 
	}
	/**
	 * Getter del username
	 * @return Usuario que escribio la critica
	 */
	public String getUsername() 
	{
		return this.username;
	}
	/**
	 * Getter de la puntuacion dada en la critica
	 * @return Puntuacion
	 */
	public String getPuntuacion()
	{
		return this.puntuacion; 
	}
	/**
	 * Getter del cuerpo de la critica
	 * @return La rese�a en si
	 */
	public String getResena()
	{
		return this.resena; 
	}
	/**
	 * Getter del numero de likes de la critica
	 * @return Numero de likes
	 */
	public int getLike()
	{
		return this.like; 
	}
	/**
	 * Getter del numero de dislikes de la critica
	 * @return Numero de dislikes
	 */
	public int getDislike()
	{
		return this.dislike; 
	}
	
	//SETTERS 
	/**
	 * Setter del titulo de la critica
	 * @param title Titulo de la critica
	 */
	public void settitle(String title)
	{
		this.title = title; 
	}
	/**
	 * Setter del username que escribe la critica
	 * @param username Ususario que escribe la critica
	 */
	public void setUsername(String username)
	{
		this.username=username;
	}
	/**
	 * Setter de la puntuacion. Comprueba que es un elemento
	 * de la enum puntuacion
	 * @param puntuacion Puntuacion del espectaculo
	 */
	public void setPuntuacion(String puntuacion)
	{
		if(Critica.contains(puntuacion)) {
			this.puntuacion=puntuacion; 
		}
	}
	/**
	 * Setter de la rese�a
	 * @param resena Cuerpo de la critica
	 */
	public void setResena(String resena)
	{
		this.resena=resena; 
	}
	/**
	 * Setter del numero de likes de la critica
	 * @param Like Numero de likes
	 */
	public void setLike(int Like)
	{
		this.like = Like; 
	}
	/**
	 * Setter del numero de dislikes de la critica
	 * @param Dislike Numero de dislikes
	 */
	public void setDislike(int Dislike)
	{
		this.dislike = Dislike; 
	}
	/**
	 * Metodo para incrementar en 1 el numero de likes
	 */
	public void addLike()
	{
		this.like ++; 
	}
	/**
	 * Metodo para decrementar en 1 el numero de dislikes
	 */
	public void addDislike()
	{
		this.dislike ++; 
	}
	/**
	 * Metodo para comprobar si una cadena esta presente
	 * en la enum puntuacion
	 * @param punt Puntuacion que se quiere dar
	 * @return true si la cadena esta permitida, false si no lo esta
	 */
	public static boolean contains(String punt) {
		for(puntuaciones p : puntuaciones.values()) {
			if(punt.equals(p.name()))
				return true;
		}
		return false;
	}
	
}
