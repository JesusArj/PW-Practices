package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import critica.Critica;
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

/** 
* Menu que enlaza con las gestiones relacionadas
* a la gestión de críticas
* @param usuario usuario que realiza la gestion.
*
*/


	public void reviewMenu(String mail) 
	{

		String opc = null;
		Critica c = new Critica();
        GestorCriticas newGestor = GestorCriticas.getInstance(mail);
        
	    System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
	    System.out.println("Para crear una critica, pulse 1. Para consultar criticas, pulse 2.");
	    System.out.println("Para borrar una critica, pulse 3.");
	    System.out.println("Para votar positivamente una critica, pulse 4. Para votar negativamente, pulse 5.");
	    System.out.println("Para buscar una critica, pulse 6.");
	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	    
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opc = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        switch(opc)
        {
        	case "1":
        		//TODO: menu crear critica
        		newGestor.crearCritica(c);
        		break;
        	
        	case "2":
        		//TODO: 
        		newGestor.consultarCriticas();
        		break;
        	
        	case "3":
        		//TODO:
        		newGestor.BorrarCritica(c);
        		break;
        		
        	case "4":
        		//TODO:
        		newGestor.votarCriticasPos(c);
        		break;
        	
        	case "5":
        		//TODO:
        		newGestor.votarCriticasNeg(c);
        		break;

        	case "6":
        		//TODO:
        		newGestor.buscarCriticas(mail);
        		break;
        	
        	default:
        		System.out.println("Gracias por usar este menu");
        
        }
        
	}
}
