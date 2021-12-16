<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Log in</title>
		<style type="text/css">
			h3 {
				text-align: center;
			}	
			
			form,p,input {
				text-align: center;
			}
			
	
		</style>
		</head>
		
		<body>
		<h3>Inicio de sesion</h3>
		
			<form method="post" action="../../../P3-Alt/LoginServlet">
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
		<br>
		<input class=boton type="button" value="Aqui" onClick = "window.location.href='/P3-Alt/P3-Alt/views/registerView.jsp';">
		
		</body>
	</html>