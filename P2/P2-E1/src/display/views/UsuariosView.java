package display.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * La clase MenuUsuario contiene la funcion UserMenu al usuario.
 * @author Developers
 */

public class UsuariosView 
{
	public void userMenu(String mail) 
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
        	//TODO
        }
        else if("2".equals(opc))
        { 
			
        	//TODO
        	
        }
        else if("3".equals(opc))
        { 
        	//TODO
        }
        else
        { 
        	System.out.println("Saliendo...\n\n");
        }

	}
}