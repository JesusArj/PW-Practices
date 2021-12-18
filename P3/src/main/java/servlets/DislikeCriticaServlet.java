package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.CriticaDTO;

import javax.servlet.*;
import data.DAOs.CriticaDAO;

@WebServlet(name="DislikeCriticaServlet", urlPatterns="/DislikeCriticaServlet")

public class DislikeCriticaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 46658568493939722L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		CriticaDAO critDAO = new CriticaDAO(urlBD, userBD, passBD);
		ArrayList<CriticaDTO> crits = critDAO.requestCriticas();
		
		String ID = request.getParameter("idCritica");
		int id = Integer.parseInt(ID);	
		
		for(CriticaDTO c : crits)
		{
			if(c.getId() == id)
			{
				String titulo = c.getTitle();
				String mail = c.getMail();
				float punt = c.getPuntuacion();
				String resena = c.getResena();
				int like = c.getLike();
				int dislike = c.getDislike()+1;
				int idEsp = c.getIdEsp();
;				
				CriticaDTO likeCrit = new CriticaDTO(titulo, punt, resena, id, mail, like, dislike, idEsp);
				critDAO.updateCritica(likeCrit);
			}
		}
		response.sendRedirect(request.getContextPath() + "/P3-Alt/views/criticasMenu/homeCriticas.jsp");
	}
}