package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.CriticaDTO;
import business.VotantesCriticaDTO;

import javax.servlet.*;
import data.DAOs.CriticaDAO;

@WebServlet(name="LikeCriticaServlet", urlPatterns="/LikeCriticaServlet")

public class LikeCriticaServlet extends HttpServlet 
{
	private static final long serialVersionUID = -4468798356093461061L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
			
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		CriticaDAO critDAO = new CriticaDAO(urlBD, userBD, passBD);
		ArrayList<CriticaDTO> crits = critDAO.requestCriticas();
		
		String ID = request.getParameter("idCritica");
		String mailVot = request.getParameter("mailVot");
		int id = Integer.parseInt(ID);	
		
		for(CriticaDTO c : crits)
		{
			if(c.getId() == id)
			{
				String titulo = c.getTitle();
				String mail = c.getMail();
				float punt = c.getPuntuacion();
				String resena = c.getResena();
				int like = c.getLike()+1;
				int dislike = c.getDislike();
				int idEsp = c.getIdEsp();

				CriticaDTO likeCrit = new CriticaDTO(titulo, punt, resena, id, mail, like, dislike, idEsp);
				critDAO.updateCritica(likeCrit);
				for(VotantesCriticaDTO cri : c.getVotantes())
				{
					if(cri.getVotante().equals(mailVot) && cri.getVoto().equals("dislike"))
					{
						critDAO.removeVotanteCritica(mailVot, id);
					}
				}
				critDAO.addVotanteCritica(mailVot, id, "like");
			}
		}
		critDAO.desCriticaDAO();
		String ruta = request.getContextPath() + "/GetAllEspsDoneServlet";
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Like añadido correctamente.');");
        out.println("window.location.href =" + "'" + ruta + "'" + ";" );
        out.println("</script>");	
	}
}