package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.EspectaculoTempDTO;
import business.PasesDTO;
import javax.servlet.*;
import data.DAOs.EspectaculoDAO;

@WebServlet(name="ModifyPasesTemp", urlPatterns="/ModifyPasesTemp")

public class ModifyPasesTemp extends HttpServlet 
{
	private static final long serialVersionUID = 3058004877733204408L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO multDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		ArrayList<EspectaculoTempDTO> temporadas= multDAO.requestETs();
		
		int id = Integer.parseInt(request.getParameter("idEsp"));
		ArrayList<PasesDTO> pasesUpdate = new ArrayList<PasesDTO>();
		
		for(EspectaculoTempDTO e : temporadas)
		{
			if(id == e.getID())
			{
				pasesUpdate = e.getPases();
			}
		}
		
		//TODO: El formulario dinamico con JS
		
		String ruta = request.getContextPath() + "/P3-Alt/views/newPaseDone.jsp"; //TODO: JSP de Espectaculo Multiple cerado con exito;
		response.sendRedirect(ruta);
	}
}