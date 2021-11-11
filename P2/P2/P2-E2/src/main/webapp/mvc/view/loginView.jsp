<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<%
String nextPage = "../controller/loginController.jsp";
String messageNextPage = request.getParameter("message");
if (messageNextPage == null) messageNextPage = "";

if (customerBean != null && !customerBean.getEmailUser().equals("")) {
	nextPage = "../../index.jsp";
} else {
%>
<%= messageNextPage %><br/><br/>
Bienvenido a nuestro sistema:

<form method="post" action="../controller/loginController.jsp">
	<fieldset>
		<legend>Log In</legend>
		Mail:<br>
		<input type="email" name="Mail" value="usermail@mail.com"> <br>
		Password:<br>
		<input type="password" name="Password" value="Password"> <br><br>
		<input type="button" value="Login">
		<input type="button" value="Sign Up">
	</fieldset>
</form>
<%
}
%>

</body>
</html>