//TODO: RELACIONAR USERNAME ESPECTADOR/CRITICA

package critica;

import java.util.ArrayList;

import fichero.criticas.IOCriticas;

/**
 * Clase que implementa una critica con sus variables 
 * privadas y metodos.
 * @author Antonio Lujano Luna
 *
 */
public class Critica extends IOCriticas{
	
	/**
	 * Cadena para almacenar el titulo del espectaculo
	 */
	
	private String title; 
	
	/**
	 * Cadena que almacena la puntuacion. Solo puede tomar 
	 * los valores de la enumeracion puntuacion.
	 */
	
	private float puntuacion; 
	
	/*
	 *  Int con el valor del identificador unico de cada critica
	 */
	
	private int id;
	
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
	 * Email del autor de la critica
	 */
	
	private String mail; 
	
	/*
	 * Array List de cadenas de texto
	 */
	
	private ArrayList<String> votantes; 
	
	private IOCriticas ioc = new IOCriticas(); 
	
	/**
	 * Constructor parametrizado de la clase. Inicializamos los
	 * contadores de likes y dislikes a 0.
	 * @param title Titulo de la critica
	 * @param puntuacion Puntuacion dada
	 * @param resena Rese�a
	 */
	public Critica(String title, float puntuacion, String resena)
	{
		this.title = title; 
		this.puntuacion = puntuacion; 
		this.resena=resena; 
		this.like = 0; 
		this.dislike =0;
		this.id = ioc.generarID();  
		this.votantes= new ArrayList<String>(); 
	}
	
	/**
	 * Constructor sin parametros. Usado para inicializacion 
	 * de variables.
	 */
	
	public Critica() {}

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
	
	public String getMail() 
	{
		return this.mail;
	}
	
	/**
	 * Getter de la puntuacion dada en la critica
	 * @return Puntuacion
	 */
	
	public float getPuntuacion()
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
	
	/**
	 * Getter del identificador unico de la critica
	 * @return Identificador de la critica
	 */
	
	public int getId()
	{
		return this.id; 
	}
	
	/**
	 * Getter del Array List de emails de usuarios que puntuan una critica
	 * @return Emails almacenados en el Array List
	 */
	
	public ArrayList<String> getVotantes()
	{
		return this.votantes; 
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
	
	public void setMail(String mail)
	{
		this.mail=mail;
	}
	
	/**
	 * Setter de la puntuacion. Comprueba que es un elemento
	 * de la enum puntuacion
	 * @param puntuacion Puntuacion del espectaculo
	 */
	
	public void setPuntuacion(float puntuacion)
	{
			this.puntuacion=puntuacion; 
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
	 * Setter del identificador unico de la critica
	 * @param id Identificador de la critica
	 */
	
	public void setId(int id)
	{
		this.id=id; 
	}
	
	/**
	 * Setter del valor de cada posicion del Array list votantes
	 * @param votantes Array List de votantes
	 */
	
	public void setVotantes(ArrayList<String> votantes)
	{
		this.votantes = votantes; 
	}
	
	/**
	 * Metodo para comprobar si una cadena esta presente
	 * en la enum puntuacion
	 * @param punt Puntuacion que se quiere dar
	 * @return true si la cadena esta permitida, false si no lo esta
	 */
	/*
	public static boolean contains(String punt) {
		for(puntuaciones p : puntuaciones.values()) {
			if(punt.equals(p.name()))
				return true;
		}
		return false;
	}
	*/
}
