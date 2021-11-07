package display.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import business.DTOs.CriticaDTO;
import business.managers.CriticaManager;

public class CriticasView {
	private String mail;
	
	private String getMail() {
		return mail;
	}
	
	public CriticasView(String mail) {
		this.mail = mail;
	}
	
	public void CriticaMenu() 
	{
		String opc = "1";
		while(opc.equals("1") || opc.equals("2") || opc.equals("3") || opc.equals("4") || opc.equals("5") || opc.equals("6") || opc.equals("7")) {
			System.out.println("Para crear una critica, pulse 1.");
    	    System.out.println("Para consultar criticas, pulse 2");
    	    System.out.println("Para borrar una critica, pulse 3.");
    	    System.out.println("Para votar positivamente una critica, pulse 4.");
    	    System.out.println("Para votar negativamente, pulse 5.");
    	    System.out.println("Para buscar sus criticas, pulse 6.");
    	    System.out.println("Para ver las criticas de un usuario concreto, pulse 7.");
    	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	        BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
	        try 
	        {
				opc = login.readLine();
			} 
	        catch (IOException e) 
	        {
				e.printStackTrace();
			}
	        
	        if("1".equals(opc)) 
			{ 
	        	System.out.println("CREAR CRITICA");
	        	String titulo = null;
	        	Scanner titulo_scan = new Scanner(System.in);
	        	float puntuacion = 0;
	        	Scanner puntuacion_scan = new Scanner(System.in);
	        	String resena = null;
	        	Scanner resena_scan = new Scanner(System.in);
	        
	        	System.out.println("Introduzca el titulo del espectaculo");
	        	titulo = titulo_scan.nextLine();	
	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	        	puntuacion = Float.parseFloat(puntuacion_scan.nextLine());
	        	System.out.println("Escriba la resena del mismo");
	        	resena = resena_scan.nextLine();

	        	CriticaManager managerCriticaCreate = new CriticaManager(this.getMail());
	        	managerCriticaCreate.createCritica(titulo, puntuacion , resena);
	        	titulo_scan.close();
	        	puntuacion_scan.close();
	        	resena_scan.close();    	
	        }
	        else if("2".equals(opc))
	        { 
	        	System.out.println("CONSULTAR TODAS LAS CRITICAS");
	        	CriticaManager managerCriticaReadAll = new CriticaManager(this.getMail());
	        	ArrayList<CriticaDTO> criticas = managerCriticaReadAll.requestCriticas();
	        	for(CriticaDTO c : criticas) {
	        		System.out.println("------------------------------------------------");
	        		System.out.println("Titulo : " + c.getTitle());
		        	System.out.println("	Autor : " + c.getMail());
		        	System.out.println("	Puntuacion : " + c.getPuntuacion());
		        	System.out.println("	Resena : " + c.getResena());
		        	System.out.println("	Likes : " + c.getLike());
		        	System.out.println("	Dislikes : " + c.getDislike());
	        		System.out.println("------------------------------------------------");
	        	}
	        }
	        else if("3".equals(opc))
	        {
		        	System.out.println("ELMINACION DE CRITICA");
		        	System.out.println("Estas son todas sus criticas");
		        	CriticaManager managerCriticaMostrarDelUser = new CriticaManager(this.getMail());
	        		ArrayList<CriticaDTO> criticasUser = managerCriticaMostrarDelUser.requestCriticas();
	        		int cont = 1;
	        		for(CriticaDTO c : criticasUser) {
	        			if(c.getMail().equals(this.getMail())) {
	        				System.out.println("------------------------------------------------");
	    	        		System.out.println(cont + " Titulo : " + c.getTitle());
	    		        	System.out.println("	Puntuacion : " + c.getPuntuacion());
	    		        	System.out.println("	Resena : " + c.getResena());
	    		        	System.out.println("	Likes : " + c.getLike());
	    		        	System.out.println("	Dislikes : " + c.getDislike());
	    	        		System.out.println("------------------------------------------------");
	    	        		cont++;
	        			}
	        		}
	        		System.out.println("Introduzca el numero de la critica que desea borrar");
	        		Scanner deleteCritica_scan = new Scanner(System.in);
		        	String delete = deleteCritica_scan.nextLine();
		        	if(Integer.parseInt(delete) > 0 && Integer.parseInt(delete) < cont ) {
		        		System.out.println("Esta accion es permanente. �Desea borrar la critica " + delete + " ? Y/N.");
			        	Scanner delete_scan = new Scanner(System.in);
			        	String deleteOpc = delete_scan.nextLine();
			        	if(deleteOpc.equals("Y")) {
			        		CriticaManager managerCriticaDelete = new CriticaManager(this.getMail());
			        		int id = criticasUser.get(Integer.parseInt(delete)-1).getId();
			        		managerCriticaDelete.deleteCritica(id);
			        		System.out.println("La critica ha sido borrada.");
				    	}
			        	else {
			        		System.out.println("La critica no ha sido borrada.");	
			        	}
			        	delete_scan.close();
			        	deleteCritica_scan.close();
		        	}
	        }
	        else if("4".equals(opc)) 
			{ 
	        	//TODO mostrar todas las criticas de las que el user no es autor.
	        	//TODO seleccionar por cont critica a dar like 
	        	//TODO dar like 
	        }
	        else if("5".equals(opc))
	        { 
	        	//TODO mostrar todas las criticas de las que el user no es autor.
	        	//TODO seleccionar por cont critica a dar dislike 
	        	//TODO dar dislike	
	        }
	        else if("6".equals(opc))
	        { 
	        	System.out.println("Estas son todas sus criticas");
	        	CriticaManager managerCriticaMostrarDelUser = new CriticaManager(this.getMail());
        		ArrayList<CriticaDTO> criticasUser = managerCriticaMostrarDelUser.requestCriticas();
        		for(CriticaDTO c : criticasUser) {
        			if(c.getMail().equals(this.getMail())) {
        				System.out.println("------------------------------------------------");
    	        		System.out.println("Titulo : " + c.getTitle());
    		        	System.out.println("	Puntuacion : " + c.getPuntuacion());
    		        	System.out.println("	Resena : " + c.getResena());
    		        	System.out.println("	Likes : " + c.getLike());
    		        	System.out.println("	Dislikes : " + c.getDislike());
    	        		System.out.println("------------------------------------------------");
        			}
        		}
	        }
	        else if("7".equals(opc))
	        {
	        	System.out.println("MOSTRAR CRITICAS DE UN USUARIO");
	        	System.out.println("Estos son los usuarios que han escrito criticas");
	        	//TODO mostrar writers.
	        	//TODO seleccion por cont de writer
	        	//TODO mostrar criticas de writer
	        }
	        else
	        { 
	        	System.out.println("Saliendo...\n\n");
	        }
		}
	}
}
