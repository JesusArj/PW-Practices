package fichero.criticas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import critica.Critica;
import fichero.users.IOUsers;

/*
 *
 * Clase que implementa las funcionalidades relativas 
 * a la lectura y escritura de criticas en el fichero 
 * correspondiente
 * @author 
 *
 */

public class IOCriticas extends IOUsers {
	
/**
 * Funcion que anade una critica al fichero de critica,
 * con la informacion respectiva.
 * @param title Titulo de la critica
 * @param puntuacion Puntuacion dada
 * @param resena Resena
 * @param username Nombre de usuario del autor de la critica
 * @param like Numero de likes dados a la critica
 * @param dislike Numero de dislike dados a la critica
 *
 */
	public void criticaToFich(String title, String puntuacion, String resena, String mail, int like, int dislike, int id, ArrayList<String> votantes)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/criticas.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.print(title+"//"+puntuacion +"//" + resena+"//"+ mail + "//" + like +"//" + dislike +"//"+ id);
	    	for(String s : votantes) {
	    		pw.print("((" + s);
	    	}
	    }catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	           try {
	        	   // Aprovechamos el finally para asegurarnos que se cierra el fichero.
	           if (fichero != null)
	              fichero.close();
	           
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }	
	    }
	
/**
 * Metodo que vuelca el contenido del fichero de criticas en
 * un ArrayList de criticas para su posterior tratamiento.
 * @param v Array List de criticas
 *
 */

	public ArrayList<Critica> fichCriticaToVec(ArrayList<Critica> v)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/criticas.txt";
		FileReader fr = null;
		BufferedReader br = null;
		Critica c1 = new Critica(); 
				
		try {
			
			// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	        //lectura
	        String linea; 
	        ArrayList<String> votantes = new ArrayList<String>(); 
        	while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
		    	c1.settitle(data[0]);
		    	c1.setPuntuacion(data[1]);
		    	c1.setResena(data[2]);
		    	c1.setLike(Integer.parseInt(data[3]));
		    	c1.setDislike(Integer.parseInt(data[4]));
		    	c1.setMail(data[5]);
		    	c1.setId(Integer.parseInt(data[6]));
		    	String[] data2 = data[7].split("((");
		    	for(int i=0; i<data2.length; i++) 
		    	{
		    		votantes.add(data2[i]);
		    	} 
		    	c1.setVotantes(votantes);
		    	v.add(c1); 
		    	c1 = new Critica();
		    	votantes = new ArrayList<String>(); 
		    
        	}
	        
		}catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
		return v; 
	
	}
	
/**
 * Funcion que comprueba que el titulo de critica exista
 * en el fichero plano de criticas.
 * @param title Titulo de la critica
 *
 */

	public boolean comprobarCriticaExist(String title)
	{
		ArrayList<Critica> v = new ArrayList<Critica>();
		fichCriticaToVec(v);
		for(Critica c : v) {
			if(c.getTitle().equals(title))
				return true;
		}
		return false;
	}

/**
 * Funcion que elimina una critica del fichero de criticas.
 * @param title Titulo de la critica
 *
 */

	public void borrarCritica(Critica c1) {
		ArrayList<Critica> v = new ArrayList<Critica>();
		v = fichCriticaToVec(v);
		
		for(Critica c : v) {
			if(c1.equals(c)) {
				v.remove(c);
			}
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("criticas.txt"));
			bw.write("");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		for(Critica c : v) {
			c.criticaToFich(c.getTitle(), c.getPuntuacion(), c.getResena(), c.getMail(), c.getLike(), c.getDislike(), c.getId(), c.getVotantes());
		}
	}

	/**
	 * Funcion que genera un identificador unico para cada critica,
	 * con valor [1 - 99999].
	 * @return id Identificador de la critica
	 */
	
	public int generarID()
	{
		Random r = new Random();
		int id = r.nextInt(99999)+1; 
		if (existId(id) == true)
		{
			generarID();
		}
		return id;
	}

	/**
	 * Funcion que comprueba la existencia del identificador de critica
	 * en el fichero de criticas
	 * @param id Identificador a comprobar
	 * @return true en caso de que se repitan IDs, falso en caso contrario
	 */
	
	public boolean existId(int id)
	{
		ArrayList<Critica> v = new ArrayList<Critica>();
		fichCriticaToVec(v);
		for(Critica e : v) {
			if(e.getId()==id)
				return true;
		}
		return false;
	}
	
	/**
	 * Funcion que imprime por pantalla todas las criticas
	 * almacenadas en el fichero de criticas
	 * 
	 */
	
	public void printAll()
	{
		ArrayList<Critica> c = new ArrayList<Critica>(); 
		c = fichCriticaToVec(c);
		for(int i=0; i<c.size(); i++)
		{
			System.out.println("CRITICA "+ i+1);
			System.out.println("-------------------");
			System.out.println("Titulo: " + c.get(i).getTitle());
			System.out.println("Resena: " + c.get(i).getResena());
		}
	}
	
	/**
	 * Funcion que muestra por pantalla las criticas escritas por
	 * un usuario concreto
	 */
	
	public void buscarCriticas(String mail)
	{
		ArrayList<Critica> c = new ArrayList<Critica>(); 
		c = fichCriticaToVec(c);
		int count = 1; 
		if(comprobarUserExist(mail)==true)
		{
			for(int i=0; i<c.size(); i++)
			{
				if(c.get(i).getMail().equals(mail))
				{
					System.out.println("CRITICA/s DEL USUARIO CON MAIL: "+ mail);
					System.out.println("-------------------");
					System.out.println("CRITICA "+ count);
					System.out.println("Titulo: " + c.get(i).getTitle());
					System.out.println("Resena: " + c.get(i).getResena());
					System.out.println("-------------------");

					count++; 
				}
			}
		}
		else
		{
			System.err.println("El usuario no está registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	/**
	 * Funcion que busca una critica concreta a traves de su identificador
	 * en el fichero de criticas
	 * @param id identificador de la critica
	 * @return cr critica concreta en caso de encontrarla
	 */
	
	public Critica buscarCritica(int id) {
		Critica c = new Critica();
		ArrayList<Critica> v = new ArrayList<Critica>();
		v = this.fichCriticaToVec(v);
		for(Critica cr : v) {
			if(cr.getId() == id)
				return cr;
		}
		return c;
	}
	
	/**
	/**
	 * Funcion que busca una critica concreta a traves del mail
	 * de su autor y su titulo.
	 * @param mail del autor de la critica
	 * @param titulo de la critica
	 * @return cr critica concreta en caso de encontrarla
	 */
	
	public Critica buscarCritica(String mail, String title) {
		Critica c = new Critica();
		ArrayList<Critica> v = new ArrayList<Critica>();
		v = this.fichCriticaToVec(v);
		for(Critica cr : v) {
			if(cr.getMail().equals(mail) && cr.getTitle().equals(title) )
				return cr;
		}
		return c;
	}
	
	/**
	 * Funcion que borra una critica buscando por el mail de
	 * su autor y su id
	 * @param mail Mail del autor de la critica
	 * @param id Identificador de la critica
	 */
	
	public void borrarCritica(int id, String mail) {
		ArrayList<Critica> v = new ArrayList<Critica>();
		v = this.fichCriticaToVec(v);
		for(Critica c : v) {
			if(c.getMail().equals(mail) && c.getId() == id ) {
				v.remove(c);
			}
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("criticas.txt"));
			bw.write("");
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
		for(Critica c : v) {
			c.criticaToFich(c.getTitle(), c.getPuntuacion(), c.getResena(), c.getMail(), c.getLike(), c.getDislike(), c.getId(), c.getVotantes());
		}
	}
	
	/**
	 * Funcion que aumenta en +1 los likes de una critica concreta
	 * @param mail Mail del autor de la critica
	 * @param id Identificador a comprobar
	 */
	
	
	public void votarCriticaPos(String mail, int id) {
		Critica c = new Critica();
		c = c.buscarCritica(id);
		if(c.getMail().equals(mail)) {
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else {
			for(String correos : c.getVotantes()) {
				if(correos.equals(mail)) {
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}
		Critica cAux = c;
		cAux.addLike();
		this.borrarCritica(c);
		this.criticaToFich(cAux.getTitle(), cAux.getPuntuacion(), cAux.getResena(), cAux.getMail(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
		}
	}
	
	/**
	 * Funcion que aumenta en +1 los likes de una critica concreta
	 * @param mail Mail del autor de la critica
	 * @param c Critica concreta
	 */
	
	
	public void votarCriticaPos(String mail, Critica c) {
		if(c.getMail().equals(mail)) {
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else {
			for(String correos : c.getVotantes()) {
				if(correos.equals(mail)) {
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}
		Critica cAux = c;
		cAux.addLike();
		this.borrarCritica(c);
		this.criticaToFich(cAux.getTitle(), cAux.getPuntuacion(), cAux.getResena(), cAux.getMail(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
		}
	}
	
	/**
	 * Funcion que aumenta en +1 los dislikes de una critica concreta
	 * @param mail Mail del autor de la critica
	 * @param id Identificador a comprobar
	 */
	
	public void votarCriticaNeg(String mail, int id) {
		Critica c = new Critica();
		c = c.buscarCritica(id);
		if(c.getMail().equals(mail)) {
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else {
			for(String correos : c.getVotantes()) {
				if(correos.equals(mail)) {
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}
		Critica cAux = c;
		cAux.addDislike();
		this.borrarCritica(c);
		this.criticaToFich(cAux.getTitle(), cAux.getPuntuacion(), cAux.getResena(), cAux.getMail(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
		}
	}
	
	/**
	 * Funcion que aumenta en +1 los dislikes de una critica concreta
	 * @param mail Mail del autor de la critica
	 * @param c Critica concreta
	 */
	
	public void votarCriticaNeg(String mail, Critica c) {
		if(c.getMail().equals(mail)) {
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else {
			for(String correos : c.getVotantes()) {
				if(correos.equals(mail)) {
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}
		Critica cAux = c;
		cAux.addDislike();
		this.borrarCritica(c);
		this.criticaToFich(cAux.getTitle(), cAux.getPuntuacion(), cAux.getResena(), cAux.getMail(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
		}
	}
	
	
}