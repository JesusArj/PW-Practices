package gestor.usuarios;
import espectador.Espectador;
import fichero.users.IOUsers;

public class GestorUsuarios {

		// 1 - The singleton

			private static GestorUsuarios instance = null;
			
			public IOUsers User = new IOUsers();
			public String Mail;
			
			private GestorUsuarios(String Mail) 
			{
				//RELLENAMOS ESPECTADORES
				this.Mail = Mail; 
			}

			// 3 - Access point to the instance

			public static GestorUsuarios getInstance(String Mail) {
				if(instance == null) {
					instance = new GestorUsuarios(Mail);
				}
				return instance;
			}
			
			public void darAltaUser(Espectador e1) 
			{
				if(instance!=null)
				{
					this.User.RegisterUserToFich(e1.getName(), e1.getUsername(), e1.getMail(), e1.getPasswd());
				}
			}
			
			public void darBajaUser() 
			{
				if(instance!=null)
				{
					this.User.borrarUser(this.Mail);
					System.exit(1);
				}
			}
			
			/*public static String getUser() {
				//IOUsers -> io.get(this.user);
			}*/
			
			public void verDatosUser()
			{
				if(instance!=null)
				{
					User.imprimirDatosUser(this.Mail);
				}
			}
			
			//TODO: 
			/*
			public static void updateUser(String Mail) 
			{
				
			}
			*/
		
	}
