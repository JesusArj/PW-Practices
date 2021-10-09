package menus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import espectaculo.EspectaculoMultiple;
import espectaculo.EspectaculoPuntual;
import espectaculo.EspectaculoTemporada;
import gestor.espectaculos.GestorEspectaculo;

public class MenuEspectaculo {
	
	public void SpectacleMenu(String mail) 
	{
		String opc = null;
        GestorEspectaculo newGestor = GestorEspectaculo.getInstance(mail);

		while(true)
		{
			System.out.println("Bienvenido al menu de Espectaculos");

			System.out.println("Para ver los espectaculos registrados, pulse 1");
			System.out.println("Para ver los espectaculos con entradas disponibles, pulse 2");
			System.out.println("Para buscar un espectaculo por categoria, pulse 3");
			System.out.println("Para ver la informacion de un espectaculo concreto, pulse 4");
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
        		String rutaAbsoluta = new File("").getAbsolutePath();
        		String rutaFichero = rutaAbsoluta + "/criticas.txt";
        		
        		FileReader fr = null;
        		BufferedReader br = null;
        		try
        		{
        	        fr = new FileReader (rutaFichero);
        	        br = new BufferedReader(fr);	
        	        newGestor.consultarEspectaculosPunt();
        	        newGestor.consultarEspectaculosMult();
        	        newGestor.consultarEspectaculosTemp();

            		if (( br.readLine()) == null) 
            		{
            			System.out.println("No hay ningun espectaculo registrada en el sistema !");
            			System.out.println("");
            		}
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
        		finally
        		{
        			try
        			{                    
        				if( null != fr )
        				{   
        					fr.close();     
        				}                  
        			}
        			catch (Exception e2)
        			{ 
        				e2.printStackTrace();
        			}
        		}
            	
            break;
            
            case "2":
            	System.out.println("ESPECTACULOS CON LOCALIDADES DISPONIBLES:");
            	//TODO:
            	newGestor.localidadesDisponiblesPunt();
            	newGestor.localidadesDisponiblesMult();
            	newGestor.localidadesDisponiblesTemp();
            break;
            
            case "3":
            	System.out.println("BUSQUEDA DE ESPECTACULOS POR CATEGORIA:");
                Scanner teclado1 = new Scanner(System.in);              
                System.out.println("Indique que categoria de espectaculos desea buscar:");
                String category = teclado1.nextLine();
                
                newGestor.buscarCategoriaPunt(category);
                newGestor.buscarCategoriaMult(category);
                newGestor.buscarCategoriaTemp(category);
            	//TODO
            break;
            
            case "4":
            	System.out.println("ESPECTACULO ESPECIFICO:");
                Scanner teclado2 = new Scanner(System.in);              
                System.out.println("Indique el titulo del espectaculo concreto que desea ver:");
                String title = teclado2.nextLine();
                
                newGestor.buscarEspectaculosPunt(title);
                newGestor.buscarEspectaculosMult(title);
                newGestor.buscarEspectaculosTemp(title);
            	//TODO: 
            break;
         
            
            default:
            System.out.println("Saliendo del menu . . . ");
            return;
            
            }
		}
	}	
}
