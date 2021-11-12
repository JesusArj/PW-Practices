package display;

import java.io.IOException;
import java.util.Scanner;

import display.views.*;
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		/*LoginView login = new LoginView();
		String mail = login.loginMenu();
		*/
		String mail = "p92";
		if(!mail.equals(""))
		{
			String opc="1";
		   	Scanner opcScan = new Scanner(System.in);
			while(opc.equals("1") || opc.equals("2") || opc.equals("3") && (!mail.equals(""))) 
			{
				System.out.println("Bienvenido a nuestro sistema.");
			   	System.out.println("Para ir a gestion de usuario, pulse 1.");
			   	System.out.println("Para ir a gestion de criticas, pulse 2.");
			   	System.out.println("Para ir a gestion de espectaculos, pulse 3.");
			   	System.out.println("Para salir del menu, pulse cualquier otra tecla.");
			   	opc = "14";
			   	if(opcScan.hasNext())
			   	{
				    opc = opcScan.nextLine();
				    System.out.println(opc);
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
						EspectaculosView espView = new EspectaculosView(mail);
						espView.EspectaculoMenu();
					}
					else 
					{
						System.out.println("");
						System.out.println("Gracias por usar nuestro sistema!");
						System.exit(0);
					}
			   	}
			   	System.out.println(opc);
			}
			opcScan.close();
		}
	}
}

	

