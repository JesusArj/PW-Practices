//TODO: En el constructor hay que inicializar un vector de espectadores que vuelque todos los datos del fichero
//en dicho vector. Luego se obtendr� el tama�o del vector para poder seguir escribiendo en el fichero de datos.

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
	
	//funcion que a�ade un usuario al fichero de usuarios
	public void RegisterUserToFich(String name, String username, String mail, String passwd)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/usuarios.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.println(name+"\t"+username+"\t"+mail+"\t"+passwd); 
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
	        while((linea=br.readLine())!=null) {
			String[] data = linea.split("\t");
        	    for(String s : data) {
					e1.setName(s);
					e1.setUsername(s);
    	        	e1.setMail(s);
    	        	e1.setPasswd(s); 
    	        	v.add(e1); 
    	        	e1 = new Espectador(); 
        	    }
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

	public boolean comprobarPasswd(String email, String Passwd)
	{
		ArrayList<Espectador> v = new ArrayList<Espectador>();
		v = fichToVec(v);
		for(Espectador c : v) {
			if(c.getMail().equals(email)) {
				if(c.getPasswd().equals(Passwd))
					return true;
			}
		}
		return false;
	}

	public Espectador buscarPorCorreo(String email){
		ArrayList<Espectador> v = new ArrayList<Espectador>();
		v = fichToVec(v);
		for(Espectador c : v) {
			if(c.getMail().equals(email)) {
				return c;
			}
		}
		return null;
	}
}



