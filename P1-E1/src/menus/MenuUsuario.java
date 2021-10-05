package menus;
/**
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gestor.usuarios.GestorUsuarios;

public class MenuUsuario {

/**
 * La clase MenuCriticas comprende la impresion por pantalla de un menu,
 * que enlaza la interfaz de usuario con las funciones del gestor de
 * críticas.
 * @author Valentín Avram
 *
 */
/**
	//Pasarle por args el usuario ¿Debería ser segun mail?
	public static void userMenu(String usuario) 
	{

	/**
	 * Setter de la cadena del user
	 * @param usuario usuario que realiza la gestion.
	*/
	/**
		String opc = null;
	    System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
	    System.out.println("Para actualizar los datos de su perfil, pulse 1. Para dar de baja su usuario, pulse 2.");
	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	    
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opc = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        GestorUsuarios gestor = new GestorUsuarios(usuario);
        
        if("1".equals(opc)) 
		{ // Opcion 1, el usuario actualiza sus datos.
        	gestor.updateUser(usuario);
        }
        else if("2".equals(opc))
        { // Opcion 2, el usuario se da de baja.
        	gestor.darBajaUser(usuario);
        }
        else
        { 
        	System.out.println("Gracias por usar el menu");
        }

	}
}
*/