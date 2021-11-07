package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import display.views.*;
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		LoginView login = new LoginView();
		String mail = login.loginMenu();
		
		String opc = "1";
		while(opc.equals("1") || opc.equals("2") || opc.equals("3")) {
			System.out.println("Bienvenido a nuestro sistema.");
		   	System.out.println("Para ir a gestion de usuario, pulse 1.");
		   	System.out.println("Para ir a gestion de criticas, pulse 2.");
		   	System.out.println("Para ir a gestion de espectaculos, pulse 3.");
		   	System.out.println("Para salir del menu, pulse cualquier otra tecla.");
		    
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
					opc = buf.readLine();
				} 
			catch (IOException e) 
			{
					e.printStackTrace();
				}

			if("1".equals(opc)) 
				{ 
				UsuariosView userView = new UsuariosView(mail);
				userView.userMenu();
			}
			else if("2".equals(opc))
			{ 
				CriticasView criticasView = new CriticasView(mail);
				criticasView.CriticaMenu();
			}
			else if("3".equals(opc))
			{ 

				EspectaculosView espView = new EspectaculosView();
				espView.EspectaculoMenu();

			}
		}
	}
}
	

