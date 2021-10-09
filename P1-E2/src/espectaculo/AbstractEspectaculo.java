package espectaculo;

import java.util.ArrayList;

import fichero.espectaculos.IOEspectaculos;

enum categoria
{
    concierto, obra, monologo;
}

public class AbstractEspectaculo extends IOEspectaculos{

	private String categoria; 
	private String titulo;  
	private String descripcion; 
	private int localidades_venta; 
	private int localidades_vendidas; 
	private ArrayList<Integer> criticas;
	
	//CONSTRUCTOR VACO
		public AbstractEspectaculo(){};
		
		//CONSTRUCTOR PARAMETRIZADO
		public AbstractEspectaculo(String titulo, String categoria, String descripcion) 
		{
			this.titulo = titulo; 
			this.descripcion = descripcion;
			this.categoria=categoria; 
		}
		
		//OBSERVADORES
		
		public String getCategoria()
		{
			return this.categoria; 
		}
		public String getTitulo()
		{
			return this.titulo; 
		}
		public String getDescripcion()
		{
			return descripcion; 
		}
		
		public int getLocalidadesVenta()
		{
			return this.localidades_venta; 
		}
		public int getLocalidadesVendidas()
		{
			return this.localidades_vendidas; 
		}
		public ArrayList<Integer> getCritica() {
			return this.criticas;
		}
		
		//MODIFICADORES
		
		public void setCategoria(String categoria)
		{
			this.categoria=categoria; 
		}
		public void setTitulo(String titulo)
		{
			this.titulo = titulo; 
		}
		public void setDescripcion(String descripcion)
		{
			this.descripcion=descripcion; 
		}
		public void setLocalidadesVenta(int localidades_venta)
		{
			this.localidades_venta=localidades_venta;
		}
		public void setLocalidadesVendidas(int localidades_vendidas)
		{
			this.localidades_vendidas=localidades_vendidas; 
		}
		public void setCritica(ArrayList<Integer> c) {
			this.criticas = c;
		}
		
}
