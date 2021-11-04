package display.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import business.managers.UserManager;
/**
 * La clase MenuUsuario contiene la funcion UserMenu al usuario.
 * @author Developers
 */

public class UsuariosView 
{
	public void userMenu() 
	{

		String opc = null;
		
	    System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
	    System.out.println("Para ver los datos de su perfil, pulse 1.");
	    System.out.println("Para actualizar sus datos de usuario, pulse 2.");
	    System.out.println("Para dar de baja su usuario, pulse 3.");	    
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
        	System.out.println("DATOS DE USUARIO");
        	//TODO: LO QUE DEVUELVA EL DTO
        }
        else if("2".equals(opc))
        { 
        	System.out.println("ACTUALIZACION DE DATOS");
        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
        	String username = null;
        	Scanner username_scan = new Scanner(System.in);
        	
        	String email = null;
        	Scanner mail_scan = new Scanner(System.in);
        	
        	String name = null;
        	Scanner name_scan = new Scanner(System.in);
        	
        	String password = null;
        	Scanner password_scan = new Scanner(System.in);
        	
        	System.out.println("Introduzca su nuevo nombre de usuario");
        	username = username_scan.nextLine();
        	
        	System.out.println("Introduzca su nuevo mail");
        	email = mail_scan.nextLine();
        	
        	System.out.println("Introduzca su nuevo nombre");
        	name = name_scan.nextLine();
        	
        	System.out.println("Introduzca su nueva Password");
        	password = password_scan.nextLine();
        	
        	//TODO: Usar las funcione del DTO
        	UserManager managerUser = new UserManager();
        	managerUser.updateUser(email, username, name, password);
        	
        	username_scan.close();
        	mail_scan.close();
        	name_scan.close();
        	password_scan.close();
        }
        else if("3".equals(opc))
        { 
        	System.out.println("ELMINACION DE USUARIO");
        	//TODO
        }
        else
        { 
        	System.out.println("Saliendo...\n\n");
        }

	}
}