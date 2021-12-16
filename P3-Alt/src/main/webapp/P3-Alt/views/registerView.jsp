<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Register</title>
		<style type="text/css">
			h3, form {
				text-align: center; 
				float: center;
			}
			
		
		</style>
		</head>
		
		<body>
		<h3>Registro de usuario</h3>
		
			<form method="post" action="../../../P3-Alt/RegisterServlet">
				<fieldset>
					<legend>Register</legend>
					Mail:<br>
					<input type="email" name="Mail" value="usermail@mail.com"> <br>
					Password:<br>
					<input type="password" name="Password" value="Password"> <br>
					Name:<br>
					<input type="text" name="Name" value="Paco Sanz"><br>
					Username: <br>
					<input type="text" name="Username" value="PacoSanz123"><br>
					<label for="rol">Rol: </label><br/>
					<select name="rol">
						<option value="Admin">Administrador</option>
						<option value="User">Usuario</option>
					</select>
					<br>
					<br>
					<input type="submit" value="Register">
				</fieldset>
			</form>
		</body>
	</html>