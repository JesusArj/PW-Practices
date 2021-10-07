package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import gestor.usuarios.GestorUsuarios;

public class MenuUsuario {

/**
 * La clase MenuCriticas comprende la impresion por pantalla de un menu,
 * que enlaza la interfaz de usuario con las funciones del gestor de
 * críticas.
 * @author Valentin Avram
 *
 */

	
/** 
* Menu que enlaza con las gestiones relacionadas
* a la gestion de usuarios
* @param usuario usuario que realiza la gestion.
* @author Developers
*
*/

	public void userMenu(String mail) 
	{

		String opc = null;
        GestorUsuarios newGestor = GestorUsuarios.getInstance(mail);
		
	    System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
	    System.out.println("Para ver los datos de su perfil, pulse 1.");
	    System.out.println("Para actualizar sus datos de usuario, pulse 2.");
	    System.out.println("Para dar de baja su usuario, pulse 3.");	    
	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	    
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opc = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if("1".equals(opc)) 
		{ // Opcion 1, el usuario visualiza sus datos. FUNCIONA BIEN
        	
        	newGestor.verDatosUser();
        }
        else if("2".equals(opc))
        { // Opcion 2, el usuario actualiza sus datos.
			
        	newGestor.updateUser();
        	
        }
        else if("3".equals(opc))
        { // Opciones 3, el usuario se da de baja.
        	newGestor.darBajaUser();
        	System.out.println("Ha sido dado de baja. Gracias por usar nuestro sistema.");
        	return;
        }
        else
        { 
        	System.out.println("Gracias por usar el menu");
        }

	}
}
