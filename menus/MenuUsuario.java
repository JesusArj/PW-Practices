package menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gestor.usuarios.GestorUsuarios;

public class MenuUsuario {

	
	//Pasarle por args el usuario ¿Debería ser segun mail?
	public static void userMenu(String usuario) 
	{
		String opc = null;
	    System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
	    System.out.println("Para actualizar los datos de su perfil, pulse 1. Para dar de baja su usuario, pulse 2.");
	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	    
        BufferedReader login = new BufferedReader(
	            new InputStreamReader(System.in));
        try {
			opc = login.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
                
        if("1".equals(opc)) {
        	
        }
        else if("2".equals(opc))
        {
        	
        }
        else
        {
        	System.out.println("Gracias por usar el menu");
        }

	}
}