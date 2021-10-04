package main.program;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fichero.credenciales.IOCredenciales;
public class mainProgram {

	public static void main(String[] args) throws IOException 
	{
        System.out.println("Bienvenido a nuestro sistema de gestion de criticas.");
        System.out.println("Por favor, introduzca sus credenciales.");
        System.out.println("Usuario:");
        String User = null, Passwd = null;
	        BufferedReader readerUser = new BufferedReader(
		            new InputStreamReader(System.in));
	        try {
				User = readerUser.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
        System.out.println("Password:");
	        BufferedReader readerPasswd = new BufferedReader(
		            new InputStreamReader(System.in));
	        try {
				Passwd = readerPasswd.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
        System.out.println("Cargando . . .");
        IOCredenciales ioc = new IOCredenciales();
        if(!ioc.comprobarUserExist(User)) {
        	String opcion = null;
            System.out.println("Usuario no registrado.");
            System.out.println("Para registrarse pulse 1. Para salir pulse cualquier otra tecla.");
            BufferedReader readerRegister = new BufferedReader(
		            new InputStreamReader(System.in));
	        try {
				opcion = readerRegister.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        if("1".equals(opcion)) {
	        	String username = null, passwd = null;
	            System.out.println("Introduzca su username:");
	            BufferedReader Register = new BufferedReader(
			            new InputStreamReader(System.in));
		        try {
					username = Register.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        System.out.println("Introduzca su passwd:");
	            BufferedReader Register1 = new BufferedReader(
			            new InputStreamReader(System.in));
		        try {
					passwd = Register1.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        IOCredenciales newUser = new IOCredenciales();
		        newUser.RegisterUserToFich(username, passwd);
		        System.out.println("Ha sido registrado correctamente.");
		        System.out.println("Bienvenido a nuestro sistema " + User + ".");
        		while(opcion!="1" || opcion!= "2" || opcion!="3") {
	            	System.out.println("¿Qué desea hacer?");
	            	System.out.println("1. Modificar mis datos");
	            	System.out.println("2. Acceder al sistema de criticas");
	            	System.out.println("3. Salir");

	            	BufferedReader readerGestores = new BufferedReader(
	    		            new InputStreamReader(System.in));
	    			try {
	    				opcion = readerGestores.readLine();
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
	    			if("1".equals(opcion)) {
	    				//gestorUsuarios
	    				opcion=null;
	    			}
	    			else if("2".equals(opcion)) {
	    				//gestorCriticas
	    				opcion=null;
	    			}	
	    			else if("3".equals(opcion)) {
			            System.out.println("Gracias por usar nuestro sistema. Hasta la próxima.");
			            return;
	    			}
	    			else {
			            System.out.println("Opcion no permitida.");
	    			}
        		}
	        }
            else {
	        	System.out.println("Gracias por usar nuestro sistema");
	            return;
            }
        }
        if(!ioc.comprobarPasswd(User, Passwd)) {
        	int intentos = 1;
	        String opcion1 = null;
	        Boolean timeout = true;
            System.out.println("Contraseña incorrecta. Pulse 1 para volver a intentarlo. Para salir pulse cualquier otra tecla. ");
            BufferedReader readerWrongPasswd = new BufferedReader(
		            new InputStreamReader(System.in));
			try {
				opcion1 = readerWrongPasswd.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        if(!("1".equals(opcion1))) {
	            System.out.println("Gracias por usar nuestro sistema");
	            return;
	        }
	        else {
	        	while(!ioc.comprobarPasswd(User, Passwd) && timeout) {
	            	System.out.println("Password:");
		 	        BufferedReader reader = new BufferedReader(
		 		            new InputStreamReader(System.in));
		 	        try {
		 				Passwd = reader.readLine();
		 			} catch (IOException e) {
		 				e.printStackTrace();
		 			}
		 	        intentos++;
		 	        if(intentos>3)
		 	        	timeout = false;
	            }
	        	if(!timeout) {
	            	System.out.println("Ha excedido el numero de intentos permitidos.");
		            System.out.println("Gracias por usar nuestro sistema");
		            return;
	        	}
	        	else {
        			System.out.println("Bienvenido a nuestro sistema " + User + ".");
	        		while(opcion1!="1" || opcion1!= "2" || opcion1!="3") {
		            	System.out.println("¿Qué desea hacer?");
		            	System.out.println("1. Modificar mis datos");
		            	System.out.println("2. Acceder al sistema de criticas");
		            	System.out.println("3. Salir");

		            	BufferedReader readerGestores = new BufferedReader(
		    		            new InputStreamReader(System.in));
		    			try {
		    				opcion1 = readerGestores.readLine();
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    			if("1".equals(opcion1)) {
		    				//gestorUsuarios
		    				opcion1=null;
		    			}
		    			else if("2".equals(opcion1)) {
		    				//gestorCriticas
		    				opcion1=null;
		    			}	
		    			else if("3".equals(opcion1)) {
				            System.out.println("Gracias por usar nuestro sistema. Hasta la próxima.");
				            return;
		    			}
		    			else {
				            System.out.println("Opcion no permitida.");
		    			}
	        		}
	        	}
	        }     
        }
 	}
}	



