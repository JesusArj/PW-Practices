package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import gestor.criticas.GestorCriticas;

/**
 * La clase MenuCriticas comprende la impresion por pantalla de un menu,
 * que enlaza la interfaz de usuario con las funciones del gestor de
 * críticas.
 * @author Valentín Avram
 *
 */

public class MenuCriticas {

	//TODO: Esperar a que este hecho el gestor de Criticas y completar restor de opciones.
	//Pasarle por args el usuario ¿Debería ser segun mail?
	public static void reviewMenu(String usuario) 
	{
		String opc = null;
	    System.out.println("Bienvenido a nuestro Menu de gestion de Criticas.");
	    System.out.println("Para actualizar los datos de su perfil, pulse 1. Para dar de baja su usuario, pulse 2.");
	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	    
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opc = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        GestorCriticas gestor = new GestorCriticas(usuario);
        
        if("1".equals(opc)) {
        	gestor.(usuario);
        }
        else if("2".equals(opc))
        {
        	gestor.(usuario);
        }
        else
        {
        	System.out.println("Gracias por usar el menu");
        }

	}
}