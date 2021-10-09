package fichero.espectaculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import critica.Critica;
import espectaculo.EspectaculoMultiple;
import espectaculo.EspectaculoPuntual;
import espectaculo.EspectaculoTemporada;


public class IOEspectaculos {

	
	public void EspectaculoPuntToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, LocalDate horaFecha, ArrayList<Integer> ids)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.print(title+"//"+categoria+"//" +descripcion+"//"+localidades_venta+ "//" +localidades_vendidas+ "//" +horaFecha+ "//");
	    	if(ids != null) {
	    		for(int s : ids) {
		    		pw.print(s+"::");
		    	}
		    	pw.print("//");
	    	}
	    	else {
	    		pw.print("void//");
	    	}
	    	pw.println("");
	    }catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	           try {
	           if (fichero != null)
	              fichero.close();
	           
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }	
	    }
	
	public void EspectaculoMultToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, ArrayList<LocalDate> pases, ArrayList<Integer> ids)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.print(title+"//"+categoria+"//" +descripcion+"//"+localidades_venta+ "//" +localidades_vendidas+ "//");
	    	if(pases != null) {
	    		for(LocalDate d : pases) {
		    		pw.print(d+"::");
		    	}
		    	pw.print("//");
	    	}
	    	if(ids != null) {
	    		for(int s : ids) {
		    		pw.print(s+"::");
		    	}
		    	pw.print("//");
	    	}
	    	else {
	    		pw.print("void//");
	    	}
	    	pw.println("");
	    }catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	           try {
	           if (fichero != null)
	              fichero.close();
	           
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }	
	    }
	
	public void EspectaculoTempToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, LocalDate inicio, LocalDate fin, ArrayList<LocalDate>fechas, ArrayList<Integer> ids)
	{		
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileWriter fichero = null;
	    PrintWriter pw = null; 
	    try
	    {	
	    	fichero= new FileWriter(rutaFichero, true); 
	    	pw = new PrintWriter(fichero); 
	    	pw.print(title+"//"+categoria+"//" +descripcion+"//"+localidades_venta+ "//" +localidades_vendidas+ "//" +inicio+ "//" +fin+ "//");
	    	if(fechas != null) {
	    		for(LocalDate f : fechas) {
		    		pw.print(f+"::");
		    	}
		    	pw.print("//");
	    	}
	    	if(ids != null) {
	    		for(int s : ids) {
		    		pw.print(s+"::");
		    	}
		    	pw.print("//");
	    	}
	    	else {
	    		pw.print("void//");
	    	}
	    	pw.println("");
	    }catch (Exception e) {
	       e.printStackTrace();
	    } finally {
	           try {
	           if (fichero != null)
	              fichero.close();
	           
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }	
	    }
	
	public ArrayList<EspectaculoPuntual> fichEspectaculoPuntToVec(ArrayList<EspectaculoPuntual> v)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileReader fr = null;
		BufferedReader br = null;
		EspectaculoPuntual espp = new EspectaculoPuntual(); 
				
		try {

	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	       
	        String linea; 
	        ArrayList<Integer> ids = new ArrayList<Integer>(); 
        	while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
		    	espp.setTitulo(data[0]);
		    	espp.setCategoria(data[1]);
		    	espp.setDescripcion(data[2]);
		    	espp.setLocalidadesVenta(Integer.parseInt(data[3]));
		    	espp.setLocalidadesVendidas(Integer.parseInt(data[4]));
		    	espp.setHoraFecha(LocalDate.parse(data[5]));
		    	//TODO: Posible fallo a la hora de guardar IDs. Comprobar
		    	if(!("void".equals(data[6]))) {
		    		String[] data2 = data[6].split("::");
			    	for(int i=1; i<data2.length; i++) 
			    	{
			    		ids.add(Integer.parseInt(data2[i]));
			    	} 

		    	}
		    	else {
		    		espp.setCritica(new ArrayList<Integer>());
		    	}
		    	v.add(espp); 
		    	espp = new EspectaculoPuntual();
		    	ids = new ArrayList<Integer>(); 
        	}
	        
		}catch(Exception e){
	         e.printStackTrace();
	      }finally{

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

	public ArrayList<EspectaculoMultiple> fichEspectaculoMultToVec(ArrayList<EspectaculoMultiple> v)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileReader fr = null;
		BufferedReader br = null;
		EspectaculoMultiple espm = new EspectaculoMultiple(); 
				
		try {

	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	       
	        String linea; 
	        ArrayList<Integer> ids = new ArrayList<Integer>();
	        ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
        	while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
		    	espm.setTitulo(data[0]);
		    	espm.setCategoria(data[1]);
		    	espm.setDescripcion(data[2]);
		    	espm.setLocalidadesVenta(Integer.parseInt(data[3]));
		    	espm.setLocalidadesVendidas(Integer.parseInt(data[4]));		    	
		    	//TODO: Posible fallo a la hora de guardar los pases. Comprobar
		    	if(!("void".equals(data[5]))) {
		    		String[] data2 = data[5].split("::");
			    	for(int i=1; i<data2.length; i++) 
			    	{
			    		dates.add(LocalDate.parse(data2[i]));
			    	} 

		    	}
		    	else {
		    		espm.setPases(new ArrayList<LocalDate>());
		    	}
		    	//TODO: Posible fallo a la hora de guardar IDs. Comprobar
		    	if(!("void".equals(data[6]))) {
		    		String[] data3 = data[6].split("::");
			    	for(int i=1; i<data3.length; i++) 
			    	{
			    		ids.add(Integer.parseInt(data3[i]));
			    	} 

		    	}
		    	else {
		    		espm.setCritica(new ArrayList<Integer>());
		    	}
		    	v.add(espm); 
		    	espm = new EspectaculoMultiple();
		    	ids = new ArrayList<Integer>(); 
		    	dates = new ArrayList<LocalDate>();
        	}
	        
		}catch(Exception e){
	         e.printStackTrace();
	      }finally{

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
	
	public ArrayList<EspectaculoTemporada> fichEspectaculoTempToVec(ArrayList<EspectaculoTemporada> v)
	{
		String rutaAbsoluta = new File("").getAbsolutePath();
		String rutaFichero = rutaAbsoluta + "/espectaculos.txt";
		FileReader fr = null;
		BufferedReader br = null;
		EspectaculoTemporada espt = new EspectaculoTemporada(); 
				
		try {

	        fr = new FileReader (rutaFichero);
	        br = new BufferedReader(fr);
	       
	        String linea; 
	        ArrayList<Integer> ids = new ArrayList<Integer>();
	        ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
        	while ((linea = br.readLine()) != null) {
        	    String[] data = linea.split("//");
		    	espt.setTitulo(data[0]);
		    	espt.setCategoria(data[1]);
		    	espt.setDescripcion(data[2]);
		    	espt.setLocalidadesVenta(Integer.parseInt(data[3]));
		    	espt.setLocalidadesVendidas(Integer.parseInt(data[4]));	
		    	espt.setLocalidadesVendidas(Integer.parseInt(data[5]));
		    	espt.setLocalidadesVendidas(Integer.parseInt(data[6]));
		    	//TODO: Posible fallo a la hora de guardar los pases. Comprobar
		    	if(!("void".equals(data[7]))) {
		    		String[] data2 = data[7].split("::");
			    	for(int i=1; i<data2.length; i++) 
			    	{
			    		dates.add(LocalDate.parse(data2[i]));
			    	} 

		    	}
		    	else {
		    		espt.setFechas(new ArrayList<LocalDate>());
		    	}
		    	//TODO: Posible fallo a la hora de guardar IDs. Comprobar
		    	if(!("void".equals(data[8]))) {
		    		String[] data3 = data[8].split("::");
			    	for(int i=1; i<data3.length; i++) 
			    	{
			    		ids.add(Integer.parseInt(data3[i]));
			    	} 

		    	}
		    	else {
		    		espt.setCritica(new ArrayList<Integer>());
		    	}
		    	v.add(espt); 
		    	espt = new EspectaculoTemporada();
		    	ids = new ArrayList<Integer>(); 
		    	dates = new ArrayList<LocalDate>();
        	}
	        
		}catch(Exception e){
	         e.printStackTrace();
	      }finally{

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
	
	public boolean comprobarEspectaculoPuntExists(String title)
	{
		ArrayList<EspectaculoPuntual> v = new ArrayList<EspectaculoPuntual>();
		fichEspectaculoPuntToVec(v);
		for(EspectaculoPuntual ep : v) {
			if(ep.getTitulo().equals(title))
				return true;
		}
		return false;
	}
	
	public boolean comprobarEspectaculoMultExists(String title)
	{
		ArrayList<EspectaculoMultiple> v = new ArrayList<EspectaculoMultiple>();
		fichEspectaculoMultToVec(v);
		for(EspectaculoMultiple em : v) {
			if(em.getTitulo().equals(title))
				return true;
		}
		return false;
	}
	
	public boolean comprobarEspectaculoTempExists(String title)
	{
		ArrayList<EspectaculoTemporada> v = new ArrayList<EspectaculoTemporada>();
		fichEspectaculoTempToVec(v);
		for(EspectaculoTemporada et : v) {
			if(et.getTitulo().equals(title))
				return true;
		}
		return false;
	}
	
	public void borrarEspectaculoPunt(EspectaculoPuntual ep1) {
		ArrayList<EspectaculoPuntual> v = new ArrayList<EspectaculoPuntual>();
		v = fichEspectaculoPuntToVec(v);
		
		for(EspectaculoPuntual ep : v) {
			if(ep1.equals(ep)) {
				v.remove(ep);
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
		for(EspectaculoPuntual ep : v) {
			ep.EspectaculoPuntToFich(ep.getTitulo(), ep.getCategoria(), ep.getDescripcion(), ep.getLocalidadesVenta(), ep.getLocalidadesVendidas(), ep.getHoraFecha(),ep.getCritica());
		}
	}
	
	public void borrarEspectaculoMult(EspectaculoMultiple em1) {
		ArrayList<EspectaculoMultiple> v = new ArrayList<EspectaculoMultiple>();
		v = fichEspectaculoMultToVec(v);
		
		for(EspectaculoMultiple em : v) {
			if(em1.equals(em)) {
				v.remove(em);
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
		for(EspectaculoMultiple em : v) {
			em.EspectaculoMultToFich(em.getTitulo(), em.getCategoria(), em.getDescripcion(), em.getLocalidadesVenta(), em.getLocalidadesVendidas(), em.getPases(),em.getCritica());
		}
	}
	
	public void borrarEspectaculoTemp(EspectaculoTemporada et1) {
		ArrayList<EspectaculoTemporada> v = new ArrayList<EspectaculoTemporada>();
		v = fichEspectaculoTempToVec(v);
		
		for(EspectaculoTemporada et : v) {
			if(et1.equals(et)) {
				v.remove(et);
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
		for(EspectaculoTemporada et : v) {
			et.EspectaculoMultToFich(et.getTitulo(), et.getCategoria(), et.getDescripcion(), et.getLocalidadesVenta(), et.getLocalidadesVendidas(), et.getFechaInicio(),et.getFechaFinal(),et.getFechas(), et.getCritica());
		}
	}

	
	//TODO: Comprobar que los IDs del vector Criticas existan y no se repitan
	//TODO: PrintAll Espectaculos
	//TODO: Buscar por titulos
	//TODO: Buscar por categorias
	//TODO: Update Datos
	//TODO: Contabilizar las entradas disponibles para un espectaculo
	//TODO: Contabilizar entradas vendidas para un especaculo
	//TODO: Publicar critica de un espectaculo pasado y comprobar que NO SE HAGAN CRITICAS DE ESPECTACULOS FUTUROS
	//TODO: 
}
