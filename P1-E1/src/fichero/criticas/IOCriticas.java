package fichero.criticas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import critica.Critica;

public class IOCriticas {

	//funcion que a�ade un usuario al fichero de usuarios
	public void criticaToFich(String title, String puntuacion, String resena, String username, int like, int dislike)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/criticas.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.println(title+"//"+puntuacion +"//" + resena+"//"+ username + "//" + like +"//" + dislike); 
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
        	while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
		    	c1.settitle(data[0]);
		    	c1.setPuntuacion(data[1]);
		    	c1.setResena(data[2]);
		    	c1.setLike(Integer.parseInt(data[3]));
		    	c1.setDislike(Integer.parseInt(data[4]));
		    	c1.setUsername(data[5]);
		    	v.add(c1);
		    	c1 = new Critica();
		    
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
}

