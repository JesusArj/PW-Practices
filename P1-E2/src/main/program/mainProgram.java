package main.program;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import fichero.users.IOUsers;
import menus.MenuCriticas;
import menus.MenuUsuario;
public class mainProgram {

	public static void main(String[] args) throws IOException 
	{
        String email = null, passwd = null, opcion = null, name = null, username = null;
        IOUsers io = new IOUsers();
        System.out.println("Bienvenido a nuestro sistema de gestion de criticas.");
        System.out.println("Para iniciar sesion pulse 1. Para registrarse pulse 2. Para salir pulse cualquier otra tecla.");
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opcion = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        if("1".equals(opcion)) {
        	System.out.println("Por favor, introduzca sus credenciales.");
            System.out.println("Email:");
    	        BufferedReader readerUser = new BufferedReader(
    		            new InputStreamReader(System.in));
    	        try {
    				email = readerUser.readLine();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
            System.out.println("Password:");
    	        BufferedReader readerPasswd = new BufferedReader(
    		            new InputStreamReader(System.in));
    	        try {
    				passwd = readerPasswd.readLine();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
            System.out.println("Cargando . . .");
            if(io.comprobarUserExist(email)==false) {
                System.out.println("email no registrado.");
                System.out.println("Para registrarse pulse 1. Para salir pulse cualquier otra tecla.");
                BufferedReader readerRegister = new BufferedReader(
    		            new InputStreamReader(System.in));
    	        try {
    				opcion = readerRegister.readLine();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    	        if("1".equals(opcion)) {
    	            System.out.println("Introduzca su email:");
    	            BufferedReader Register = new BufferedReader(
    			            new InputStreamReader(System.in));
    		        try {
    					email = Register.readLine();
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
					System.out.println("Introduzca su nombre:");
    	            BufferedReader Register11 = new BufferedReader(
    			            new InputStreamReader(System.in));
    		        try {
    					name = Register11.readLine();
    				} catch (IOException e) {
    					e.printStackTrace();
					}
					System.out.println("Introduzca su username:");
    	            BufferedReader Register111 = new BufferedReader(
    			            new InputStreamReader(System.in));
    		        try {
    					username = Register111.readLine();
    				} catch (IOException e) {
    					e.printStackTrace();
					}

    		        IOUsers newUser = new IOUsers();
    		        newUser.RegisterUserToFich(name,username,email, passwd);
    		        System.out.println("Ha sido registrado correctamente.");
    		        System.out.println("Bienvenido a nuestro sistema " + username + ".");
            		while(opcion!="1" || opcion!= "2" || opcion!="3") {
    	            	System.out.println("�Que desea hacer?");
    	            	System.out.println("1. Acceder al menu de usuarios");
    	            	System.out.println("2. Acceder al menu de criticas");
    	            	System.out.println("3. Salir");

    	            	BufferedReader readerGestores = new BufferedReader(
    	    		            new InputStreamReader(System.in));
    	    			try {
    	    				opcion = readerGestores.readLine();
    	    			} catch (IOException e) {
    	    				e.printStackTrace();
    	    			}
    	    			if("1".equals(opcion)) {
    	    				MenuUsuario menu = new MenuUsuario();
    	    				menu.userMenu(email);
    	    				opcion=null;
    	    			}
    	    			else if("2".equals(opcion)) {
    	    				MenuCriticas menu = new MenuCriticas();
    	    				menu.reviewMenu(email);
    	    				opcion=null;
    	    			}	
    	    			else if("3".equals(opcion)) {
    			            System.out.println("Gracias por usar nuestro sistema. Hasta la proxima.");
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
            if(io.comprobarPasswd(email, passwd)==false) {
            	int intentos = 1;
    	        String opcion1 = null;
    	        Boolean timeout = true;
                System.out.println("Contrasena incorrecta. Pulse 1 para volver a intentarlo. Para salir pulse cualquier otra tecla. ");
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
    	        	while(!(io.comprobarPasswd(email, passwd)) && timeout) {
    	            	System.out.println("Password:");
    		 	        BufferedReader reader = new BufferedReader(
    		 		            new InputStreamReader(System.in));
    		 	        try {
    		 				passwd = reader.readLine();
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
						
            			System.out.println("Bienvenido a nuestro sistema, " + io.buscarPorCorreo(email).getUsername() + ".");
    	        		while(opcion1!="1" || opcion1!= "2" || opcion1!="3") {
    		            	System.out.println("�Que desea hacer?");
    		            	System.out.println("1. Acceder al menu de usuarios");
    		            	System.out.println("2. Acceder al menu de criticas");
    		            	System.out.println("3. Salir");

    		            	BufferedReader readerGestores = new BufferedReader(
    		    		            new InputStreamReader(System.in));
    		    			try {
    		    				opcion1 = readerGestores.readLine();
    		    			} catch (IOException e) {
    		    				e.printStackTrace();
    		    			}
    		    			if("1".equals(opcion1)) {
        	    				MenuUsuario menu = new MenuUsuario();
        	    				menu.userMenu(email);
    		    				opcion1=null;
    		    			}
    		    			else if("2".equals(opcion1)) {
    		    				MenuCriticas menu = new MenuCriticas();
        	    				menu.reviewMenu(email);
    		    				opcion1=null;
    		    			}	
    		    			else if("3".equals(opcion1)) {
    				            System.out.println("Gracias por usar nuestro sistema. Hasta la proxima.");
    				            return;
    		    			}
    		    			else {
    				            System.out.println("Opcion no permitida.");
    		    			}
    	        		}
    	        	}
    	        }     
            }
	        System.out.println("Bienvenido a nuestro sistema " + io.buscarPorCorreo(email).getUsername() + ".");
    		
			while(opcion !="1" || opcion!= "2" || opcion!="3") {
            	System.out.println("�Que desea hacer?");
            	System.out.println("1. Acceder al menu de usuarios");
            	System.out.println("2. Acceder al menu de criticas");
            	System.out.println("3. Salir");

            	BufferedReader readerGestores = new BufferedReader(
    		            new InputStreamReader(System.in));
    			try {
    				opcion = readerGestores.readLine();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			if("1".equals(opcion)) {
    				MenuUsuario menu = new MenuUsuario();
    				menu.userMenu(email);
    				opcion=null;
    			}
    			else if("2".equals(opcion)) {
    				MenuCriticas menu = new MenuCriticas();
    				menu.reviewMenu(email);
    				opcion=null;
    			}	
    			else if("3".equals(opcion)) {
		            System.out.println("Gracias por usar nuestro sistema. Hasta la proxima.");
		            return;
    			}
    			else {
		            System.out.println("Opcion no permitida.");
    			}
    		}
        }
        else if("2".equals(opcion)) {
        	passwd = null;
		   
			System.out.println("Introduzca su email:");
			BufferedReader Register = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				email = Register.readLine();
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
			System.out.println("Introduzca su nombre:");
			BufferedReader Register11 = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				name = Register11.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Introduzca su username:");
			BufferedReader Register111 = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				username = Register111.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			IOUsers newUser = new IOUsers();
			newUser.RegisterUserToFich(name,username,email, passwd);
			
	        System.out.println("Ha sido registrado correctamente.");
	        System.out.println("Bienvenido a nuestro sistema " + io.buscarPorCorreo(email).getUsername() + ".");
    		
			while(opcion !="1" || opcion!= "2" || opcion!="3") {
            	System.out.println("�Que desea hacer?");
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
    				MenuUsuario menu = new MenuUsuario();
    				menu.userMenu(email);
    				opcion=null;
    			}
    			else if("2".equals(opcion)) {
    				MenuCriticas menu = new MenuCriticas();
    				menu.reviewMenu(email);
    				opcion=null;
    			}	
    			else if("3".equals(opcion)) {
		            System.out.println("Gracias por usar nuestro sistema. Hasta la proxima.");
		            return;
    			}
    			else {
		            System.out.println("Opcion no permitida.");
    			}
    		}
        }
        else {
        	System.out.println("Gracias por usar nuestro sistema. Hasta la proxima.");
            return;
        }
	}
}

