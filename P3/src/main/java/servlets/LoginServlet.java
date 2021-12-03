package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.DTOs.UserDTO;
import data.DAOs.UserDAO;
import display.javabean.CustomerBean;

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4261016544681578021L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		
			if (mail != null) {
				String pass = request.getParameter("password");
				String url = request.getParameter("url");
				String userC = request.getParameter("user");
				UserDAO userDAO = new UserDAO(url,userC,pass);
				String password = userDAO.requestCredenciales(mail);
				ArrayList<UserDTO> users = userDAO.requestUsers();
				
				for(UserDTO u : users){
					if(u.getMail().equals(mail)){
						if (password.equals(pass)){
							if(u.getRol().equals("usuario")){
								String username = u.getUsername();
								String rol = u.getRol();
								HttpSession session = request.getSession();
								CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
								if (customerBean == null || customerBean.getEmailUser().equals("")) {
								//TODO forward a login
								} 
								else {
									customerBean.setEmailUser(mail); 
									customerBean.setUsername(username); 
									customerBean.setRol(rol);
									response.sendRedirect("../../home.html"); //TODO
								}
							}
							else{
								HttpSession session = request.getSession();
								CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
								String username = u.getUsername();
								String rol = u.getRol();
								customerBean.setEmailUser(mail); 
								customerBean.setUsername(username); 
								customerBean.setRol(rol);
								response.sendRedirect("../../homeAdmin.html"); //TODO
							}
						}
						else{
							response.sendRedirect("../../userBadPass.html"); 
						}
					}
					
				}
			}
	}
} 