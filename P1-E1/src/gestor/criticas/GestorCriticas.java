package gestor.criticas;

public class GestorCriticas {

	// 1 - The singleton

		private static GestorCriticas instance = null;

		// Other properties
		private String user;
		
		// 2 - Private constructor

		private GestorCriticas(String user) 
		{
			this.user= user; 
		}

		// 3 - Access point to the instance

		public static GestorCriticas getInstance() {
			if(instance == null) {
				instance = new GestorCriticas();
				
			}
			return instance;
		}
		
		// Other operations within the class
		public Integer nextRandomValue() {
			if(instance != null) {
				Integer rndValue = Integer.valueOf(this.rndObject.nextInt());
				return rndValue;
			}
			return null;
		}
	
}
