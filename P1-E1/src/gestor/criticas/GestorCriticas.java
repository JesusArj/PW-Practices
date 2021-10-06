package gestor.criticas;

import critica.Critica;
import fichero.criticas.IOCriticas;

public class GestorCriticas {

	// 1 - The singleton

			private static GestorCriticas instance = null;

			// Other properties
			private String mail = null;
			private IOCriticas c = new IOCriticas(); 
			
			// 2 - Private constructor

			private GestorCriticas(String Mail) 
			{
				this.mail=Mail; 
			}

			// 3 - Access point to the instance

			public static GestorCriticas getInstance(String Mail) {
				if(instance == null) {
					instance = new GestorCriticas(Mail);
					
				}
				return instance;
			}
			
			public void crearCritica(Critica c)
			{
				if(instance!=null)
				{
					this.c.criticaToFich(c.getTitle(), c.getPuntuacion(), c.getResena(), c.getMail(), c.getLike(), c.getDislike(), c.getId(), c.getVotantes());
				}
			}
			
			public void consultarCriticas()
			{
				if(instance!=null)
				{
					this.c.printAll();
				}
			}
			
			//TODO:
			public void BorrarCritica()
			{
				if(instance!=null)
				{
					//Se puede usar la funcion buscarCritica de la clase IOCriticas, 
					//pasandole this.mail para mostrar al usuario todas sus criticas, 
					//para que seleccione la critica a borrar.
				}
			}
			//TODO:
			public void votarCriticas()
			{
				if(instance!=null)
				{
					//1.Se comprueba que this.mail no sea == a critica.mail (un usuario no puede votar en su propia critica)
					//2. Se comprueba que this.mail no este en el vector de votantes de la critica que esta intentando valorar
					//3 . Si no está en la lista
					//	3.1 Se le muestra la lista de criticas total, (consultarCriticas), selecciona la que quiera valorar,
					//	y se le incrementa o decrementa los likes/dislikes de dicha critica.
					//4.Se añade el this.mail al vector de votantes de la critica votada,
					//	para que el usuario no pueda votar de nuevo.
				}
			}
			public void buscarCriticas(String mail)
			{
				if(instance!=null)
				{
					this.c.buscarCritica(mail);
				}
			}
			
}
