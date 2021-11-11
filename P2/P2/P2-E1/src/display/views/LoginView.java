package display.views;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import business.managers.UserManager;

public class LoginView 
{
	
	public String loginMenu() 
	{
		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFicheroProp = rutaAbsoluta + "/sql.properties";
		System.out.println(rutaAbsoluta);
		System.out.println(rutaFicheroProp);
		
		String mailNotUsed = "";
		String opc="1";
		
		while(opc.equals("1") || opc.equals("2")) 
		{
			System.out.println("Bienvenido a nuestro sistema.");
		    System.out.println("Para iniciar sesion, pulse 1.");
		    System.out.println("Para registrarse, pulse 2.");	    
		    System.out.println("Para salir del menu, pulse cualquier otra tecla.");			
	        
		    Scanner opcScan = new Scanner(System.in);
		    opc = opcScan.nextLine();
		    
	        if("1".equals(opc)) 
			{ 
	        	System.out.println("LOGIN");
	        	UserManager managerUserLogin = new UserManager();
	        	String mail = null;
	        	Scanner mail_scan = new Scanner(System.in);
	        	String password = null;
	        	Scanner password_scan = new Scanner(System.in);
	        	
	        	System.out.println("Introduzca su mail");
	        	mail = mail_scan.nextLine();
	     
	        	System.out.println("Introduzca su password");
	        	password = password_scan.nextLine();
	        	
	        	if(managerUserLogin.login(mail,password)) {
	        		System.out.println("Bienvenido");
	        		mail_scan.close();
		        	password_scan.close();
	        		return mail;
	        	}
	        	else {
	        		System.out.println("Login incorrecto");
	        		mail_scan.close();
		        	password_scan.close();
	        	}
	        	opc = "0";
	        }
	        else if("2".equals(opc))
	        { 
	        	System.out.println("REGISTRO");
	        	String username = null;
	        	Scanner username_scan = new Scanner(System.in);
	        	String name = null;
	        	Scanner name_scan = new Scanner(System.in);
	        	String password = null;
	        	Scanner password_scan = new Scanner(System.in);
	        	String mail = null;
	        	Scanner mail_scan = new Scanner(System.in);
	        	String rol = "0";
	        	Scanner rol_scan = new Scanner(System.in);
	     
	        	System.out.println("Introduzca su mail:");
	        	mail = mail_scan.nextLine();
	        	System.out.println(mail);
	        	System.out.println("Introduzca su username:");
	        	username = username_scan.nextLine();
	        	System.out.println("Introduzca su name:");
	        	name = name_scan.nextLine();
	        	System.out.println("Introduzca su password:");
	        	password = password_scan.nextLine();	
	        	System.out.println("Introduzca 1 si es Admin, 2 si es usuario");
	        	rol = rol_scan.nextLine();
	        	if(rol.equals("1"))
	        		rol = "admin";
	        	else 
	        		rol = "user";	
      
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime now = LocalDateTime.now();
				String aux = now.format(formatter);
				
				LocalDateTime fecha = LocalDateTime.parse(aux, formatter);
				
	        	UserManager managerUser = new UserManager();
	        	
	        	if(!managerUser.UserExist(mail)) {
	        		managerUser.createUser(mail, username, name, password, rol, fecha, fecha);
	        		mail_scan.close();
	        	
	        	}
	        	else {
	        		System.out.println("El mail que desea usar ya existe");
	        		System.out.println("Saliendo...\n\n");
	        		System.exit(0);
	        	}
	        	opc = "0";
	        	username_scan.close();
	        	name_scan.close();
	        	password_scan.close();
	        	mail_scan.close();
	        	rol_scan.close();
	        	return mail;
	        	
	        }
	        else
	        { 
	        	System.out.println("Saliendo...\n\n");
	        	System.exit(0);
	        }
	        opcScan.close();
		}
		return mailNotUsed;
	}
}
