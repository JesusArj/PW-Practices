package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.EspectaculoPuntDTO;
import javax.servlet.*;
import data.DAOs.EspectaculoDAO;

@WebServlet(name="NewPuntServlet", urlPatterns="/NewPuntServlet")

public class NewPuntServlet extends HttpServlet 
{

	private static final long serialVersionUID = -1905442511795447120L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO puntDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		
		int ID = puntDAO.generarIDPunt();
		String title = request.getParameter("Titulo");
		String desc = request.getParameter("Descripcion");
		String local = request.getParameter("Localidades");
		String vendidas = request.getParameter("Vendidas");
		String categ = request.getParameter("Categoria");
		String fecha = request.getParameter("Fecha");
		
		int Localidades = Integer.parseInt(local);
		int Vendidas = Integer.parseInt(vendidas);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime Fecha = LocalDateTime.parse(fecha, formatter);
		
		EspectaculoPuntDTO newPunt = new EspectaculoPuntDTO(ID, title, categ, desc, Localidades, Vendidas, Fecha);
		puntDAO.createEspectaculoPuntual(newPunt);
		
		String ruta = request.getContextPath() + "/P3-Alt/views/newPuntDone.jsp"; //TODO: JSP de Espectaculo Puntual cerado con exito;
		response.sendRedirect(ruta);
		
	}
}