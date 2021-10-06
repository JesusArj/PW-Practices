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
			
			public void buscarCriticas(String mail)
			{
				if(instance!=null)
				{
					this.c.buscarCriticas(mail);
				}
			}
						
			public void BorrarCritica(Critica c)
			{
				if(instance!=null)
					this.c.borrarCritica(c.getId(), this.mail);
			}
			
			public void votarCriticasPos(Critica c)
			{
				if(instance!=null)
					this.c.votarCriticaPos(this.mail, c);
			}
			
			public void votarCriticasPos(int id)
			{
				if(instance!=null)
					this.c.votarCriticaPos(this.mail, id);
			}
			
			public void votarCriticasNeg(Critica c)
			{
				if(instance!=null)
					this.c.votarCriticaNeg(this.mail, c);
			}
			
			public void votarCriticasNeg(int id)
			{
				if(instance!=null)
					this.c.votarCriticaNeg(this.mail, id);
			}
			
			
			
}
