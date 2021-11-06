package display.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import business.managers.UserManager;
/**
 * La clase MenuUsuario contiene la funcion UserMenu al usuario.
 * @author Developers
 */

public class UsuariosView 
{
	private String mail;
	
	private String getMail() {
		return mail;
	}
	
	public UsuariosView(String mail) {
		this.mail = mail;
	}
	
	public void userMenu() 
	{
		String opc = "1";
		while(opc.equals("1") || opc.equals("2") || opc.equals("3")) {
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
	        	UserManager managerUserRead = new UserManager();
	        	ArrayList<String> user = managerUserRead.readUser(this.getMail());
	        	System.out.println("Mail : " + user.get(2));
	        	System.out.println("Name : " + user.get(1));
	        	System.out.println("Username : " + user.get(2));  	
	        }
	        else if("2".equals(opc))
	        { 
	        	System.out.println("ACTUALIZACION DE DATOS");
	        	System.out.println("Estos son sus datos actuales:");
	        	UserManager managerUser = new UserManager();
	        	ArrayList<String> user = managerUser.readUser(this.getMail());
	        	System.out.println("	Mail : " + user.get(2));
	        	System.out.println("	Name : " + user.get(1));
	        	System.out.println("	Username : " + user.get(2)); 
	        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
	        	String username = null;
	        	Scanner username_scan = new Scanner(System.in);
	        	
	        	String name = null;
	        	Scanner name_scan = new Scanner(System.in);
	        	
	        	String password = null;
	        	Scanner password_scan = new Scanner(System.in);
	        	
	        	System.out.println("Introduzca su nuevo nombre de usuario");
	        	username = username_scan.nextLine();
	        	
	        	System.out.println("Introduzca su nuevo nombre");
	        	name = name_scan.nextLine();
	        	
	        	System.out.println("Introduzca su nueva Password");
	        	password = password_scan.nextLine();

	        	UserManager managerUserUpdate = new UserManager();
	        	managerUserUpdate.updateUser(this.getMail(), username, name, password);
	        	
	        	username_scan.close();
	        	name_scan.close();
	        	password_scan.close();
	        }
	        else if("3".equals(opc))
	        { 
	        	System.out.println("ELMINACION DE USUARIO");
	        	System.out.println("Esta accion es permanente. ¿Desea borrar su usuario? Y / N.");
	        	Scanner delete_scan = new Scanner(System.in);
	        	String delete = delete_scan.nextLine();
	        	if(delete.equals("Y")) {
	        		UserManager managerUserDelete = new UserManager();
	        		managerUserDelete.deleteUser(this.getMail());
	        		System.out.println("Su usuario ha sido borrado.");
		    	}
	        	else {
	        		System.out.println("Su usuario no ha sido borrado.");	
	        	}
	        	delete_scan.close();
	        }
	        else
	        { 
	        	System.out.println("Saliendo...\n\n");
	        }

			
			
		}
	}
}