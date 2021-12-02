package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import data.DAOs.userDAO;

@WebServlet(name="RegisterServlet", urlPatterns="/RegisterServlet")

public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("password");
		String rol = request.getParameter("rol");
		String username = request.getParameter("username");
		String name = request.getParamater("name");
		LocalDateTime regTime = LocalDateTime.now();
		
		if (mail != null) {
			String url = application.getInitParameter("url");
			String userC = application.getInitParameter("user");
			String passwd = application.getInitParameter("password");
			
			UserDAO userDAO = new UserDAO(url,userC,passwd);
			
			ArrayList<UserDTO> users = userDAO.requestUsers();
			Boolean error = false;
			
			for(UserDTO u : users){
				if(u.getMail().equals(mail)){
					response.sendRedirect("../../userExistError.html"); //TODO
					error = true;
				}
			}
			if(!error){
				UserDTO newUser = new UserDTO(name, mail, username, password, rol, regTime);
				userDAO.createUser(newUser);
				customerBean.setUsername(username); 
				customerBean.setRol(rol); 
				customerBean.setRegisterTime(regTime); 
			}
		} else {
			response.sendRedirect("../view/registerView.html");//TODO
			}
		} else {
			response.sendRedirect("../view/registerView.html");//TODO		
	}
	}
} 