<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Log in</title>
		</head>
		
		<body>
		<h3>Inicio de sesion</h3>
		
			<form method="post" action="../../P3/LoginServlet">
				<fieldset>
					<legend>Log In</legend>
					Mail:<br>
					<input type="email" name="Mail" value="usermail@mail.com"> <br>
					Password:<br>
					<input type="password" name="Password" value="Password"> <br><br>
					<input type="submit" value="Login">
				</fieldset>
			</form>
		<br>
		<p>¿No estas registrado? Registrate.</p>
		<input type="button" value="Aqui" onClick = "window.location.href='/P3/views/registerView.jsp';">
		
		</body>
	</html>