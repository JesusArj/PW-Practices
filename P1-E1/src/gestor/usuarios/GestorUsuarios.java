package gestor.usuarios;
import espectador.Espectador;
import fichero.users.IOUsers;

/*
 *
 * Clase que implementa las funcionalidades relativas 
 * a la gestion de datos de los usuarios.
 * @author 
 *
 */


public class GestorUsuarios {

	// 1 - The singleton

	private static GestorUsuarios instance = null;
			
	private IOUsers User = new IOUsers();
	private String Mail;

/**
 * Constructor parametrizado de la clase.
 * @param mail Dirección del e-mail del usuario
 * @author Developers
 *
 */

	private GestorUsuarios(String Mail) 
	{
		//RELLENAMOS ESPECTADORES
		this.Mail = Mail; 
	}

	// 3 - Access point to the instance

	public static GestorUsuarios getInstance(String Mail)
	{
		if(instance == null) 
		{
			instance = new GestorUsuarios(Mail);
		}
		return instance;
	}

/**
 * Funcion que da de alta un usuario en el sistema
 * @param e1 Objeta de clase Espectador
 * @author Developers
 *
 */	
			
	public void darAltaUser(Espectador e1) 
	{
		if(instance!=null)
		{
			this.User.RegisterUserToFich(e1.getName(), e1.getUsername(), e1.getMail(), e1.getPasswd());
		}
	}

/**
 * Funcion que da de baja al propio usuario del sistema
 * @author Developers
 *
 */	

	public void darBajaUser() 
	{
		if(instance!=null)
		{
			this.User.borrarUser(this.Mail);
			System.exit(1);
		}
	}
			

/**
 * Funcion que muestra los datos del propio usuario
 * @author Developers
 *
 */	

	public void verDatosUser()
	{
		if(instance!=null)
		{
			User.imprimirDatosUser(this.Mail);
		}
	}
	
	/**
	 * Funcion que actualiza los datos del propio usuario
	 * @author Developers
	 *
	 */	
	
	public void updateUser() 
	{
		if(instance!=null)
		{
			User.updateUser(this.Mail);
		}	
	}

		
	}
