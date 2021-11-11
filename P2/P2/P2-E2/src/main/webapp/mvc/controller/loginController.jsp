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
		UserDAO userDAO = new UserDAO();
		String passwd = userDAO.requestCredenciales(mail);
		ArrayList<UserDTO> users = userDAO.requestUsers();
		
		for(UserDTO u : users){
			if(u.getMail().equals(mail)){
				if (passwd.equals(password)){
					String username = u.getUsername();
					LocalDateTime regTime = u.getRegisterTime();
					%>
					<jsp:setProperty property="userName" value="<%=username%>" name="customerBean"/>
					<jsp:setProperty property="regTime" value="<%=regTime%>" name="customerBean"/>
					<%
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