package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuEspectaculo {
	
	public void SpectacleMenu(String mail) 
	{
		String opc = null;
		//TODO: Que instancia creo, solo la Abstract Clase, una de cada, o al fabric (Abstract o el otro)?
		
		while(true)
		{
			System.out.println("Bienvenido al menu de Espectaculos");
 // La funcion de dar de baja debe tener dos modos, todas las sesiones, o una en particular

			System.out.println("Para ver los espectaculos registrados, pulse 1");
			System.out.println("Para consultar las localidades disponibles para un espectaculo concreto, pulse 2");
			System.out.println("Para buscar un espectaculo, por titulo o categoria, pulse 3");
			System.out.println("Para ver proximos espectaculos con entradas disponibles, pulse 4");
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
            	System.out.println("ESPECTACULOS REGISTRADOS:");
            	
            break;
            
            case "2":
            	System.out.println("LOCALIDADES DISPONIBLES");
            	//TODO
            break;
            
            case "3":
            	System.out.println("BUSQUEDA DE ESPECTACULOS");
            	//TODO
            break;
            
            case "4":
            	System.out.println("ESPECTACULOS CON LOCALIDADES DISPONIBLES");
            	//TODO: Crear funcion que compare las entradas vendidas con las totales
            break;
         
            
            default:
            System.out.println("Saliendo del menu . . . ");
            return;
            
            }
		}
	}	
}
