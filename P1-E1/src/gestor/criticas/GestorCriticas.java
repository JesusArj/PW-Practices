package gestor.criticas;

public class GestorCriticas {

	// 1 - The singleton

			private static GestorCriticas instance = null;

			// Other properties
			private String Mail = null;
			
			// 2 - Private constructor

			private GestorCriticas(String Mail) 
			{
				this.Mail=Mail; 
			}

			// 3 - Access point to the instance

			public static GestorCriticas getInstance(String Mail) {
				if(instance == null) {
					instance = new GestorCriticas(Mail);
					
				}
				return instance;
			}
			
			public void crearCritica()
			{
				if(instance!=null)
				{
					
				}
			}
			public void consultarCriticas()
			{
				if(instance!=null)
				{
					
				}
			}
			public void BorrarCritica()
			{
				if(instance!=null)
				{
					
				}
			}
			public void votarCriticas()
			{
				if(instance!=null)
				{
					
				}
			}
			public void buscarCriticas()
			{
				if(instance!=null)
				{
					
				}
			}
			
}
