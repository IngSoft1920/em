
<html>


<head>
	<meta http-equiv="Content-Type" content="text/html";charset="utf-8">
	<title>Pagina de inicio de empleados</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>



<body>

<%
            //Al hacer click en el botón ingresar
            if (request.getParameter("btn_ingresar") != null) 
            {
                //Crea dos strings, una para el user y otra para el password.
                String username = request.getParameter("usuario");
                String password = request.getParameter("contrasenia");
                
                //Si ambas son "admin"...
                if (username.equals("admin")&& password.equals("admin"))
                {
                    //Redirecciona al servlet 'crear_departamento.do'
                    response.sendRedirect("menu");
                }
                //Si no...
                else
                {
                    //Muestra un mensaje javascript señalando que hay daros erróneos
                    out.println("<script>alert('Usuario o contrasena incorrecta');</script>");
                }
            }
        %>

	<section class="form-login">
	<h5>Login Empleados</h5>
	
	<form action="login" method="post"/>
	
	<label>Usuario</label>
	<td><input class="controls" type="text" name="usuario" required/></td>

		
	<label>Contrasena</label>
	<td><input class="controls" type="password" name="contrasenia" required/>

	<input type="submit" name="btn_ingresar" value="Ingresar"/>
	</form>
	</section>

	
</body>

<style>

*{
  margin:0;
  padding: 0;
  box-sizing: border-box;
}

body{
  font-family: arial;
  background:#01a9db; 
}
.form-login{
  width: 400px;
  height: 340px;
  background: #4e4d4d;
  margin: auto;
  margin-top: 180px;
  box-shadow: 7px 13px 37px #000;
  padding: 20px 30px;
  border-top: 4px solid #017bab;
  color: white;

}

.form-login h5{
  margin: 0;
  text-align: center;
  height: 40px;
  margin-bottom: 30px;
  border-bottom: 1px solid;
  font-size: 20px;
}

.controls{
  width: 100%;
  border: 1px solid #017bab;
  margin-bottom: 15px;
  padding: 11px 10px;
  background: #fff;
  font-size: 14px;
  font-weight: bold;
}

.buttons{
  width: 100%;
  height: 40px;
  background: #017bab;
  border: none;
  color: white;
  margin-bottom: 16px;
}

</style>


</html>