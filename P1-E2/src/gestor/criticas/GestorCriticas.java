package gestor.criticas;

import critica.Critica;
import fichero.criticas.IOCriticas;

/**
 * Clase que llama a todas las funciones para la gestion de criticas.
 * @author Developers
 */	
public class GestorCriticas {

			private static GestorCriticas instance = null;


			private String mail = null;
			private IOCriticas c = new IOCriticas(); 
	

			private GestorCriticas(String Mail) 
			{
				this.mail=Mail; 
			}


			public static GestorCriticas getInstance(String Mail) {
				if(instance == null) {
					instance = new GestorCriticas(Mail);
					
				}
				return instance;
			}
			
			/**
			 * Funcion que crea una critica
			 * @param c Objeto de la clase critica
			 * @author Developers
			 */	
			public void crearCritica(Critica c)
			{
				if(instance!=null)
				{
					this.c.criticaToFich(c.getTitle(),c.getPuntuacion(), c.getResena(), c.getMail(), c.getLike(), c.getDislike(), c.getId(), c.getVotantes());
				}
			}
			
			/**
			 * Funcion que imprime por pantalla todas
			 * las criticas almacenadas
			 * @author Developers
			 * 
			 */	
			
			public void consultarCriticas()
			{
				if(instance!=null)
				{
					this.c.printAll();
				}
			}
			
			/**
			 * Funcion que busca una critica concreta
			 * @param mail Mail del autor
			 * @author Developers
			 */
			
			public void buscarCriticas(String mail)
			{
				if(instance!=null)
				{
					this.c.buscarCriticas(mail);
				}
			}
			
			/**
			 * Funcion que busca una critica concreta
			 * @param c Objeto de la clase critica
			 * @author Developers
			 */
			
			public void BorrarCritica(Critica c)
			{
				if(instance!=null)
					this.c.borrarCritica(c.getId(), this.mail);
			}
			

			/**
			 * Funcion que anade un voto positivo
			 * a una critica concreta
			 * @param id Identificador de la critica
			 * @author Developers
			 */
			
			public void votarCriticasPos(int id)
			{
				if(instance!=null)
					this.c.votarCriticaPos(this.mail, id);
			}

			/**
			 * Funcion que anade un voto positivo
			 * a una critica concreta
			 * @param id Identificador de la critica
			 * @author Developers
			 */
		
			public void votarCriticasNeg(int id)
			{
				if(instance!=null)
					this.c.votarCriticaNeg(this.mail, id);
			}
			
			
			
}
