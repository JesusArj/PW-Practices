package display;

import java.io.IOException;
import display.views.UsuariosView;
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		UsuariosView menuUser = new UsuariosView();
		
		menuUser.userMenu();
	}
	
}
