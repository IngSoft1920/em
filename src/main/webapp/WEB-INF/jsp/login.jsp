 <html>
<head>
	<meta charset="utf-8">
	<title>Página de inicio de empleados</title> 
</head>
<body>
	<div>
		<h1 text-align = "center">
		<br>
			 Login Empleados
		</h1>
	</div>
	<form method="POST" 
		modelAttribute="loginBean" style = "font-family:courier;">
		
		<label>Usuario</label>
			<form:input type="text" name="usuario" path="usuario" />
			<input type="text" name="Usuario" required=true" > 
		<br>
		<label>Contraseña</label>
			<form:input type="password" name="password" path="password" />
			<input type="password" name="Password" required=true>
		<br>
		<input type="submit" value="Login">
		<br>
	</form:form>
</body>
<style>
            
            body{
                text-align: center;
                color: Black;
                background-color:399D9A ;
                 padding: 5px;
                 font-size: 18px;
            }
          
            
    </style>
</html>