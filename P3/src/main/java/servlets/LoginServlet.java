package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import data.DAOs.userDAO;

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet")

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("password");
		
		
				if (mail != null) {
					String url = request.getParameter("url");
					String userC = request.getParameter("user");
					String passwd = request.getParameter("password");
					
					UserDAO userDAO = new UserDAO(url,userC,passwd);
					String pass = userDAO.requestCredenciales(mail);
					ArrayList<UserDTO> users = userDAO.requestUsers();
					
					for(UserDTO u : users){
						if(u.getMail().equals(mail)){
							if (password.equals(pass)){
								if(u.getRol().equals("usuario")){
									String username = u.getUsername();
									String rol = u.getRol();
									customerBean.setEmailUser(mail); 
									customerBean.setUsername(username); 
									customerBean.setRol(rol);
									response.sendRedirect("../../userLogged.html"); //TODO
								}
								
								else{
									String username = u.getUsername();
									String rol = u.getRol();
									customerBean.setEmailUser(mail); 
									customerBean.setUsername(username); 
									customerBean.setRol(rol);
									
									response.sendRedirect("../../adminLogged.html"); //TODO
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