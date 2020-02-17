<html>
<head>
	<meta charset="utf-8">
	<title>Página de inicio de empleados</title> 
</head>
<body>
	<div>
		<h1 text-align = "center">
		<br>
			Registro de Empleados
		</h1>
	</div>
	<form method="POST" action="Pagina Empleados.html"
		modelAttribute="signupBean" style = "font-family:courier,arial,helvética;">
		<label>Usuario</label>
			<form:input type="text" name="usuario" path="usuario" />
			<input type="text" name="Usuario" required=true" > 
		<br>
		<label>Contraseña</label>
			<form:input type="password" name="password" path="password" />
			<input type="password" name="Contraseña" required=true>
		<br>
		<input type="submit" value="Login">
		<br>
	</form:form>
</body>
<style>
            
            body{
                text-align: left;
                color: Black;
                background-color:399D9A ;
                 padding: 5px;
                 font-size: 18px;
            }
          
            
    </style>
</html>