package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.EspectaculoMultDTO;
import business.FechasDTO;
import javax.servlet.*;
import data.DAOs.EspectaculoDAO;

@WebServlet(name="NewMultServlet", urlPatterns="/NewMultServlet")

public class NewMultServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6905725230597578589L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		
		ArrayList<FechasDTO> fechas;
		
		int ID = multDAO.generarIDMult();
		String title = request.getParameter("Titulo");
		String desc = request.getParameter("Descripcion");
		String local = request.getParameter("Localidades");
		String vendidas = request.getParameter("Vendidas");
		String categ = request.getParameter("Categoria");
		int Localidades = Integer.parseInt(local);
		int Vendidas = Integer.parseInt(vendidas);
		/*
		Lo de las n fechas.
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime Fecha = LocalDateTime.parse(fecha, formatter);
		*/
		
		EspectaculoMultDTO newMult = new EspectaculoMultDTO(ID, title, categ, desc, Localidades, Vendidas, fechas);
		multDAO.createEspectaculoMultiple(newMult);
		
		String ruta = request.getContextPath() + "/P3-Alt/views/newMultDone.jsp"; //TODO: JSP de Espectaculo Multiple cerado con exito;
		response.sendRedirect(ruta);
		
	}
}