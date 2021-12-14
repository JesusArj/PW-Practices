<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
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
<h2>Bienvenido a nuestro sistema</h2>
¿Que desea hacer?

<a href="/P3/views/loginView.jsp">Login</a>
<a href="/P3/views/registerView.jsp">Register</a>

<% 	
} 
else 
{ 
	if(customerBean.getRol().equals("usuario")) {
	 	String redirectUrl="/views/home";
	 	response.sendRedirect(redirectUrl);
	}
	else{
		String redirectUrl="/views/homeAdmin";
	 	response.sendRedirect(redirectUrl);		
	}
} 
%>
	
</body>
</html>

