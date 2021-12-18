package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import business.*;
import data.DAOs.EspectaculoDAO;
import beans.*;

@WebServlet(name="SearchPuntServlet", urlPatterns="/SearchPuntServlet")

public class SearchPuntServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext app = getServletContext();
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");

		EspectaculoDAO espDAO = new EspectaculoDAO(urlBD, userBD, passBD);
		
		ArrayList<EspectaculoPuntDTO> espPunt = espDAO.requestEPs();
		ArrayList<EspectaculoPuntDTO> foundPunt = new ArrayList<EspectaculoPuntDTO>();
		
		for(EspectaculoPuntDTO e : espPunt)
		{
			foundPunt.add(e);
		}

		HttpSession session = request.getSession();
		AllEspsBean allEspsBean = new AllEspsBean();
			
		allEspsBean.setAllPunt(foundPunt);
		allEspsBean.setNumPunt(foundPunt.size());	
			
		session.setAttribute("allEspsBean", allEspsBean);
		response.sendRedirect(request.getContextPath() + "/P3-Alt/views/EspMenu/allEspsView.jsp"); 
	}	
}
