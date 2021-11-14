<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de criticas</title>
</head>
<body>
<% 
//Este código de reset es únicamente para poder probar múltiples veces el MVC
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="emailUser" value="" name="customerBean"/>
<jsp:setProperty property="userName" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getEmailUser()=="") 
{
	// Usuario no logado -> Se invoca al controlador de la funcionalidad
%>
<h2>Bienvenido a nuestro sistema</h2>
¿Qu&eacute; desea hacer?

<a href="/P2-E2/mvc/controller/loginController.jsp">Login</a>
<a href="/P2-E2/mvc/controller/registerController.jsp">Register</a>

<% 	
} 
else 
{ 
	if(customerBean.getRol().equals("usuario")) {
	String user = customerBean.getUsername();
%>
	¡¡Bienvenido <%=customerBean.getUsername()%>!!<br>
	Hoy es <%= (new java.util.Date()).toString()%> <br>
	Te registraste el <%=customerBean.getRegisterTime()%><br>
		
	<% 
	}
	else{
	//ADMIN PRINTjsp v		
		}
	} 
%>
	
</body>
</html>