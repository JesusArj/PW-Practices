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
import espectador.Espectador;

/*
 *
 * Clase que implementa las funcionalidades relativas 
 * a la lectura y escritura de criticas en el fichero 
 * correspondiente
 * @author 
 *
 */

public class IOCriticas {


/**
 * Funcion que añade una critica al fichero de critica,
 * con la información respectiva.
 * @param title Titulo de la critica
 * @param puntuacion Puntuacion dada
 * @param resena Rese�a
 * @param username Nombre de usuario del autor de la crítica
 * @param like Numero de likes dados a la crítica
 * @param dislike Numero de dislike dados a la crítica
 *
 */
	public void criticaToFich(String title, String puntuacion, String resena, String username, int like, int dislike, int id, ArrayList<String> votantes)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/criticas.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.print(title+"//"+puntuacion +"//" + resena+"//"+ username + "//" + like +"//" + dislike +"//"+ id);
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
 * Metodo que vuelca el contenido del fichero de críticas en
 * un ArrayList de críticas para su posterior tratamiento.
 * @param v Array List de Críticas
 *
 */

	public ArrayList<Critica> fichToVec(ArrayList<Critica> v)
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
		    	c1.setUsername(data[5]);
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
 * Funcion que comprueba que el título de crítica exista
 * en el fichero plano de críticas.
 * @param title Titulo de la critica
 *
 */

	public boolean comprobarCriticaExist(String title)
	{
		ArrayList<Critica> v = new ArrayList<Critica>();
		fichToVec(v);
		for(Critica c : v) {
			if(c.getTitle().equals(title))
				return true;
		}
		return false;
	}

/**
 * Funcion que elimina una crítica del fichero de críticas.
 * @param title Titulo de la crítica
 *
 */

	public void borrarCritica(Critica c1) {
		ArrayList<Critica> v = new ArrayList<Critica>();
		v = fichToVec(v);
		
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
			c.criticaToFich(c.getTitle(), c.getPuntuacion(), c.getResena(), c.getUsername(), c.getLike(), c.getDislike());
		}
	}
	
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
	 
	public boolean existId(int id)
	{
		ArrayList<Critica> v = new ArrayList<Critica>();
		fichToVec(v);
		for(Critica e : v) {
			if(e.getId()==id)
				return true;
		}
		return false;
	}

}