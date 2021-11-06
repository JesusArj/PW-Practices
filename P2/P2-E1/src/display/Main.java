package display;

import java.io.IOException;
import display.views.*;
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		//Despues de loginView guardamos el mail para las comprobaciones.
		String mail = "admin";
		UsuariosView menuUser = new UsuariosView(mail);
		
		menuUser.userMenu();
	}
	
}
