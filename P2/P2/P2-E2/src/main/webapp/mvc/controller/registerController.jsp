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
	String username = request.getParameter("username");
	String name = request.getParameter("name");
	String rol = rquest.getParameter("rol");
	
	if (mail != null) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserDTO> users = userDAO.requestUsers();
		Boolean error = false;
		
		for(UserDTO u : users){
			if(u.getMail().equals(mail)){
				nextPage = "../view/UserExistError.jsp";
				error = true;
			}
		}
		if(!error){
			UserDTO newUser(String name, String mail, String username, String passwd, String rol);
			userDAO.createUser(newUser);
			%>
			<jsp:setProperty property="userName" value="<%=username%>" name="customerBean"/>
			<jsp:setProperty property="regTime" value="<%=regTime%>" name="customerBean"/>
			<%
		}
	}
}
		

%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>