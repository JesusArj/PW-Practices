package display.views;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import business.DTOs.EspectaculoMultDTO;
import business.DTOs.EspectaculoPuntDTO;
import business.DTOs.EspectaculoTempDTO;
import business.DTOs.FechasDTO;
import business.DTOs.PasesDTO;
import business.managers.EspectaculoManager;
import business.managers.UserManager;

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
		Scanner reader = new Scanner(System.in);
		while(opc.equals("1") || opc.equals("2") || opc.equals("3") || opc.equals("4") || opc.equals("5"))
		{
			System.out.println("Bienvenido al menu de Espectaculos");
			System.out.println("Para ver los espectaculos registrados, pulse 1");
			System.out.println("Para ver los espectaculos con entradas disponibles, pulse 2");
			System.out.println("Para buscar un espectaculo por categoria, pulse 3");
			System.out.println("Para ver la informacion de un espectaculo concreto, pulse 4");
			System.out.println("Para acceder al menu de administracion, pulse 5");
			System.out.println("Para salir del menu, pulse cualquier otra tecla");

			opc = reader.nextLine();

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
		        			System.out.println("Fecha " + Integer.toString(countFechas) + ": " + manager.requestEMs().get(i).getFechas().get(j).getFechaString() );
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
		        			System.out.println("FECHA " + Integer.toString(countFechas) + ": ");
		        			System.out.println("DIA: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
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
		        	System.out.println("Introduzca categoria: ");
		        		
		        	category= reader.nextLine();
		
				    
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
			        			System.out.println("DIA: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
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

	        		title= reader.nextLine();

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
			        			System.out.println("DIA: " + manager.requestETs().get(i).getPases().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + manager.requestETs().get(i).getPases().get(j).getFechaInicioString());
			        			System.out.println("FINAL: " + manager.requestETs().get(i).getPases().get(j).getFechaFinalString());
			        			countFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        }
		        else if(opc.equals("5"))
		        {
		        	EspectaculoMenuAdmin(mail);
		        }
		}

	}
	
	public void EspectaculoMenuAdmin(String mail)
	{
		Scanner reader = new Scanner(System.in);
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

					opc = reader.nextLine();
				        
					if("1".equals(opc))
					{
						String opcEspectaculo = "1";
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("DAR DE ALTA ESPECTACULO");
							System.out.println("Si quiere crear un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere crear un espectaculo puntual, pulse 2");
							System.out.println("Si quiere crear un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = reader.nextLine(); 
							if("1".equals(opcEspectaculo))
							{
								String titulo, descripcion, categoria, diaSemana; 
								LocalDateTime fechaInicio, fechaFinal;
								int localidadesVenta, localidadesVendidas;  
								Boolean decisionPases = true;
								ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
								
								EspectaculoManager managerPunt = new EspectaculoManager();
								int id = managerPunt.generarIDPunt();
								System.out.println("Introduce el titulo.");
								titulo = reader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoria = reader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcion = reader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVenta = reader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidas = reader.nextInt();
												
								manager.createEspectaculoTemp(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas);
								
								do
								{
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
									String aux = reader.nextLine();
									//conversion string to localdatetime
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fechaInicio = LocalDateTime.parse(aux, formatter);
									
									int idP = managerPunt.generarIDPases();
									System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm)"); 
									aux = reader.nextLine();
									//conversion string to localdatetime
									fechaFinal = LocalDateTime.parse(aux, formatter);
									System.out.println("Introduce dia de la Semana.");
									diaSemana = reader.nextLine(); 
									System.out.println("Desea introducir mas pases? (y/n)");
									aux = reader.nextLine(); 
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
											aux = reader.nextLine(); 
										}
									}
									manager.createPase(idP,fechaInicio, diaSemana, fechaFinal, id); 

									listPases.add(managerPunt.requestPase(id)); 
								}while(decisionPases==true); 
							}
							if("2".equals(opcEspectaculo))
							{
								String titulo, descripcion, categoria; 
								LocalDateTime fecha;
								int localidadesVenta, localidadesVendidas; 
								
								EspectaculoManager managerPunt = new EspectaculoManager();
								int id = managerPunt.generarIDPunt();
								System.out.println("Introduce el titulo.");
								titulo = reader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoria = reader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcion = reader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVenta = reader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidas = reader.nextInt();
								System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
								String aux = reader.nextLine();
								
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
								fecha = LocalDateTime.parse(aux, formatter);		
								
								manager.createEspectaculoPunt(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, fecha);
								
							}
							if("3".equals(opcEspectaculo))
							{
								String titulo, descripcion, categoria;
								LocalDateTime fecha;
								int localidadesVenta, localidadesVendidas;  
								Boolean decisionPases = true;
								ArrayList<FechasDTO> listFechas = new ArrayList<FechasDTO>();

								EspectaculoManager managerMult = new EspectaculoManager();
								int id = managerMult.generarIDMult();
								System.out.println("Introduce el titulo.");
								titulo = reader.nextLine(); 
								System.out.println("Introduce la categoria.");
								categoria = reader.nextLine(); 
								System.out.println("Introduce la descripcion.");
								descripcion = reader.nextLine(); 
								System.out.println("Introduce el numero de localidades a la venta.");
								localidadesVenta = reader.nextInt(); 
								System.out.println("Introduce el numero de localidades vendidas.");
								localidadesVendidas = reader.nextInt();								
								
								do
								{
									System.out.println("Introduce fecha. (Formato: yyyy-MM-dd HH:mm)");
									String aux = reader.nextLine();
									//conversion string to localdatetime
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fecha = LocalDateTime.parse(aux, formatter);
									
									int idF = managerMult.generarIDFechas();
 
									System.out.println("Desea introducir mas fechas? (y/n)");
									aux = reader.nextLine(); 
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
											aux = reader.nextLine(); 
										}
									}
									manager.createFecha(idF,fecha, id); 

									listFechas.add(managerMult.requestFecha(id)); 
								}while(decisionPases==true); 
								
								managerMult.createEspectaculoMult(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas,listFechas);

							}
						}
					}
					else if("2".equals(opc))
					{
						System.out.println("DAR DE BAJA ESPECTACULO");
						String opcEspectaculo = "1"; 
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("DAR DE BAJA ESPECTACULO");
							System.out.println("Si quiere eliminar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere eliminar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere eliminar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = reader.nextLine(); 
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
					        	String Esp = reader.nextLine();
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
							}
							else if("2".equals(opcEspectaculo))
							{
								EspectaculoManager deletePunt = new EspectaculoManager();
				        		ArrayList<EspectaculoPuntDTO> esps = deletePunt.requestEPs();
				        		int cont = 1;
				        		for(EspectaculoPuntDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
					        	String Esp = reader.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
					        		deletePunt.deleteEspectaculoPunt(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}

					        	reader.close();
							}
							
							else if("3".equals(opcEspectaculo))
							{
								EspectaculoManager deleteMult = new EspectaculoManager();
				        		ArrayList<EspectaculoMultDTO> esps = deleteMult.requestEMs();
				        		int cont = 1;
				        		for(EspectaculoMultDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
					        	String Esp = reader.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
					        		deleteMult.deleteEspectaculoMultiple(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}
							}
						}
					}
					else if("3".equals(opc))
					{
						
						String opcEspectaculo = "1"; 
						while(opcEspectaculo.equals("1") || opcEspectaculo.equals("2") || opcEspectaculo.equals("3"))
						{
							System.out.println("ACTUALIZAR INFORMACION DE ESPECTACULO");
							System.out.println("Si quiere actualizar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere actualizar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere actualizar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcEspectaculo = reader.nextLine(); 
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
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = reader.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
									String titulo, descripcion, categoria, diaSemana; 
									LocalDateTime fechaInicio, fechaFinal;
									int localidadesVenta, localidadesVendidas;  
									Boolean decisionPases = true;
									ArrayList<PasesDTO> listPases = new ArrayList<PasesDTO>();
									
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
									System.out.println("Introduce el titulo.");
									titulo = reader.nextLine(); 
									System.out.println("Introduce la categoria.");
									categoria = reader.nextLine(); 
									System.out.println("Introduce la descripcion.");
									descripcion = reader.nextLine(); 
									System.out.println("Introduce el numero de localidades a la venta.");
									localidadesVenta = reader.nextInt(); 
									System.out.println("Introduce el numero de localidades vendidas.");
									localidadesVendidas = reader.nextInt();	
									
									System.out.println("Introduzca el numero del pase a actualizar");
						        	String Pase = reader.nextLine();
						        	
									if(Integer.parseInt(Pase) > 0 && Integer.parseInt(Pase) < cont ) 
						        	{
										do
										{
											listPases = esps.get(Integer.parseInt(Esp)).getPases();
							        		ArrayList<PasesDTO> pases = updateTemp.requestPases();
							        		int count = 1;
							        		for(PasesDTO p : pases) 
							        		{
							        			System.out.println(count + ". " + p.getID());
							        			System.out.println(p.getFechaInicio());
							        			System.out.println(p.getDiaSemana());
							        			System.out.println(p.getFechaFinal());
							        		}
											System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
											String aux = reader.nextLine();
											//conversion string to localdatetime
											int idP = pases.get(Integer.parseInt(Pase)).getID();
											
											DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
											fechaInicio = LocalDateTime.parse(aux, formatter);
											System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm)");
											aux = reader.nextLine();
											//conversion string to localdatetime
											fechaFinal = LocalDateTime.parse(aux, formatter);
											System.out.println("Introduce dia de la Semana.");
											diaSemana = reader.nextLine(); 
											System.out.println("Desea actualizar otro pase? (y/n)");
											aux = reader.nextLine(); 
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
												}
											}
											manager.updatePases(idP,fechaInicio, diaSemana, fechaFinal, id);  
										}while(decisionPases==true); 
										listPases = esps.get(Integer.parseInt(Esp)).getPases();
						        	}
									manager.updateEspectaculoTemp(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, listPases);
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}
							}
							else if("2".equals(opcEspectaculo))
							{
								//Todo: actualizar espectaculo puntual
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoManager updatePunt = new EspectaculoManager();
				        		ArrayList<EspectaculoPuntDTO> esps = updatePunt.requestEPs();
				        		int cont = 1;
				        		for(EspectaculoPuntDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = reader.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
									String titulo, descripcion, categoria; 
									LocalDateTime fecha;
									int localidadesVenta, localidadesVendidas;  

									
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
									System.out.println("Introduce el titulo.");
									titulo = reader.nextLine(); 
									System.out.println("Introduce la categoria.");
									categoria = reader.nextLine(); 
									System.out.println("Introduce la descripcion.");
									descripcion = reader.nextLine(); 
									System.out.println("Introduce el numero de localidades a la venta.");
									localidadesVenta = reader.nextInt(); 
									System.out.println("Introduce el numero de localidades vendidas.");
									localidadesVendidas = reader.nextInt();	
		
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm)");
									String aux = reader.nextLine();
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
									fecha = LocalDateTime.parse(aux, formatter);
									
									manager.updateEspectaculoPunt(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, fecha);
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}

							}
							else if("3".equals(opcEspectaculo))
							{
								//Todo: actualizar espectaculo multiple	
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoManager updateMult = new EspectaculoManager();
				        		ArrayList<EspectaculoMultDTO> esps = updateMult.requestEMs();
				        		int cont = 1;
				        		for(EspectaculoMultDTO e : esps) 
				        		{
				        			System.out.println(cont + ". " + e.getTitulo());
				        			System.out.println(e.getCategoria());
				        			System.out.println(e.getDescripcion());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = reader.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && Integer.parseInt(Esp) < cont ) 
					        	{
									String titulo, descripcion, categoria; 
									LocalDateTime fecha;
									int localidadesVenta, localidadesVendidas;  
									Boolean decisionFechas = true;
									ArrayList<FechasDTO> listFechas= new ArrayList<FechasDTO>();
									
					        		int id = esps.get(Integer.parseInt(Esp)).getID();
									System.out.println("Introduce el titulo.");
									titulo = reader.nextLine(); 
									System.out.println("Introduce la categoria.");
									categoria = reader.nextLine(); 
									System.out.println("Introduce la descripcion.");
									descripcion = reader.nextLine(); 
									System.out.println("Introduce el numero de localidades a la venta.");
									localidadesVenta = reader.nextInt(); 
									System.out.println("Introduce el numero de localidades vendidas.");
									localidadesVendidas = reader.nextInt();	
						        	
									ArrayList<FechasDTO> fechas = updateMult.requestFechas();
					        		int count = 1;
					        		for(FechasDTO f : fechas) 
					        		{
					        			System.out.println(count + ". " + f.getID());
					        			System.out.println(f.getFecha());
					        		}
					        		
					        		System.out.println("Introduzca el numero de la fecha a actualizar");
						        	String Fecha = reader.nextLine();
						        	
									if(Integer.parseInt(Fecha) > 0 && Integer.parseInt(Fecha) < cont ) 
						        	{
										listFechas = esps.get(Integer.parseInt(Esp)).getFechas();
										do
										{
							        		for(FechasDTO f : fechas) 
							        		{
							        			System.out.println(count + ". " + f.getID());
							        			System.out.println(f.getFecha());
							        		}
							        		
							        		System.out.println("Confirme  el numero de la fecha a actualizar");
							        		Fecha = reader.nextLine();
								        	
											System.out.println("Introduce fecha. (Formato: yyyy-MM-dd HH:mm)");
											String aux = reader.nextLine();
											//conversion string to localdatetime
											DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
											fecha = LocalDateTime.parse(aux, formatter);
											
											int idP = fechas.get(Integer.parseInt(Fecha)).getID();
											
											System.out.println("Desea actualizar otra fecha? (y/n)");
											aux = reader.nextLine(); 
											while(true)
											{
												if(aux.equals("n") || aux.equals("N"))
												{
													decisionFechas = false; 
													break; 
												}
												else if (aux.equals("y") || aux.equals("Y"))
												{
													decisionFechas = true; 
													break; 
												}
												else
												{
													System.out.println("Desea actualizar mas fechas? (y/n)");
													aux = reader.nextLine(); 
												}
											}
											manager.updateFechas(idP,fecha, id);  
										}while(decisionFechas==true); 
										listFechas = esps.get(Integer.parseInt(Esp)).getFechas();
						        	}
									listFechas = esps.get(Integer.parseInt(Esp)).getFechas();
									manager.updateEspectaculoMultiple(id, titulo, categoria, descripcion, localidadesVenta, localidadesVendidas, listFechas);
									

									
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else 
					        	{
					        		System.out.println("Espectaculo no valido");
					        	}

							}
						}
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
