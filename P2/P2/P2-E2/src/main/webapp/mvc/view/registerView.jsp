<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register view</title>
</head>
<body>
<%
String nextPage = "../controller/registerController.jsp";
String messageNextPage = request.getParameter("message");
if (messageNextPage == null) messageNextPage = "";

if (customerBean != null && !customerBean.getEmailUser().equals("")) {
	nextPage = "../../index.jsp";
} else {
%>
<%= messageNextPage %><br/><br/>
Si desea registrarse, introduzca los siguientes datos. 
<form method="post" action="../controller/loginController.jsp">
	<label for="name">Name: </label>
	<input type="text" name="name" value="Name"><br/>
	<label for="email">Email: </label>
	<input type="text" name="email" value="username@mail.com">
	<label for="username">Username: </label>
	<input type="text" name="username" value="username"><br/>
	<label for="password">Email: </label>
	<input type="password" name="password" value="password">
	<label for="rol">Rol: </label>
	<input type="text" name="rol" value="usuario"><br/>
		
	<br/>
	<input type="submit" value="Registrar">
</form>
<%
}
%>

</body>
</html>