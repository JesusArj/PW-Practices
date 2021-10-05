package gestor.usuarios;

public class GestorUsuarios {

		// 1 - The singleton

			private static GestorUsuarios instance = null;

			public String user;
			
			private GestorUsuarios(String user) 
			{
				this.user= user; 
			}

			// 3 - Access point to the instance

			public static GestorUsuarios getInstance(String user) {
				if(instance == null) {
					instance = new GestorUsuarios(user);
				}
				return instance;
			}
			
			public static void darAltaUser(String user) {
				
			}
			
			public static void darBajaUser(String user) {
				
			}
			
			/*public static String getUser() {
				//IOUsers -> io.get(this.user);
			}*/
			
			public static void updateUser(String user) {
				
			}
			
		
	}
