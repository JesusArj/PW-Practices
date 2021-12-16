<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	h1, h2{
	float: center;
	text-align: center;
	font-size: 5em;
	}
	
	h2 {
		font-size: 3em;
	}
	a.log {
	  float: left;
	  height: 40%;
	  width: 40%;
	  margin: 1%;
	  padding: 1%;
	  overflow: hidden;
	  background-color: #333;
	}
	a.reg{
	  float: right;
  	  height: 40%;
  	  width: 40%;
	  margin: 1%;
	  padding: 1%;
	  overflow: hidden;
	  background-color: #333;
	}
	
	a {
	  display: block;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}

	a:hover:not(.active) {
  		background-color: #111;
	}

	body {
		background-color: white;
	}
</style>
<jsp:useBean  id="customerBean" scope="session" class="beans.CustomerBean"></jsp:useBean>
<title>Sistema de criticas</title>
</head>
<body>
<% 
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="emailUser" value="" name="customerBean"/>
<jsp:setProperty property="userName" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getEmailUser().equals("")) 
{
%>
<h1>Critics&Fun</h1>
<h2>Bienvenido a nuestro sistema, ¿Que desea hacer?</h2>
<br>
<a class="log" href="/P3-Alt/P3-Alt/views/loginView.jsp">Login</a>
<a class="reg" href="/P3-Alt/P3-Alt/views/registerView.jsp">Register</a>

<% 	
} 
else 
{ 
	if(customerBean.getRol().equals("User")) {
	 	String redirectUrl = request.getContextPath() + "/P3-Alt/views/home.jsp";
	 	response.sendRedirect(redirectUrl);
	}
	else{
		String redirectUrl = request.getContextPath() + "/P3-Alt/views/homeAdmin.jsp";
	 	response.sendRedirect(redirectUrl);		
	}
} 
%>
	
</body>
</html>
