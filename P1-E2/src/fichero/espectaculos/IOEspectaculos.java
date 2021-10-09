package fichero.espectaculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import espectaculo.EspectaculoMultiple;
import espectaculo.EspectaculoPuntual;
import espectaculo.EspectaculoTemporada;


public class IOEspectaculos {

	
	public void EspectaculoPuntToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, LocalDateTime horaFecha, ArrayList<Integer> ids)
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
	
	public void EspectaculoMultToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, ArrayList<LocalDateTime> pases, ArrayList<Integer> ids)
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
	    		for(LocalDateTime d : pases) {
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
	
	public void EspectaculoTempToFich(String title, String categoria, String descripcion, int localidades_venta, int localidades_vendidas, LocalDateTime inicio, LocalDateTime fin, ArrayList<LocalDateTime>fechas, ArrayList<Integer> ids)
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
	    		for(LocalDateTime f : fechas) {
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
		    	espp.setHoraFecha(LocalDateTime.parse(data[5]));
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
	        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
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
			    		dates.add(LocalDateTime.parse(data2[i]));
			    	} 

		    	}
		    	else {
		    		espm.setPases(new ArrayList<LocalDateTime>());
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
		    	dates = new ArrayList<LocalDateTime>();
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
	        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
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
			    		dates.add(LocalDateTime.parse(data2[i]));
			    	} 

		    	}
		    	else {
		    		espt.setFechas(new ArrayList<LocalDateTime>());
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
		    	dates = new ArrayList<LocalDateTime>();
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
			et.EspectaculoTempToFich(et.getTitulo(), et.getCategoria(), et.getDescripcion(), et.getLocalidadesVenta(), et.getLocalidadesVendidas(), et.getFechaInicio(),et.getFechaFinal(),et.getFechas(), et.getCritica());
		}
	}
	
	public void printAllEspectaculosPunt()
	{
		ArrayList<EspectaculoPuntual> c = new ArrayList<EspectaculoPuntual>(); 
		c = fichEspectaculoPuntToVec(c);
		int aux = 1;
		for(EspectaculoPuntual ep : c)
		{
			System.out.println("ESPECTACULO "+ aux);
			System.out.println("-------------------");
			System.out.println("Titulo: " + ep.getTitulo());
			System.out.println("Fecha: " + ep.getHoraFecha());
			System.out.println("Descripcion: " + ep.getDescripcion());
			System.out.println("Localidades disponibles" ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 
			System.out.println("-------------------");
			aux++;
		}
	}
	
	public void printAllEspectaculosMult()
	{
		ArrayList<EspectaculoMultiple> c = new ArrayList<EspectaculoMultiple>(); 
		c = fichEspectaculoMultToVec(c);
		int aux = 1;
		for(EspectaculoMultiple em : c)
		{
			System.out.println("ESPECTACULO "+ aux);
			System.out.println("-------------------");
			System.out.println("Titulo: " + em.getTitulo());
			
			for(int i = 0; i < em.getPases().size(); i++) 
			{
				System.out.println("Fecha "+ (i+1) + "º :"  + em.getPases().get(i));
			}

			System.out.println("Descripcion: " + em.getDescripcion());
			System.out.println("Localidades disponibles" ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 
			System.out.println("-------------------");
			aux++;
		}
	}
	
	public void printAllEspectaculosTemp()
	{
		ArrayList<EspectaculoTemporada> c = new ArrayList<EspectaculoTemporada>(); 
		c = fichEspectaculoTempToVec(c);
		int aux = 1;
		for(EspectaculoTemporada et: c)
		{
			System.out.println("ESPECTACULO "+ aux);
			System.out.println("-------------------");
			System.out.println("Titulo: " + et.getTitulo());
			System.out.println("Titulo: " + et.getFechaInicio());

			for(int i = 0; i < et.getFechas().size(); i++) 
			{
				System.out.println("Fecha "+ (i+1) + "º :"  + et.getFechas().get(i));
			}
			System.out.println("Titulo: " + et.getFechaFinal());
			System.out.println("Descripcion: " + et.getDescripcion());
			System.out.println("Localidades disponibles: " ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 
			System.out.println("-------------------");
			aux++;
		}
	}
	
	public boolean existEspectaculoPunt(String title)
	{
		ArrayList<EspectaculoPuntual> v = new ArrayList<EspectaculoPuntual>();
		fichEspectaculoPuntToVec(v);
		for(EspectaculoPuntual ep : v) {
			if(ep.getTitulo().equals(title));
				return true;
		}
		return false;
	}
	
	public boolean existEspectaculoTemp(String title)
	{
		ArrayList<EspectaculoTemporada> v = new ArrayList<EspectaculoTemporada>();
		fichEspectaculoTempToVec(v);
		for(EspectaculoTemporada et : v) {
			if(et.getTitulo().equals(title));
				return true;
		}
		return false;
	}
	
	public boolean existEspectaculoMult(String title)
	{
		ArrayList<EspectaculoMultiple> v = new ArrayList<EspectaculoMultiple>();
		fichEspectaculoMultToVec(v);
		for(EspectaculoMultiple em : v) {
			if(em.getTitulo().equals(title));
				return true;
		}
		return false;
	}
	
	
	public void buscarEspectaculosPunt(String title)
	{
		ArrayList<EspectaculoPuntual> c = new ArrayList<EspectaculoPuntual>(); 
		c = fichEspectaculoPuntToVec(c);

		if(existEspectaculoPunt(title)==true)
		{
			for(int i=0; i<c.size(); i++)
			{
				if(c.get(i).getTitulo().equals(title))
				{//TODO: Se puede mejorar sin el for??
					System.out.println((i+1) + "º ESPECTACULO PUNTUAL ");
					System.out.println("-------------------");
					System.out.println("Titulo: " + c.get(i).getTitulo());
					System.out.println("Fecha: " + c.get(i).getHoraFecha());
					System.out.println("Descripcion: " + c.get(i).getDescripcion());
					System.out.println("Localidades disponibles" ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 

				}
			}
		}
		else
		{
			System.err.println("El usuario no estÃ¡ registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	public void buscarEspectaculosMult(String title)
	{
		ArrayList<EspectaculoMultiple> c = new ArrayList<EspectaculoMultiple>(); 
		c = fichEspectaculoMultToVec(c);

		if(existEspectaculoMult(title)==true)
		{
			for(int i=0; i<c.size(); i++)
			{
				if(c.get(i).getTitulo().equals(title))
				{//TODO: Se puede mejorar sin el for??
					System.out.println((i+1) + "º ESPECTACULO MULTIPLE ");
					System.out.println("-------------------");
					System.out.println("Titulo: " + c.get(i).getTitulo());
					for(int j = 0; j < c.get(i).getPases().size(); j++) 
					{
						System.out.println("Fecha "+ (j+1) + "º :"  + c.get(j).getPases());
					}
					System.out.println("Descripcion: " + c.get(i).getDescripcion());
					System.out.println("Localidades disponibles" ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 

				}
			}
		}
		else
		{
			System.err.println("El usuario no estÃ¡ registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	public void buscarEspectaculosTemp(String title)
	{
		ArrayList<EspectaculoTemporada> c = new ArrayList<EspectaculoTemporada>(); 
		c = fichEspectaculoTempToVec(c);

		if(existEspectaculoTemp(title)==true)
		{
			for(int i=0; i<c.size(); i++)
			{
				if(c.get(i).getTitulo().equals(title))
				{//TODO: Se puede mejorar sin el for??
					System.out.println((i+1) + "º ESPECTACULO DE TEMPORADA ");
					System.out.println("-------------------");
					System.out.println("Titulo: " + c.get(i).getTitulo());
					System.out.println("Descripcion: " + c.get(i).getDescripcion());
					System.out.println("Titulo: " + c.get(i).getFechaInicio());

					for(int j = 0; j < c.get(i).getFechas().size(); j++) 
					{
						System.out.println("Fecha "+ (j+1) + "º :"  + c.get(j).getFechas());
					}
					System.out.println("Titulo: " + c.get(i).getFechaFinal());
					System.out.println("Localidades disponibles" ); //TODO:.LocalidadesDisponibles() CREARLA, SEGUN TITULO 

				}
			}
		}
		else
		{
			System.err.println("El usuario no estÃ¡ registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	/*public void updateEspectaculo(String title) {
		this.imprimirDatosUser(mail);
		this.borrarUser(mail);
		Espectador e = this.proveerDatos();
		this.comprobarUserExist(e.getMail());
		this.RegisterUserToFich(e.getName(), e.getUsername(), e.getMail(), e.getPasswd());
	}
	*/
	
	//TODO: Comprobar que los IDs del vector Criticas existan y no se repitan
	//TODO: Buscar por categorias SE HACE DESDE EL MENU
	//TODO: Update Datos
	//TODO: Contabilizar las entradas disponibles para un espectaculo
	//TODO: Contabilizar entradas vendidas para un especaculo
	//TODO: Publicar critica de un espectaculo pasado y comprobar que NO SE HAGAN CRITICAS DE ESPECTACULOS FUTUROS
	//TODO: 
}
