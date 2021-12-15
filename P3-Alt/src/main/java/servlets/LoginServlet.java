package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.UserDTO;
import data.DAOs.UserDAO;
import beans.CustomerBean;

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4261016544681578021L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("Mail");
		String pass = request.getParameter("Password");
		ServletContext app = getServletContext();
		
			if (mail != null) {
				
				String passBD = app.getInitParameter("password");
				String urlBD = app.getInitParameter("url");
				String userBD = app.getInitParameter("user");
				
				UserDAO userDAO = new UserDAO(urlBD,userBD,passBD);
				String password = userDAO.requestCredenciales(mail);
				ArrayList<UserDTO> users = userDAO.requestUsers();		
				
				for(UserDTO u : users){
					if(u.getMail().equals(mail)){
						if (password.equals(pass)){
							String username = u.getUsername();
							String rol = u.getRol();
							HttpSession session = request.getSession();
							CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
							customerBean.setEmailUser(mail); 
							customerBean.setUsername(username); 
							customerBean.setRol(rol);
							if(u.getRol().equals("usuario")){
								response.sendRedirect(request.getContextPath() + "/views/home.jsp");
							}
							else{
								response.sendRedirect(request.getContextPath() + "/views/homeAdmin.jsp");
							}
						}
						else{
							response.sendRedirect(request.getContextPath() + "/P3-Alt/error/userBadPass.jsp"); 
						}
					}
				}
			}
			response.sendRedirect(request.getContextPath() + "/P3-Alt/error/userNotExist.jsp");
		}
}

 