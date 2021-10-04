package gestor.criticas;

public class GestorCriticas {

	// 1 - The singleton

			private static GestorCriticas instance = null;

			// Other properties
			private String user;
			
			// 2 - Private constructor

			private GestorCriticas(String user) 
			{
				this.user=user; 
			}

			// 3 - Access point to the instance

			public static GestorCriticas getInstance(String user) {
				if(instance == null) {
					instance = new GestorCriticas(user);
					
				}
				return instance;
			}
	
}
