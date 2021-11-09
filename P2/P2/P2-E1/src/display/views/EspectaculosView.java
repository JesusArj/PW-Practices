package display.views;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import business.DTOs.EspectaculoDTO;
import business.DTOs.EspectaculoTempDTO;
import business.DTOs.PasesDTO;
import business.DTOs.UserDTO;
import business.managers.CriticaManager;
import business.managers.EspectaculoManager;
import business.managers.UserManager;
import data.DAOs.EspectaculoDAO;
import data.DAOs.UserDAO;

public class EspectaculosView 
{
	private String mail;
	
	public String getMail() {
		return mail;
	}
	
	public EspectaculosView(String mail) {
		this.mail = mail;
	}
	
	public void EspectaculoMenu()
	{
		String opc = "1";
		
		while(opc.equals("1") || opc.equals("2") || opc.equals("3") || opc.equals("4"))
		{
			System.out.println("Bienvenido al menu de Espectaculos");
			System.out.println("Para ver los espectaculos registrados, pulse 1");
			System.out.println("Para ver los espectaculos con entradas disponibles, pulse 2");
			System.out.println("Para buscar un espectaculo por categoria, pulse 3");
			System.out.println("Para ver la informacion de un espectaculo concreto, pulse 4");
			System.out.println("Para salir del menu, pulse cualquier otra tecla");
			
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		        try 
		        {
					opc = reader.readLine();
				} 
		        catch (IOException e) 
		        {
					e.printStackTrace();
				}
		        
		        if("1".equals(opc)) 
		        {
		        	System.out.println("ESPECTACULOS REGISTRADOS: ");
		        	EspectaculoManager manager = new EspectaculoManager();
	        		int countFechas =1; 
		        	for(int i=0; i<manager.requestEPs().size(); i++ )
		        	{
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("TITULO: " + manager.requestEPs().get(i).getTitulo());
		        		System.out.println("DESCRIPCION: " + manager.requestEPs().get(i).getDescripcion());
		        		System.out.println("CATEGORIA: " + manager.requestEPs().get(i).getCategoria());
		        		System.out.println("FECHA " + manager.requestEPs().get(i).getHoraFechaString());
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        	for(int i=0; i<manager.requestEMs().size(); i++ )
		        	{
		        		countFechas=1;
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("TITULO: " + manager.requestEMs().get(i).getTitulo());
		        		System.out.println("DESCRIPCION: " + manager.requestEMs().get(i).getDescripcion());
		        		System.out.println("CATEGORIA: " + manager.requestEMs().get(i).getCategoria());
		        		System.out.println("FECHAS: ");
		        		for(int j=0; j<manager.requestEMs().get(i).getFechas().size(); j++)
		        		{
		        			System.out.println("Fecha " + Integer.toString(countFechas) + ":" + manager.requestEMs().get(i).getFechas().get(j).getFechaString() );
		        			countFechas++; 
		        		}
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        	for(int i=0; i<manager.requestETs().size(); i++ )
		        	{
		        		countFechas=1;
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("TITULO: " + manager.requestETs().get(i).getTitulo());
		        		System.out.println("DESCRIPCION: " + manager.requestETs().get(i).getDescripcion());
		        		System.out.println("CATEGORIA: " + manager.requestETs().get(i).getCategoria());
		        		System.out.println("FECHAS: ");
		        		for(int j=0; j<manager.requestETs().get(i).getPases().size(); j++)
		        		{
		        			System.out.println(); 
		        			System.out.println("FECHA " + Integer.toString(countFechas) + ":");
		        			System.out.println("Dï¿½A: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
		        			System.out.println("INICIO: " + manager.requestETs().get(i).getPases().get(j).getFechaInicioString());
		        			System.out.println("FINAL: " + manager.requestETs().get(i).getPases().get(j).getFechaFinalString());
		        			countFechas++; 
		        		}
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        }
		        
		        else if("2".equals(opc))
		        {
		        	System.out.println("ESPECTACULOS CON ENTRADAS DISPONIBLES: ");
		        	EspectaculoManager manager = new EspectaculoManager();
	        		int countFechas =1; 
		        	for(int i=0; i<manager.requestEPs().size(); i++ )
		        	{
		        		if(manager.requestEPs().get(i).getLocalidadesVenta() - manager.requestEPs().get(i).getLocalidadesVendidas() > 0)
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEPs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEPs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEPs().get(i).getCategoria());
			        		System.out.println("FECHA " + manager.requestEPs().get(i).getHoraFechaString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestEMs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestEMs().get(i).getLocalidadesVenta() - manager.requestEMs().get(i).getLocalidadesVendidas() > 0)
		        		{
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEMs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEMs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEMs().get(i).getCategoria());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestEMs().get(i).getFechas().size(); j++)
			        		{
			        			System.out.println("Fecha " + Integer.toString(countFechas) + ":" + manager.requestEMs().get(i).getFechas().get(j).getFechaString() );
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestETs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestETs().get(i).getLocalidadesVenta() - manager.requestETs().get(i).getLocalidadesVendidas() > 0)
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestETs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestETs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestETs().get(i).getCategoria());
			        		System.out.println("LOCALIDADES VENTA: " + manager.requestETs().get(i).getLocalidadesVenta());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestETs().get(i).getPases().size(); j++)
			        		{
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(countFechas) + ":");
			        			System.out.println("DIA: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + manager.requestETs().get(i).getPases().get(j).getFechaInicioString());
			        			System.out.println("FINAL: " + manager.requestETs().get(i).getPases().get(j).getFechaFinalString());
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        }
		        else if("3".equals(opc))
		        {
		        	String category = null;  
		        	System.out.println("Introduzca categorï¿½a: ");
		        	BufferedReader categoria = new BufferedReader(new InputStreamReader(System.in));
		        	try 
				    {
		        		category= categoria.readLine();
					} 
				    catch (IOException e) 
				    {
				    	e.printStackTrace();
				    }
		        	EspectaculoManager manager = new EspectaculoManager();
	        		int countFechas =1; 
		        	for(int i=0; i<manager.requestEPs().size(); i++ )
		        	{
		        		if(manager.requestEPs().get(i).getCategoria().equals(category))
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEPs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEPs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEPs().get(i).getCategoria());
			        		System.out.println("FECHA " + manager.requestEPs().get(i).getHoraFechaString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestEMs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestEMs().get(i).getCategoria().equals(category))
		        		{
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEMs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEMs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEMs().get(i).getCategoria());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestEMs().get(i).getFechas().size(); j++)
			        		{
			        			System.out.println("Fecha " + Integer.toString(countFechas) + ":" + manager.requestEMs().get(i).getFechas().get(j).getFechaString() );
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestETs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestETs().get(i).getCategoria().equals(category))
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestETs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestETs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestETs().get(i).getCategoria());
			        		System.out.println("LOCALIDADES VENTA: " + manager.requestETs().get(i).getLocalidadesVenta());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestETs().get(i).getPases().size(); j++)
			        		{
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(countFechas) + ":");
			        			System.out.println("Dï¿½A: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + manager.requestETs().get(i).getPases().get(j).getFechaInicioString());
			        			System.out.println("FINAL: " + manager.requestETs().get(i).getPases().get(j).getFechaFinalString());
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        	
		        	
		        	 
		        }
		        else if("4".equals(opc))
		        {
		        	String title = null;  
		        	System.out.println("Introduzca titulo del espectaculo: ");
		        	BufferedReader tituloreader = new BufferedReader(new InputStreamReader(System.in));
		        	try 
				    {
		        		title= tituloreader.readLine();
					} 
				    catch (IOException e) 
				    {
				    	e.printStackTrace();
				    }
		        	EspectaculoManager manager = new EspectaculoManager();
	        		int countFechas =1; 
		        	for(int i=0; i<manager.requestEPs().size(); i++ )
		        	{
		        		if(manager.requestEPs().get(i).getTitulo().equals(title))
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEPs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEPs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEPs().get(i).getCategoria());
			        		System.out.println("FECHA " + manager.requestEPs().get(i).getHoraFechaString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestEMs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestEMs().get(i).getTitulo().equals(title))
		        		{
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestEMs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestEMs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestEMs().get(i).getCategoria());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestEMs().get(i).getFechas().size(); j++)
			        		{
			        			System.out.println("Fecha " + Integer.toString(countFechas) + ":" + manager.requestEMs().get(i).getFechas().get(j).getFechaString() );
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<manager.requestETs().size(); i++ )
		        	{
		        		countFechas=1;
		        		if(manager.requestETs().get(i).getTitulo().equals(title))
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("TITULO: " + manager.requestETs().get(i).getTitulo());
			        		System.out.println("DESCRIPCION: " + manager.requestETs().get(i).getDescripcion());
			        		System.out.println("CATEGORIA: " + manager.requestETs().get(i).getCategoria());
			        		System.out.println("LOCALIDADES VENTA: " + manager.requestETs().get(i).getLocalidadesVenta());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<manager.requestETs().get(i).getPases().size(); j++)
			        		{
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(countFechas) + ":");
			        			System.out.println("Dï¿½A: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + manager.requestETs().get(i).getPases().get(j).getFechaInicioString());
			        			System.out.println("FINAL: " + manager.requestETs().get(i).getPases().get(j).getFechaFinalString());
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        }
		}

	}
	
	public void EspectaculoMenuAdmin(String mail)
	{
		
		EspectaculoManager manager = new EspectaculoManager(); 
		UserManager manageruser = new UserManager(); 
		for(int i =0; i < manageruser.requestByRol("admin").size(); i++)
		{
			if(manageruser.requestByRol("admin").get(i).getMail().equals(mail))
			{
				String opc = "1";
				while(opc.equals("1") || opc.equals("2") || opc.equals("3"))
				{
					System.out.println("MENU DE ADMINISTRADOR: Gestion de Espectaculos");
					System.out.println("Para dar de Alta un espectaculo, pulse 1");
					System.out.println("Para dar de baja de un espectaculo, pulse 2");
					System.out.println("Para actualizar la informacion sobre un espectaculo, pulse 3");
					System.out.println("Para salir del menu, pulse cualquier otra tecla");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				    try 
			        {
						opc = reader.readLine();
					} 
			        catch (IOException e) 
				    {
			        	e.printStackTrace();
					}
				        
					if("1".equals(opc))
					{
						String opcEspectaculo = "1"; 
						Scanner opcEspectaculo_reader = new Scanner(System.in); 
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("DAR DE ALTA ESPECTACULO");
							System.out.println("Si quiere crear un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere crear un espectaculo puntual, pulse 2");
							System.out.println("Si quiere crear un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = opcEspectaculo_reader.nextLine(); 
							if("1".equals(opcEspectaculo))
							{
								Scanner tituloReader, categoriaReader,descripcionReader,localidadesVentaReader,localidadesVendidasReader, fechaInicioReader, diaSemanaReader, fechaFinalReader, decisionReader; 
								String titulo, descripcion, categoria, diaSemana; 
								LocalDateTime fechaInicio, fechaFinal;
								int localidadesVenta, localidadesVendidas;  
								Boolean decisionPases = true;
								ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
								//crear espectaculo temporal
								
								EspectaculoManager managerPunt = new EspectaculoManager();
								int id = managerPunt.generarIDPunt();
								System.out.println("Introduce el titulo.");
								tituloReader = new Scanner(System.in); 
								titulo = tituloReader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoriaReader = new Scanner(System.in); 
								categoria = categoriaReader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcionReader =  new Scanner(System.in); 
								descripcion = descripcionReader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVentaReader = new Scanner(System.in); 
								localidadesVenta = localidadesVentaReader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidasReader = new Scanner(System.in); 
								localidadesVendidas = localidadesVentaReader.nextInt();
												
								manager.createEspectaculoTemp(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas);
								
								
								do
								{
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
									fechaInicioReader = new Scanner(System.in); 
									String aux = fechaInicioReader.nextLine();
									//conversion string to localdatetime
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fechaInicio = LocalDateTime.parse(aux, formatter);
									
									int idP = managerPunt.generarIDPases();
									System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm)");
									fechaFinalReader = new Scanner(System.in); 
									aux = fechaFinalReader.nextLine();
									//conversion string to localdatetime
									fechaFinal = LocalDateTime.parse(aux, formatter);
									System.out.println("Introduce dia de la Semana.");
									diaSemanaReader =  new Scanner(System.in); 
									diaSemana = diaSemanaReader.nextLine(); 
									System.out.println("Desea introducir mas pases? (y/n)");
									decisionReader =  new Scanner(System.in); 
									aux = decisionReader.nextLine(); 
									while(true)
									{
										if(aux.equals("n") || aux.equals("N"))
										{
											decisionPases = false; 
											break; 
										}
										else if (aux.equals("y") || aux.equals("Y"))
										{
											decisionPases = true; 
											break; 
										}
										else
										{
											System.out.println("Desea introducir mas pases? (y/n)");
											aux = decisionReader.nextLine(); 
										}
									}
									manager.createPase(idP,fechaInicio, diaSemana, fechaFinal, id); 

									listPases.add(managerPunt.requestPase(id)); 
								}while(decisionPases==true); 
								
								tituloReader.close(); 
								categoriaReader.close(); 
								descripcionReader.close(); 
								localidadesVentaReader.close(); 
								localidadesVendidasReader.close();
								fechaInicioReader.close();
								fechaFinalReader.close();
								diaSemanaReader.close();
								decisionReader.close();

							}
							if("2".equals(opcEspectaculo))
							{
								Scanner tituloReader, categoriaReader,descripcionReader,localidadesVentaReader,localidadesVendidasReader,fechaReader; 
								String titulo, descripcion, categoria; 
								LocalDateTime fecha;
								int localidadesVenta, localidadesVendidas; 
	
								//crear espectaculo temporal
								
								EspectaculoManager managerPunt = new EspectaculoManager();
								int id = managerPunt.generarIDPunt();
								System.out.println("Introduce el titulo.");
								tituloReader = new Scanner(System.in); 
								titulo = tituloReader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoriaReader = new Scanner(System.in); 
								categoria = categoriaReader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcionReader =  new Scanner(System.in); 
								descripcion = descripcionReader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVentaReader = new Scanner(System.in); 
								localidadesVenta = localidadesVentaReader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidasReader = new Scanner(System.in); 
								localidadesVendidas = localidadesVentaReader.nextInt();
								System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
								fechaReader = new Scanner(System.in); 
								String aux = fechaReader.nextLine();
								
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
								fecha = LocalDateTime.parse(aux, formatter);
								
								
								manager.createEspectaculoPunt(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, fecha);
								
								tituloReader.close(); 
								categoriaReader.close(); 
								descripcionReader.close(); 
								localidadesVentaReader.close(); 
								localidadesVendidasReader.close();
								fechaReader.close();
								
							}
							if("3".equals(opcEspectaculo))
							{
								Scanner tituloReader, categoriaReader,descripcionReader,localidadesVentaReader,localidadesVendidasReader, fechaReader, decisionReader; 
								String titulo, descripcion, categoria;
								LocalDateTime fecha;
								int localidadesVenta, localidadesVendidas;  
								Boolean decisionPases = true;
								ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
								//crear espectaculo temporal
								
								EspectaculoManager managerMult = new EspectaculoManager();
								int id = managerMult.generarIDMult();
								System.out.println("Introduce el titulo.");
								tituloReader = new Scanner(System.in); 
								titulo = tituloReader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoriaReader = new Scanner(System.in); 
								categoria = categoriaReader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcionReader =  new Scanner(System.in); 
								descripcion = descripcionReader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVentaReader = new Scanner(System.in); 
								localidadesVenta = localidadesVentaReader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidasReader = new Scanner(System.in); 
								localidadesVendidas = localidadesVentaReader.nextInt();
												
								managerMult.createEspectaculoMult(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas);
								
								
								do
								{
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
									fechaReader = new Scanner(System.in); 
									String aux = fechaReader.nextLine();
									//conversion string to localdatetime
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fecha = LocalDateTime.parse(aux, formatter);
									
									int idF = managerMult.generarIDPases();
 
									System.out.println("Desea introducir mas fechas? (y/n)");
									decisionReader =  new Scanner(System.in); 
									aux = decisionReader.nextLine(); 
									while(true)
									{
										if(aux.equals("n") || aux.equals("N"))
										{
											decisionPases = false; 
											break; 
										}
										else if (aux.equals("y") || aux.equals("Y"))
										{
											decisionPases = true; 
											break; 
										}
										else
										{
											System.out.println("Desea introducir mas fechas? (y/n)");
											aux = decisionReader.nextLine(); 
										}
									}
									manager.createFecha(idF,fecha, id); 

									listPases.add(managerMult.requestPase(id)); 
								}while(decisionPases==true); 
								
								tituloReader.close(); 
								categoriaReader.close(); 
								descripcionReader.close(); 
								localidadesVentaReader.close(); 
								localidadesVendidasReader.close();
								fechaReader.close();
								decisionReader.close();
							}
						}
						opcEspectaculo_reader.close(); 
					}
					else if("2".equals(opc))
					{
						System.out.println("DAR DE BAJA ESPECTACULO");
						String opcEspectaculo = "1"; 
						Scanner opcEspectaculo_reader = new Scanner(System.in); 
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("DAR DE BAJA ESPECTACULO");
							System.out.println("Si quiere eliminar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere eliminar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere eliminar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = opcEspectaculo_reader.nextLine(); 
							if("1".equals(opcEspectaculo))
							{
								EspectaculoManager deleteTemp = new EspectaculoManager();
				        		ArrayList<EspectaculoTempDTO> esps = deleteTemp.requestETs();
				        		int cont = 1;
				        		for(EspectaculoTempDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
				        		Scanner Esp_scan = new Scanner(System.in);
					        	String Esp = Esp_scan.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
					        		deleteTemp.deleteEspectaculoTemp(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}

					        	Esp_scan.close();	
				        	
							}
							else if("2".equals(opcEspectaculo))
							{
								//Todo: borrar espectaculo puntual
							}
							else if("3".equals(opcEspectaculo))
							{
								//Todo: borrar espectaculo multiple	
							}
						}
						opcEspectaculo_reader.close();
					}
					else if("3".equals(opc))
					{
						
						String opcEspectaculo = "1"; 
						Scanner opcEspectaculo_reader = new Scanner(System.in); 
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("ACTUALIZAR INFORMACION DE ESPECTACULO");
							System.out.println("Si quiere actualizar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere actualizar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere actualizar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = opcEspectaculo_reader.nextLine(); 
							if("1".equals(opcEspectaculo))
							{
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoManager updateTemp = new EspectaculoManager();
				        		ArrayList<EspectaculoTempDTO> esps = updateTemp.requestETs();
				        		int cont = 1;
				        		for(EspectaculoTempDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
				        		Scanner Esp_scan = new Scanner(System.in);
					        	String Esp = Esp_scan.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
					        		Scanner tituloReader, categoriaReader,descripcionReader,localidadesVentaReader,localidadesVendidasReader, fechaInicioReader, diaSemanaReader, fechaFinalReader, decisionReader; 
									String titulo, descripcion, categoria, diaSemana; 
									LocalDateTime fechaInicio, fechaFinal;
									int localidadesVenta, localidadesVendidas;  
									ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
									
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
									System.out.println("Introduce el titulo.");
									tituloReader = new Scanner(System.in); 
									titulo = tituloReader.nextLine(); 
									System.out.println("Introduce la categoria.");
									categoriaReader = new Scanner(System.in); 
									categoria = categoriaReader.nextLine(); 
									System.out.println("Introduce la descripcion.");
									descripcionReader =  new Scanner(System.in); 
									descripcion = descripcionReader.nextLine(); 
									System.out.println("Introduce el numero de localidades a la venta.");
									localidadesVentaReader = new Scanner(System.in); 
									localidadesVenta = localidadesVentaReader.nextInt(); 
									System.out.println("Introduce el numero de localidades vendidas.");
									localidadesVendidasReader = new Scanner(System.in); 
									localidadesVendidas = localidadesVentaReader.nextInt();
													
									

									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
									fechaInicioReader = new Scanner(System.in); 
									String aux = fechaInicioReader.nextLine();
									//conversion string to localdatetime
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fechaInicio = LocalDateTime.parse(aux, formatter);
										
									int idP = updateTemp.generarIDPases();
									System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm)");
									fechaFinalReader = new Scanner(System.in); 
									aux = fechaFinalReader.nextLine();
									//conversion string to localdatetime
									fechaFinal = LocalDateTime.parse(aux, formatter);
									System.out.println("Introduce dia de la Semana.");
									diaSemanaReader =  new Scanner(System.in); 
									diaSemana = diaSemanaReader.nextLine(); 
									System.out.println("Desea introducir mas pases? (y/n)");
									decisionReader =  new Scanner(System.in); 
									aux = decisionReader.nextLine(); 
										
									//TODO: Añadir update Pase como queramos (vector completo / elemento del vector)
									
									manager.updateEspectaculoTemp(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, listPases);
									
									tituloReader.close(); 
									categoriaReader.close(); 
									descripcionReader.close(); 
									localidadesVentaReader.close(); 
									localidadesVendidasReader.close();
									fechaInicioReader.close();
									fechaFinalReader.close();
									diaSemanaReader.close();
									decisionReader.close();
					        		
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}

					        	Esp_scan.close();	
							}
							else if("2".equals(opcEspectaculo))
							{
								//Todo: actualizar espectaculo puntual
							}
							else if("3".equals(opcEspectaculo))
							{
								//Todo: actualizar espectaculo multiple	
							}
						}
						opcEspectaculo_reader.close();
					}
				}
		
			}
				else if(i == (manageruser.requestByRol("admin").size()-1))
				{
					System.out.println("No tiene permiso para acceder al menu de Administracion");
				}
			}
		}
			
		
	}
