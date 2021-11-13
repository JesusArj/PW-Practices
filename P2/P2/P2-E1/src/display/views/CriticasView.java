package display.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import business.DTOs.CriticaDTO;
import business.DTOs.EspectaculoDTO;
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
	        	String tipo = "1";
	        	Scanner reader = new Scanner(System.in);
	     
	        	System.out.println("CREAR CRITICA");
	        	System.out.println("Desea escribir una critica de un espectaculo:");
	        	System.out.println("1. Puntual");
	        	System.out.println("2. Temporada");
	        	System.out.println("3. Multiple");
	        	tipo = reader.nextLine();
	        	
	        	if(tipo.equals("1")) {
	        		CriticaManager managerCriticaCreatePunt = new CriticaManager(this.getMail());
	        		ArrayList<EspectaculoDTO> esps = managerCriticaCreatePunt.requestEspCriticablesPunt();
	        		int cont = 0;
	        		for(EspectaculoDTO e : esps) {
	        			cont++;
	        			System.out.println(cont + ". " + e.getTitulo());
	        			System.out.println("CATEGORIA: " + e.getCategoria());
	        			System.out.println("DESCRIPCION:" + e.getDescripcion()); 
	        		}
	        		System.out.println("Introduzca el numero del espectaculo a criticar");

	            	String criticarEsp = reader.nextLine();
	            	if(Integer.parseInt(criticarEsp) > 0 && Integer.parseInt(criticarEsp) <= cont ) {
	            		int id = esps.get(Integer.parseInt(criticarEsp)-1).getID();
	            		String titulo = null;
	    	        	float puntuacion = 0;
	    	        	String resena = null;
	    	        	System.out.println("Va a criticar: " + esps.get(Integer.parseInt(criticarEsp)-1).getTitulo());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = reader.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = Float.parseFloat(reader.nextLine());
	    	        	System.out.println("Escriba la resena del mismo");
	    	        	resena = reader.nextLine(); 
	    	        	managerCriticaCreatePunt.createCritica(titulo, puntuacion , resena, id); 
	            	}
	            	else {
	            		System.out.println("Espectaculo no valido");
	            	}
	        	}
	        	else if (tipo.equals("2")) {
	        		CriticaManager managerCriticaCreateTemp = new CriticaManager(this.getMail());
	        		ArrayList<EspectaculoDTO> esps = managerCriticaCreateTemp.requestEspCriticablesTemp();
	        		int cont = 1;
	        		for(EspectaculoDTO e : esps) {
	        			System.out.println(cont + ". " + e.getTitulo());
	        			System.out.println(e.getCategoria());
	        			System.out.println(e.getDescripcion());
	        		}
	        		System.out.println("Introduzca el numero del espectaculo a criticar");
	            	String criticarEsp = reader.nextLine();
	            	if(Integer.parseInt(criticarEsp) > 0 && Integer.parseInt(criticarEsp) < cont ) {
	            		int id = esps.get(Integer.parseInt(criticarEsp)).getID();
	            		String titulo = null;
	    	        	float puntuacion = 0;
	    	        	String resena = null;
	    	        	System.out.println("Va a criticar: " + esps.get(Integer.parseInt(criticarEsp)).getTitulo());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = reader.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = Float.parseFloat(reader.nextLine());
	    	        	System.out.println("Escriba la resena del mismo");
	    	        	resena = reader.nextLine(); 
	    	        	managerCriticaCreateTemp.createCritica(titulo, puntuacion , resena, id); 
	            	}
	            	else {
	            		System.out.println("Espectaculo no valido");
	            	}
	        		
	        	}
	        	else if (tipo.equals("3")) {
	        		CriticaManager managerCriticaCreateMult = new CriticaManager(this.getMail());
	        		ArrayList<EspectaculoDTO> esps = managerCriticaCreateMult.requestEspCriticablesMult();
	        		int cont = 1;
	        		for(EspectaculoDTO e : esps) {
	        			System.out.println(cont + ". " + e.getTitulo());
	        			System.out.println(e.getCategoria());
	        			System.out.println(e.getDescripcion());
	        		}
	        		System.out.println("Introduzca el numero del espectaculo a criticar");
	            	String criticarEsp = reader.nextLine();
	            	if(Integer.parseInt(criticarEsp) > 0 && Integer.parseInt(criticarEsp) < cont ) {
	            		int id = esps.get(Integer.parseInt(criticarEsp)).getID();
	            		String titulo = null;
	    	        	float puntuacion = 0;
	    	        	String resena = null;
	    	        	System.out.println("Va a criticar: " + esps.get(Integer.parseInt(criticarEsp)).getTitulo());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = reader.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = Float.parseFloat(reader.nextLine());
	    	        	System.out.println("Escriba la resena del mismo");
	    	        	resena = reader.nextLine(); 
	    	        	managerCriticaCreateMult.createCritica(titulo, puntuacion , resena, id);
	            	}
	            	else {
	            		System.out.println("Espectaculo no valido");
	            	}
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
		        		System.out.println("	Espectaculo : " + managerCriticaReadAll.selectTituloEsp(c.getId()));
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
		    	        		System.out.println("	Espectaculo : " + managerCriticaMostrarDelUser.selectTituloEsp(c.getId()));
		    		        	System.out.println("	Puntuacion : " + c.getPuntuacion());
		    		        	System.out.println("	Resena : " + c.getResena());
		    		        	System.out.println("	Likes : " + c.getLike());
		    		        	System.out.println("	Dislikes : " + c.getDislike());
		    	        		System.out.println("------------------------------------------------");
		    	        		cont++;
		        			}
		        		}
		        		System.out.println("Introduzca el numero de la critica que desea borrar");
			        	String delete = reader.nextLine();
			        	if(Integer.parseInt(delete) > 0 && Integer.parseInt(delete) < cont ) {
			        		System.out.println("Esta accion es permanente. �Desea borrar la critica " + delete + " ? Y/N.");
				        	String deleteOpc = reader.nextLine();
				        	if(deleteOpc.equals("Y")) {
				        		CriticaManager managerCriticaDelete = new CriticaManager(this.getMail());
				        		int id = criticasUser.get(Integer.parseInt(delete)-1).getId();
				        		managerCriticaDelete.deleteCritica(id);
				        		System.out.println("La critica ha sido borrada.");
					    	}
				        	else {
				        		System.out.println("La critica no ha sido borrada.");	
				        	}
			        	}
		        }
		        else if("4".equals(opc)) 
				{ 
		        	System.out.println("Estas son todas las criticas que puede valorar");
		        	CriticaManager managerCriticaLike = new CriticaManager(this.getMail());
		        	ArrayList<CriticaDTO> criticasValorables = managerCriticaLike.requestCriticasExUser();
		        	int cont = 1;
		        	for(CriticaDTO c : criticasValorables) {
		        		System.out.println("------------------------------------------------");
		        		System.out.println("Titulo : " + c.getTitle());
			        	System.out.println("	Autor : " + c.getMail());
		        		System.out.println("	Espectaculo : " + managerCriticaLike.selectTituloEsp(c.getId()));
			        	System.out.println("	Puntuacion : " + c.getPuntuacion());
			        	System.out.println("	Resena : " + c.getResena());
			        	System.out.println("	Likes : " + c.getLike());
			        	System.out.println("	Dislikes : " + c.getDislike());
		        		System.out.println("------------------------------------------------");
		        	}
		        	System.out.println("Introduzca el numero de la critica a la que desea dar like");
		        	String like = reader.nextLine();
		        	if(Integer.parseInt(like) > 0 && Integer.parseInt(like) < cont ) {
			        	if(managerCriticaLike.darLike(criticasValorables.get(Integer.parseInt(like)-1).getId())) {
			        		System.out.println("Ha dado like a la critica:");
			        		CriticaDTO critica = criticasValorables.get(Integer.parseInt(like)-1);
			        		System.out.println("Titulo : " + critica.getTitle());
				        	System.out.println("	Autor : " + critica.getMail());
			        		System.out.println("	Espectaculo : " + managerCriticaLike.selectTituloEsp(critica.getId()));
				        	System.out.println("	Puntuacion : " + critica.getPuntuacion());
				        	System.out.println("	Resena : " + critica.getResena());		
			        	}
			        	else {
			        		System.out.println("No ha podido dar like");
			        	}
		        	}
		        	else {
		        		System.out.println("Numero de critica no valido");
		        	}

		        }
		        else if("5".equals(opc))
		        { 
		        	System.out.println("Estas son todas las criticas que puede valorar");
		        	CriticaManager managerCriticaLike = new CriticaManager(this.getMail());
		        	ArrayList<CriticaDTO> criticasValorables = managerCriticaLike.requestCriticasExUser();
		        	int cont = 1;
		        	for(CriticaDTO c : criticasValorables) {
		        		System.out.println("------------------------------------------------");
		        		System.out.println("Titulo : " + c.getTitle());
			        	System.out.println("	Autor : " + c.getMail());
		        		System.out.println("	Espectaculo : " + managerCriticaLike.selectTituloEsp(c.getId()));
			        	System.out.println("	Puntuacion : " + c.getPuntuacion());
			        	System.out.println("	Resena : " + c.getResena());
			        	System.out.println("	Likes : " + c.getLike());
			        	System.out.println("	Dislikes : " + c.getDislike());
		        		System.out.println("------------------------------------------------");
		        	}
		        	System.out.println("Introduzca el numero de la critica a la que desea dar dislike");
		        	String dislike = reader.nextLine();
		        	if(Integer.parseInt(dislike) > 0 && Integer.parseInt(dislike) < cont ) {
			        	if(managerCriticaLike.darDislike(criticasValorables.get(Integer.parseInt(dislike)-1).getId())) {
			        		System.out.println("Ha dado dislike a la critica:");
			        		CriticaDTO critica = criticasValorables.get(Integer.parseInt(dislike)-1);
			        		System.out.println("Titulo : " + critica.getTitle());
				        	System.out.println("	Autor : " + critica.getMail());
			        		System.out.println("	Espectaculo : " + managerCriticaLike.selectTituloEsp(critica.getId()));
				        	System.out.println("	Puntuacion : " + critica.getPuntuacion());
				        	System.out.println("	Resena : " + critica.getResena());		
			        	}
			        	else {
			        		System.out.println("No ha podido dar dislike");
			        	}
		        	}
		        	else {
		        		System.out.println("Numero de critica no valido");
		        	}
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
	    	        		System.out.println("	Espectaculo : " + managerCriticaMostrarDelUser.selectTituloEsp(c.getId()));
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
		        	CriticaManager managerCriticaMostrarCriticasWriter = new CriticaManager(this.getMail());
		        	ArrayList<String> writers = managerCriticaMostrarCriticasWriter.requestWriters();
		        	int cont = 1;
		        	for(String s : writers) {
		        		System.out.println(cont + ". " + s);
		        	}
		        	System.out.println("Introduzca el numero del autor del que quiere ver todas sus criticas");
		        	String s = reader.nextLine();
		        	String writer = writers.get(Integer.parseInt(s)-1);
		        	ArrayList<CriticaDTO> criticasUser = managerCriticaMostrarCriticasWriter.requestCriticas();
		        	for (CriticaDTO c : criticasUser) {
		        		if(c.getMail().equals(writer)) {
		        			System.out.println("------------------------------------------------");
	    	        		System.out.println("Titulo : " + c.getTitle());
	    	        		System.out.println("	Espectaculo : " + managerCriticaMostrarCriticasWriter.selectTituloEsp(c.getId()));
	    		        	System.out.println("	Puntuacion : " + c.getPuntuacion());
	    		        	System.out.println("	Resena : " + c.getResena());
	    		        	System.out.println("	Likes : " + c.getLike());
	    		        	System.out.println("	Dislikes : " + c.getDislike());
	    	        		System.out.println("------------------------------------------------");
		        		}
		        	}
		        }
		        else
		        { 
		        	System.out.println("Saliendo...\n\n");
		        }
			}
		}
	}
}
