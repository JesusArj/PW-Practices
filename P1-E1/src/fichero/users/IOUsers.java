//TODO: En el constructor hay que inicializar un vector de espectadores que vuelque todos los datos del fichero
//en dicho vector. Luego se obtendrá el tamaño del vector para poder seguir escribiendo en el fichero de datos.

package fichero.users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import espectador.*;

public class IOUsers 
{
	
	//funcion que añade un usuario al fichero de usuarios
	public void userToFich(String name, String username, String mail)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/usuarios.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.println(name+"\n"+username+"\n"+mail); 
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
	
	public ArrayList<Espectador> fichToVec(ArrayList<Espectador> v)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/usuarios.txt";
		FileReader fr = null;
		BufferedReader br = null;
		 Espectador e1 = new Espectador();
		
		try {
			
			// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	        //lectura
	        String linea=""; 
	        int aux=0; 
	        while((linea=br.readLine())!=null)
	        { 
	        	if((aux%3)==0)
	        	{
	        		e1.setName(linea);
	        	}
	        	else if((aux%3)==1)
	        	{
	        		e1.setMail(linea); 
	        	}
	        	else if((aux%3)==2)
	        	{
	        		e1.setUsername(linea);
	        		v.add(e1);
	        		e1 = new Espectador();
	        }
	        	aux++; 
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
	
	public boolean comprobarUserExist(String Mail)
	{
		ArrayList<Espectador> v = new ArrayList<Espectador>();
		fichToVec(v);
		for(Espectador e : v) {
			if(e.getMail().equals(Mail))
				return true;
		}
		return false;
	}
}



