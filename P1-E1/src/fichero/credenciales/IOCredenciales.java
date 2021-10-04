package fichero.credenciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import credenciales.Credenciales;

public class IOCredenciales {
	public void RegisterUserToFich(String username, String Passwd)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/credenciales.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.println(username+"//"+ Passwd); 
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
	
	public ArrayList<Credenciales> fichCredToVec()
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/credenciales.txt";
		FileReader fr = null;
		BufferedReader br = null;
		Credenciales c1 = new Credenciales(); 
		ArrayList<Credenciales> cred = new ArrayList<Credenciales>();
		
		try {
			// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	        //lectura
	        String linea; 
	        while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
        	    for (String s : data) {
        	    	c1.setUser(s);
        	    	c1.setPasswd(s);
        	    	cred.add(c1);
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
	               return cred;
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }	
		return cred;
	}
	
	public boolean comprobarUserExist(String User)
	{
		ArrayList<Credenciales> v = new ArrayList<Credenciales>();
		v = fichCredToVec();
		for(Credenciales c : v) {
			if(c.getUser()==User)
				return true;
		}
		return false;
	}
	
	public boolean comprobarPasswd(String User, String Passwd)
	{
		ArrayList<Credenciales> v = new ArrayList<Credenciales>();
		v = fichCredToVec();
		for(Credenciales c : v) {
			if(c.getUser()==User) {
				if(c.getPasswd()==Passwd)
					return true;
			}
		}
		return false;
	}
}
