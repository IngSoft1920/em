<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/estilotarea.css"> <!--carpeta donde se encuentra el estilo css-->


</head>

<body>

<%

	String UsuarioIn=" ",ContraseniaIn=" ";
	if(request.getParameter("usuario")!=null){
		UsuarioIn=request.getParameter("usuario");
	}
	
	if(request.getParameter("contrasenia")!=null){
		ContraseniaIn=request.getParameter("contrasenia");
	}


	%>
	
	<jsp:useBean id="sesionActual" class="ingsoft1920.em.Beans.DatoEmpleadoBean" scope="application"/>
	<jsp:setProperty name="sesionActual" property="usuario" value="<%=UsuarioIn%>"/>
	<jsp:setProperty name="sesionActual" property="contrasenia" value="<%=ContraseniaIn%>"/>
	
	<table>
	<tr><td>Nombre: </td><td><jsp:getProperty name="sesionActual" property="usuario"/></td></tr>
	</table>


  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        TAREAS
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu4" class="enlace">Inicio</a></li>
          <li><a href="/nomina4" class="enlace">Nomina</a></li>
          <li><a href="/tareas4" class="activate-menu">Tareas</a></li>
          <li><a href="/perfil4" class="enlace">Perfil</a></li>
          <li><a href="/cerrar4" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>

    </div>
  </header>

  <section id="principal">
    <section id="publicaciones">
      <article class="post">

        <a href="" class="enlace-post">
          <h2 class="titulo-post">Lista de tareas</h2>
        </a>
        <a href="" class="enlace-post2">
          <h2 class="titulo-post">.</h2>
        </a>

        <table border="1">
          <thead>
          <tr>
            <th>Nombre empleado</th>
            <th>Numero habitacion</th>
            <th>Debe estar lista antes de:</th>
            <th>Estado habitacion</th>
            <th>Comentarios</th>
          </tr>
          </thead>

          <tbody>
          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">

              <ul class="menu">

              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Lista</a>
                      <li><a href="a">En proceso</a>
                      <li><a href="a">No lista</a>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>
          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a></li>
                      <li><a href="a">Ocupada</a></li>
                      <li><a href="a">Disponible</a></li>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>


          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a>
                      <li><a href="a">Ocupada</a>
                      <li><a href="a">Disponible</a>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>
          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a>
                      <li><a href="a">Ocupada</a>
                      <li><a href="a">Disponible</a>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>
          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a>
                      <li><a href="a">Ocupada</a>
                      <li><a href="a">Disponible</a>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>
          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a>
                      <li><a href="a">Ocupada</a>
                      <li><a href="a">Disponible</a>

                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>

          <tr>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
            <td>
              <nav class="nav">
              <ul class="menu">
              <li><a href="a">Estado habitacion</a>
                  <ul class="submenu">
                      <li><a href="a">Reservada</a>
                      <li><a href="a">Ocupada</a>
                      <li><a href="a">Disponible</a>
                  </ul>

              </li>
              </ul>
              </nav>
            </td>
            <td><input type="text" name="buscar" placeholder="Escribe aqui"></td>
          </tr>


          </tbody>
        </table>

      </article>
    </section>
  </section>
</body>


<style>

*{
  margin: 0;
  padding: 0;

}

body{
  background: #fff;
  font-family: calibri;

}

header{
  background: #01a9db;
  width: 100%;
  height: 100px;
  box-shadow: 0px 0px 30px;
}

#encabezado{
  width: 80%;
  height: 30px;
  margin: auto;
  border: 0px solid #000;
}

#logo{
  width: 30%;
  height: auto; overflow: hidden;
  float: left;
  color: #fff;
  font-size: 30px;
  margin-top: 30px;
}

#menu{
  width: 60%;
  height: 90px;
  border: 0px solid;
  float: right;
  margin-top: 55px;
}

#menu ul{}

#menu ul li{
  list-style: none;
  display: inline-block;
  margin-top: 10px;
}

#menu ul li .enlace{
  text-decoration: none;
  padding: 10px 20px;
  font-size: 20px;
  color: #fff

}

#menu ul li .enlace:hover{
  background: #585858;
  color: #fff;
  border-radius: 5px 5px 0px 0px;
}

#menu ul li .activate-menu{
  background: #585858;
  padding: 10px;
  color: #fff;
  border-radius: 5px 5px 0px 0px;
}


/*--------contenido principal ---------*/


#principal{
  width: 80%;
  height: auto; overflow: hidden;
  border: 0px solid; /* si no le ponemos nada significa negro*/
  margin: 10px auto;
}

#publicaciones{
  width: 70%;
  height: auto; overflow: hidden;
  border: 0px solid red; /*significa que es rojo*/
  margin-top: 10px;
  float:left;
}

  .post{ /*aplicar estilo a cada articulo. Espacios del texto*/
    width: 100%;
    height: auto; overflow: hidden;
    padding: 10px 20px 20px 20px;
    background: #fdfdfd;
    border-Left-style: solid;
    border-Left-width: 5px;
    border-Left-color: #0489B1;
    border-radius: 10px;
    box-shadow: 0px 0px 15px #ccc;/*color gris*/
    margin-bottom: 50px;
  }

.enlace-post{
 text-decoration: none;
 margin-bottom: 50px;
}
.enlace-post2{
 text-decoration: none;
 margin-bottom: 50px;
 color: fff;
}
/*esto es para las letras del estado*/
.menu > li{
  position:relative;
  display: inline-inline-block;
  float:right;

}

/*columna estado de la tabla*/
.menu > li > a{
  display: block;
  height: 20px;
  padding: 5px 20px 20px;
  color: #01a9db;
  font-family: 'Open sans';
  text-decoration: none;
  float: right;

}


.menu li a:hover{
  color: #CE7D35;


}

.submenu{
  position: absolute;
  background: #01a9db;
  visibility: hidden;
  opacity: 0;
  list-style: none;
}

.submenu li a{
  display: block;
  color: #fff;
  padding: 10px;
  font-family: 'Open sans';
  text-decoration: none;
  position: relative;
}

.menu li:hover .submenu{
  visibility: visible;
  opacity: 1;
  position: relative;

}

.nav li:hover > ul {
  display:block;

}

.nav li ul li{
  position: relative;

}

.nav li ul li {
  top: 0px;
}



</style>


</html>