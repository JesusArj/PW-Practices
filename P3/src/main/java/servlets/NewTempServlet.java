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
import business.EspectaculoTempDTO;
import business.PasesDTO;
import javax.servlet.*;
import data.DAOs.EspectaculoDAO;

@WebServlet(name="NewTempServlet", urlPatterns="/NewTempServlet")

public class NewTempServlet extends HttpServlet 
{
	private static final long serialVersionUID = -1290846862882680952L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO tempDAO = new EspectaculoDAO(urlBD,userBD,passBD);
		
		ArrayList<PasesDTO> pases = new ArrayList<PasesDTO>();
		
		int numPases = (int)request.getAttribute("numPases");
		int ID = tempDAO.generarIDPunt();
		String title = request.getParameter("Titulo");
		String desc = request.getParameter("Descripcion");
		String local = request.getParameter("Localidades");
		String categ = request.getParameter("Categoria");
		int Localidades = Integer.parseInt(local);
		int Vendidas = 0;

		for(int i = 1; i <= numPases; i++)
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String fechai = request.getParameter("fechaInicio"+i);
			LocalDateTime FechaInicio = LocalDateTime.parse(fechai, formatter);
			String fechaf = request.getParameter("fechaFinal"+i);
			LocalDateTime FechaFinal = LocalDateTime.parse(fechaf, formatter);
			String diaSemana = request.getParameter("diasemana"+i);
			
			int idp = tempDAO.generarIdPases();
			PasesDTO newPase = new PasesDTO(idp, FechaInicio, diaSemana ,FechaFinal);
			
			pases.add(newPase);
		}
		
		EspectaculoTempDTO newTemp = new EspectaculoTempDTO(ID, title, categ, desc, Localidades, Vendidas, pases);
		tempDAO.createEspectaculoTemporada(newTemp);
		
		String ruta = request.getContextPath() + "/P3-Alt/views/newTempDone.jsp"; //TODO: JSP de Espectaculo Temp cerado con exito;
		response.sendRedirect(ruta);
		
	}
}