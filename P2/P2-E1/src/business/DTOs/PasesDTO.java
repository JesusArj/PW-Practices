package business.DTOs;

import java.time.LocalDateTime;

public class PasesDTO 
{
	/**
	 * Clase que implementa un pase de fechas con sus variables privadas y metodos
	 * @author Developers
	 */

	public class PaseDTO{

		/**
		 * Variable que almacena el identificador del pase especifico
		 */
		
		private int  id; 
		
		/**
		 * Varaible que almacena fecha y hora de comienzo del espectaculo
		 */
		
		private LocalDateTime fechaInicio;
		
		/**
		 * Varaible que almacena fecha y hora de fin del espectaculo
		 */
		
		private LocalDateTime fechaFinal;
		
		public PaseDTO(){}
		
		/**
		 * Constructor parametrizado.
		 * @param id Nombre del usuario
		 * @param fechaInicio fecha y hora de comienzo del espectaculo
		 * @param fechaFinal fecha y hora de fin del espectaculo
		 * @author Developers
		 */
		
		public PaseDTO(int id, LocalDateTime fechaInicio, LocalDateTime fechaFinal)
		{
			this.id=id; 
			this.fechaInicio = fechaInicio;
			this.fechaFinal = fechaFinal;
		}
		
		//OBSERVADORES
		
		/**
		 * Getter del identificador del pase
		 * @return Numero entero con el identificador del pase
		 * @author Developers
		 */
		
		public int getID()
		{
			return this.id; 
		}
		
		/**
		 * Getter de la fecha de incio
		 * @return Variable con la fecha y hora de comienzo del pase
		 * @author Developers
		 */
		
		public LocalDateTime getFechaInicio()
		{
			return this.fechaInicio; 
		}
		
		/**
		 * Getter de la fecha de fin
		 * @return Variable con la fecha y hora de final del pase
		 * @author Developers
		 */
		
		public LocalDateTime getFechaFinal()
		{
			return this.fechaFinal; 
		}
		
		//MODIFICADORES
		
		/**
		 * Setter del ID del pase
		 * @param id Identificador del pase
		 * @author Developers
		 */
		
		public void setID(int id)
		{
			this.id = id; 
		}
		
		/**
		 * Setter de la fecha de inicio del pase
		 * @param fecha Fecha y hora del inicio del pase
		 * @author Developers
		 */
		
		public void setFechaInicio(LocalDateTime fechaInicio)
		{
			this.fechaInicio = fechaInicio; 
		}
		
		/**
		 * Setter de la fecha final del pase
		 * @param fecha Fecha y hora del fin del pase
		 * @author Developers
		 */
		
		public void setFechaFinal(LocalDateTime fechaFinal)
		{
			this.fechaFinal = fechaFinal; 
		}
	}
}
