<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<jsp:useBean  id="allUsersBean" scope="session" class="beans.AllUsersBean"></jsp:useBean>
<%@ page import="beans.AllUsersBean"%>
<%@ page import="business.UserDTO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>

<title>Panel de Administrador</title>
</head>
<body>
<% 
request.getSession().getAttribute("allUsersBean");
if (allUsersBean != null) {
%>
<h2>Bienvenido al panel de administrador</h2>

<table><caption>Usuarios registrados</caption>
<%

	for (UserDTO user : allUsersBean.getAllUsers()){
%>
<tr>
	<td>Usuario : </td><td><%= user.getUsername()%></td>
	<td>Rol : </td><td><%= user.getRol()%></td>
	<td>Fecha de registro</td><td> <%= user.getStringRegister() %></td>
	<td>Fecha de Ultima conexión </td><td><%= user.getStringLogged()%></td>
	
</tr>
<%
}
%>
</table>
<%
	}
%>

</body>
</html>