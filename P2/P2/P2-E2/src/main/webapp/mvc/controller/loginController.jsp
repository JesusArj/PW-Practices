<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.DTOs.UserDTO,es.uco.pw.data.DAOs.UserDAO, java.util.ArrayList, java.time.LocalDateTime" %>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%

String nextPage = "../../index.jsp";
String mensajeNextPage = "";
if (customerBean == null || customerBean.getEmailUser().equals("")) {
	String mail = request.getParameter("email");
	String password = request.getParameter("password");

	if (mail != null) {
		String file =application.getInitParameter("properties");
		String url = application.getInitParameter("url");
		String userC = application.getInitParameter("user");
		String passwd = application.getInitParameter("password");
		java.io.InputStream myIO = application.getResourceAsStream(file);
		
		UserDAO userDAO = new UserDAO(myIO,url,userC,passwd);
		String pass = userDAO.requestCredenciales(mail);
		ArrayList<UserDTO> users = userDAO.requestUsers();
		
		for(UserDTO u : users){
			if(u.getMail().equals(mail)){
				if (passwd.equals(pass)){
					if(u.getRol().equals("usuario")){
						String username = u.getUsername();
						LocalDateTime regTime = u.getRegisterTime();
						String rol = u.getRol();
						%>
						<jsp:setProperty property="emailUser" value="<%=mail%>" name="customerBean"/>
						<jsp:setProperty property="userName" value="<%=username%>" name="customerBean"/>
						<jsp:setProperty property="regTime" value="<%=regTime%>" name="customerBean"/>
						<jsp:setProperty property="rol" value="<%=rol%>" name="customerBean"/>
						<%
					}
					else{
						nextPage = "../../userBadPass.jsp";
						mensajeNextPage = "Wrong password";
					}
				}
				else{
					
				}
			}
		}
	} else {
		nextPage = "../view/loginView.jsp";
		mensajeNextPage = "El usuario que ha indicado no existe o no es v&aacute;lido";
		}
	} else {
		nextPage = "../view/loginView.jsp";		
	}

%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>