package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase MenuEspectaculos comprende la impresion por pantalla de un menu,
 * que enlaza la interfaz de usuario con las funciones del gestor de
 * espectaculos.
 * @author developers
 *
 */

public class MenuEspectaculos {

	
	public void SpectacleMenu(String mail) 
	{
		String opc = null;
		//TODO: Que instancia creo, solo la Abstract Clase, una de cada, o al fabric (Abstract o el otro)?
		
		while(true)
		{
			System.out.println("Bienvenido al menu de Gestión de Espectaculos (Menu de Administrador)");
			System.out.println("Para dar de Alta un espectaculo, pulse 1");
			System.out.println("Para dar de baja de un espectaculo, pulse 2"); // La funcion de dar de baja debe tener dos modos, todas las sesiones, o una en particular
			System.out.println("Para actualizar la información sobre un espectaculo, pulse 3");
			System.out.println("Para contabilizar la venta de entradas para una sesión de un espectaculo, pulse 4");
			System.out.println("Para consultar las localidades disponibles para un espectaculo y fecha concretos, pulse 5");
			System.out.println("Para buscar un espectaculo, por titulo o categoria, pulse 6");
			System.out.println("Para ver proximos espectaculos con entradas disponibles, pulse 7.");
			System.out.println("Para salir del menu, pulse cualquier otra tecla");
						 
            BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
            try 
            {
    			opc = login.readLine();
    		} 
            catch (IOException e) 
            {
    			e.printStackTrace();
    		}
            
            switch(opc)
            {
            
            case "1":
            	System.out.println("INTRODUCCION DE ESPECTACULOS:");
            	//TODO
            break;
            
            case "2":
            	System.out.println("ELIMINACION DE ESPECTACULOS:");
            	//TODO
            break;
            
            case "3":
            	System.out.println("ACTUALIZACION DE ESPECTACULOS:");
            	//TODO
            break;
            
            case "4":
            	System.out.println("CONTABILIDAD DE ENTRADAS:");
            	//TODO
            break;
            
            case "5":
            	System.out.println("LOCALIDADES DISPONIBLES:");
            	//TODO
            break;
            
            case "6":
            	System.out.println("BUSQUEDA DE ESPECTACULOS");
            	//TODO
            break;
            
            case "7":
            	System.out.println("PROXIMOS ESPECTACULOS");
            	//TODO
            break;
            
            default:
            System.out.println("Saliendo del menu . . . ");
            return;
            
            }
		}
	}	

}
