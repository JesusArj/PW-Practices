package servlets;

import java.io.IOException;
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

@WebServlet(name="AddFechaMult", urlPatterns="/AddFechaMult")

public class AddFechaMult extends HttpServlet 
{
	private static final long serialVersionUID = 895843397081386258L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoMultDTO> multiples= multDAO.requestEMs();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		ArrayList<FechasDTO> fechasUpdate = new ArrayList<FechasDTO>();
		
		for(EspectaculoMultDTO e : multiples)
		{
			if(id == e.getID())
			{
				fechasUpdate = e.getFechas();
			}
		}
		
		//TODO: El formulario dinamico con JS
		
		String ruta = request.getContextPath() + "/P3-Alt/views/newFechaDone.jsp"; //TODO: JSP de Espectaculo Multiple cerado con exito;
		response.sendRedirect(ruta);
		
	}
}