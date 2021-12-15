package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.UserDTO;
import data.DAOs.UserDAO;
import beans.CustomerBean;

@WebServlet(name="RegisterServlet", urlPatterns="/RegisterServlet")

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 2712014577923922790L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String mail = request.getParameter("Mail");
		System.out.println(mail);
	
		if (mail != null) {
			String url = request.getParameter("url");
			String pass = request.getParameter("password");
			String rol = request.getParameter("rol");
			String username = request.getParameter("username");
			String name = request.getParameter("name");
			LocalDateTime regTime = LocalDateTime.now();
			UserDAO userDAO = new UserDAO(url,username,pass);
			
			ArrayList<UserDTO> users = userDAO.requestUsers();
			Boolean error = false;
			
			for(UserDTO u : users){
				if(u.getMail().equals(mail)){
					response.sendRedirect("../../userExistError.html"); //TODO
					error = true;
				}
			}
			if(!error){
				UserDTO newUser = new UserDTO(name, mail, username, pass, rol, regTime);
				userDAO.createUser(newUser);
				HttpSession session = request.getSession();
				CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
				customerBean.setUsername(username); 
				customerBean.setRol(rol); 
				customerBean.setRegisterTime(regTime); 
			}
		} else {
			response.sendRedirect("/P3/views/registerView.jsp");//TODO
		}
	}
} 