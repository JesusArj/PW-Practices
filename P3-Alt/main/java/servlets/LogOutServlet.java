package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.CustomerBean;


@WebServlet(name="LogOutServlet", urlPatterns="/LogOutServlet")

public class LogOutServlet extends HttpServlet 
{
	private static final long serialVersionUID = -926245635153697382L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
		customerBean = null;
		String ruta = request.getContextPath() + "/index.jsp";
		response.sendRedirect(ruta);
	}
}