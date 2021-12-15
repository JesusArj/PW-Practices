<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR! Log In erroneo</title>
</head>
<body>
<h4>Error</h4>
Error. El inicio de sesión no existe. Pulse <a href=<%= request.getContextPath() + "/index.jsp" %>>Aqui</a> para volver a iniciar sesion
</body>
</html>