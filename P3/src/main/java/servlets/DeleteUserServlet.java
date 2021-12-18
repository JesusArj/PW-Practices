package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.CustomerBean;
import data.DAOs.UserDAO;


@WebServlet(name="DeleteUserServlet", urlPatterns="/DeleteUserServlet")

public class DeleteUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 7025674605892363927L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext app = getServletContext();
		
		String passBD = app.getInitParameter("password");
		String urlBD = app.getInitParameter("url");
		String userBD = app.getInitParameter("user");
		
		HttpSession session = request.getSession();
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");

		String mail = customerBean.getEmailUser();
		UserDAO userDAO = new UserDAO(urlBD, userBD, passBD);
		userDAO.deleteUser(mail);
		customerBean = null;
		
		String ruta = request.getContextPath() + "/index.jsp";
		response.sendRedirect(ruta);
	}
}