package fichero.credenciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import credenciales.Credenciales;

public class IOCredenciales {
	public void RegisterUserToFich(String email, String Passwd)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/credenciales.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.println(email+"//"+ Passwd); 
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
	
	public ArrayList<Credenciales> fichCredToVec(ArrayList<Credenciales> cred)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/credenciales.txt";
		FileReader fr = null;
		BufferedReader br = null;
		Credenciales c1 = new Credenciales(); 
		try {
			// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	        //lectura
	        String linea=""; 
	        while((linea=br.readLine())!=null)
	        {
        	    String[] data = linea.split("//");
        	    for(String s : data) {
    	        	c1.setEmail(s);
    	        	c1.setPasswd(s); 
    	        	cred.add(c1); 
    	        	c1 = new Credenciales(); 
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
		boolean exists = false; 
		ArrayList<Credenciales> v = new ArrayList<Credenciales>();
		v = fichCredToVec(v);
			for(int i=0; i<v.size(); i++)
			{
				if(v.get(i).getEmail().equals(User))
					exists=true;
			}
			return exists; 
	}
	
	public boolean comprobarPasswd(String email, String Passwd)
	{
		ArrayList<Credenciales> v = new ArrayList<Credenciales>();
		v = fichCredToVec(v);
		for(Credenciales c : v) {
			if(c.getEmail().equals(email)) {
				if(c.getPasswd().equals(Passwd))
					return true;
			}
		}
		return false;
	}
}
