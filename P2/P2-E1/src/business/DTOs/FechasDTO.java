package business.DTOs;

import java.time.LocalDateTime;

public class FechasDTO 
{
	public FechasDTO(int id, LocalDateTime fecha_date) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Clase que implementa una fecha con sus variables privadas y metodos
	 * @author Developers
	 */

	public class FechaDTO{

		/**
		 * Variable que almacena el identificador de la fecha especifica
		 */
		
		private int  id; 
		
		/**
		 * Varaible que almacena fecha y hora del espectaculo
		 */
		
		private LocalDateTime fecha;
		
		public FechaDTO(){}
		
		/**
		 * Constructor parametrizado.
		 * @param id identificador de la fecha
		 * @param fecha fecha y hora del espectaculo
		 * @author Developers
		 */
		
		public FechaDTO(int id, LocalDateTime fecha)
		{
			this.id=id; 
			this.fecha=fecha;
		}
		
		//OBSERVADORES
		
		/**
		 * Getter del identificador de la fecha
		 * @return Numero entero con el identificador de la fecha
		 * @author Developers
		 */
		
		public int getID()
		{
			return this.id; 
		}
		
		/**
		 * Getter de la fecha especifica
		 * @return Variable con la fecha y hora del espectaculo
		 * @author Developers
		 */
		
		public LocalDateTime getFecha()
		{
			return this.fecha; 
		}
		
		
		//MODIFICADORES
		
		/**
		 * Setter del ID de la fecha
		 * @param id Identificador de la fecha
		 * @author Developers
		 */
		
		public void setID(int id)
		{
			this.id = id; 
		}
		
		/**
		 * Setter de la fecha del espectaculo
		 * @param fecha Fecha y hora del espectaculo
		 * @author Developers
		 */
		
		public void setFecha(LocalDateTime fecha)
		{
			this.fecha = fecha; 
		}
	}
}
