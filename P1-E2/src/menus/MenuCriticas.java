
package menus;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import critica.Critica;
import fichero.criticas.IOCriticas;
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
		Critica crit = new Critica();
        GestorCriticas newGestor = GestorCriticas.getInstance(mail);
        IOCriticas newIOCriticas = new IOCriticas();
        	while(true) {
        		System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
        	    System.out.println("Para crear una critica, pulse 1.");
        	    System.out.println("Para consultar criticas, pulse 2");
        	    System.out.println("Para borrar una critica, pulse 3.");
        	    System.out.println("Para votar positivamente una critica, pulse 4.");
        	    System.out.println("Para votar negativamente, pulse 5.");
        	    System.out.println("Para buscar sus criticas, pulse 6.");
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
                		//TODO: Todo OK. Escribe mal
                        Scanner teclado1 = new Scanner(System.in);              
                        
                       ArrayList<String> votantes = new ArrayList<String>();
                        
                		System.out.println("CREACION DE CRITICAS");
                		System.out.println("Introduzca el nombre del espectaculo.");
                		
                		String title;
                        title = teclado1.nextLine();
                        crit.settitle(title);
                        
                		System.out.println("Puntua el espectaculo del 1 al 10:");
                		System.out.println("(Ejemplo: 6.5)");
                		
                		float puntuacion;     
                        puntuacion = Float.parseFloat(teclado1.nextLine()); 
                        crit.setPuntuacion(puntuacion);       		
                		System.out.println("Escriba su resena");
                		
                		String resena;             
                        resena = teclado1.nextLine();
                        crit.setId(newIOCriticas.generarID()); 
                        crit.setResena(resena);
                        crit.setMail(mail);
                        crit.setVotantes(votantes);
                		newGestor.crearCritica(crit);
                		break;
                	
                	case "2":
                		
                		newGestor.consultarCriticas();
                		break;
                		                	
                	case "3":
                		//TODO:
                		
                		Scanner teclado3 = new Scanner(System.in);  
                		String titulo = null;
                		
                		System.out.println("ELIMINACI�N DE CRITICAS");
                		newGestor.consultarCriticas();
                		
                		System.out.println("Introduzca el titulo de la critica que desea borrar");
                       
                        titulo = teclado3.nextLine();
                        
                		newIOCriticas.buscarCritica(mail, titulo);
                		break;
                		
                	case "4":
                		//TODO:
                		int id1 = 0;
                		
                		System.out.println("Se mostraran por pantalla las diferentes criticas para que selecciona el ID de la critica que desea puntuar");
                		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            			try {
            				id1 = Integer.parseInt(reader1.readLine());
            			} catch (IOException e) {
            				e.printStackTrace();
            			}
                		newGestor.consultarCriticas();
                		System.out.println("Indique el ID de la critica que desea puntuar");
                		//System.out.println(id);
                		newGestor.votarCriticasPos(id1);
                		break;
                	
                	case "5":
                		//TODO:
                		int id2 = 0;
                		
                		System.out.println("Se mostraran por pantalla las diferentes criticas para que selecciona el ID de la critica que desea puntuar");
                		BufferedReader reader2 = new BufferedReader(
            		            new InputStreamReader(System.in));
            			try {
            				id2 = Integer.parseInt(reader2.readLine());
            			} catch (IOException e) {
            				e.printStackTrace();
            			}
                		newGestor.consultarCriticas();
                		System.out.println("Indique el ID de la critica que desea puntuar");
                		//System.out.println(id);
                		newGestor.votarCriticasNeg(id2);
                		break;

                	case "6":
                		//TODO:
                		newGestor.buscarCriticas(mail);
                		break;
                	
                	default:
                		System.out.println("Gracias por usar este menu");
                		return;
                
                }
        	}
	}
}
