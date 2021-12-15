package servlets;

/*
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.*;
import data.DAOs.EspectaculoDAO;
import beans.*;

@WebServlet(name="SearchEspServlet", urlPatterns="/SearchEspServlet")

public class SearchEspServlet extends HttpServlet 
{

	private static final long serialVersionUID = 7313417310612984176L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String mail = request.getParameter("mail");
		if (mail != null) 
		{
			String title = null, category = null;
			String pass = request.getParameter("password");
			String url = request.getParameter("url");
			String userC = request.getParameter("user");
			if(!"null".equals(request.getParameter("titulo")))
			{
				title = request.getParameter("titulo");
			}
			else if(!"null".equals(request.getParameter("categoria")))
			{
				category = request.getParameter("categoria");
			}
			//TODO: A�adir lo del filtro
			
			EspectaculoDAO espDAO = new EspectaculoDAO(url, userC, pass);
			ArrayList<EspectaculoPuntDTO> espPunt = espDAO.requestEPs();
			ArrayList<EspectaculoMultDTO> espMult = espDAO.requestEMs();
			ArrayList<EspectaculoTempDTO> espTemp = espDAO.requestETs();

			ArrayList<EspectaculoPuntDTO> foundPunt = null;
			ArrayList<EspectaculoMultDTO> foundMult = null;
			ArrayList<EspectaculoTempDTO> foundTemp = null;
			
			for(EspectaculoPuntDTO e : espPunt)
			{
				if(e.getCategoria().equals(category) || e.getTitulo().equals(title))
				{
					foundPunt.add(e);
				}
			}
			
			for(EspectaculoMultDTO e : espMult)
			{
				if(e.getCategoria().equals(category) || e.getTitulo().equals(title))
				{
					foundMult.add(e);
				}
			}
			
			for(EspectaculoTempDTO e : espTemp)
			{
				if(e.getCategoria().equals(category) || e.getTitulo().equals(title))
				{
					foundTemp.add(e);
				}
			}
			
			//TODO: Mandar todo al bean y del bean a lo que sea
			
			HttpSession session = request.getSession();
			EspPuntBean puntualBean = (EspPuntBean) session.getAttribute("puntualBean");
			EspMultBean multipleBean = (EspMultBean) session.getAttribute("multipleBean");
			EspTempBean temporadaBean = (EspTempBean) session.getAttribute("temporadaBean");
			
			
		}
		
		else{
			response.sendRedirect("../../userBadPass.jsp"); 
		}
	}
} 
*/