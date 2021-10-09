package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import espectaculo.EspectaculoMultiple;
import espectaculo.EspectaculoPuntual;
import espectaculo.EspectaculoTemporada;
import fichero.criticas.IOCriticas;
import fichero.espectaculos.IOEspectaculos;
import gestor.criticas.GestorCriticas;
import gestor.espectaculos.GestorEspectaculo;

/**
 * La clase MenuEspectaculos comprende la impresion por pantalla de un menu,
 * que enlaza la interfaz de usuario con las funciones del gestor de
 * espectaculos.
 * @author developers
 *
 */

public class MenuAdmin {

	
	public void AdminMenu(String mail) 
	{
		String opc = null;
        GestorEspectaculo newGestor = GestorEspectaculo.getInstance(mail);
        IOEspectaculos newIOCEspectaculos = new IOEspectaculos();
        EspectaculoPuntual ep = new EspectaculoPuntual();
        EspectaculoMultiple em = new EspectaculoMultiple();
        EspectaculoTemporada et = new EspectaculoTemporada();
		//TODO: Que instancia creo, solo la Abstract Clase, una de cada, o al fabric (Abstract o el otro)?
		
		while(true)
		{
			System.out.println("MENU DE ADMINISTRADOR: Gestion de Espectaculos");
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
            	
            	Scanner teclado1 = new Scanner(System.in); 
            	int opc1 = 0;
            	
            	System.out.println("INTRODUCCION DE ESPECTACULOS:");
            	System.out.println("Seleccione que tipo de Espectaculo va a introducir en el Sistema :");
            	System.out.println("1. Espectaculo Puntual");
            	System.out.println("2. Espectaculo Multiple");
            	System.out.println("3. Espectaculo Temporada");
            	
            	opc1 = Integer.parseInt(teclado1.nextLine());
            	
            	switch(opc1)
            	{
            	case 1:
            		System.out.println("Introduzca el nombre del espectaculo:");
            		String title = teclado1.nextLine();
            		ep.setTitulo(title);
            		
            		//CATEGORIA,DESCRIPCION,LOCALIDADES, VENTA, HORAFECHA, CRITICAS
            		System.out.println("Introduzca la categoria del espectaculo:");
            		String category = teclado1.nextLine();
            		ep.setCategoria(category);
            		
            		System.out.println("Introduca la descripcion del espectaculo:");
            		String descripcion = teclado1.nextLine();
            		ep.setDescripcion(descripcion);
            		
            		System.out.println("Introduca el numero de localidades disponibles para el espectaculo:");
            		int totalloc = Integer.parseInt(teclado1.nextLine());
            		ep.setLocalidadesVenta(opc1);
            		
            		System.out.println("Introduzca el numero de localidades ya vendidas");
            		int soldloc = Integer.parseInt(teclado1.nextLine());
            		ep.setLocalidadesVendidas(soldloc);
            		
            		System.out.println("Introduzca la fecha y hora del espectaculo");
            		System.out.println("Formato de fecha : 2016-03-04 11:30:\");
            		String datetime = "2016-03-04 11:30";
            		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            		LocalDateTime dateTime = LocalDateTime.parse(datetime, formatter);
            		ep.setHoraFecha(dateTime);
            		
            		newGestor.CrearEspectaculoPunt(ep);
            		break;
            	}
            	
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
