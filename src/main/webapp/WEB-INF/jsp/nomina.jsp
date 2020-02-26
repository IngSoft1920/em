
<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO: </title>
  <link rel="stylesheet" type="text/css" href="css/estilonom.css"> <!--carpeta donde se encuentra el estilo css-->


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
        PORTAL EMPLEADOS
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu3" class="enlace">Inicio</a></li>
          <li><a href="/nomina3" class="activate-menu">Nomina</a></li>
          <li><a href="/turnos3" class="enlace">Turnos</a></li>
          <li><a href="/tareas3" class="enlace">Tareas</a></li>
          <li><a href="/vacaciones3" class="enlace">Vacaciones</a></li>
          <li><a href="/bajas3" class="enlace">Bajas</a></li>
          <li><a href="/perfil3" class="enlace">Perfil</a></li>
          <li><a href="/cerrar3" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>

    </div>
  </header>

  <section id="principal">
    <section id="publicaciones">
      <article class="post">


        <a href="" class="enlace-post">
          <h2 class="titulo-post">Visualizar nomina: </h2>
        </a>

        <table border="tabla">

          <thead>
          <tr>
            <th>Nomina</th>
          </tr>
          </thead>

          <tbody>
          <tr>
            <td>

              <nav class="nav">
              <ul class="menu">

              <li><a> Elige un mes </a>
                  <ul class="submenu">
                      <li><a href="/ejemplo">Enero</a></li>
                      <li><a href="/ejemplo">Febrero</a></li>
                      <li><a href="/ejemplo">Marzo</a></li>
                      <li><a href="/ejemplo">Abril</a></li>
                      <li><a href="/ejemplo">Mayo</a></li>
                      <li><a href="/ejemplo">Junio</a></li>
                      <li><a href="/ejemplo">Julio</a></li>
                      <li><a href="/ejemplo">Agosto</a></li>
                      <li><a href="/ejemplo">Septiembre</a></li>
                      <li><a href="/ejemplo">Octubre</a></li>
                      <li><a href="/ejemplo">Noviembre</a></li>
                      <li><a href="/ejemplo">Diciembre</a></li>
                  </ul>
              </li>

              </ul>
              </nav>

            </td>
          </tr>
          </tbody>

        </table>
 
      </article>
    </section>
  </section>

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
  width: 100%;
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
  margin: 0px auto;
}

#publicaciones{
  width: 20%;
  height: auto; overflow: hidden;
  border: 0px solid red; /*significa que es rojo*/
  margin-top: 10px;
  margin-left: 390px;
  float:middle;
}

  .post{ /*aplicar estilo a cada articulo. Espacios del texto*/
    width: 99%;
    height: 90%; overflow: hidden;
    padding: 15px;
    background: #fff;
    /*border-Left-style: solid;
    border-Left-width: 5px;
    border-Left-color: #048981;
    border-radius: 10px;
    box-shadow: 0px 0px 15px #ccc;/*color gris*/
    margin-bottom: 25px;
  }

.enlace-post{
 text-decoration: none;
 padding: 5px;
 height: 5px;
 color: #01a9db;

}


.menu > li{

  position:relative;
  display: inline-inline-block;
  float:right;
}

.menu > li > a{
  display: block;
  padding: 20px 20px;

  font-family: 'Open sans';
  text-decoration: none;

}


.menu li a:hover{
  color: #048981;


}

.submenu{
  position: absolute;
  background: #006480;
  visibility: hidden;
  opacity: 0;
  list-style: none;


}

.submenu li a{
  display: block;
  color: #ffff;
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