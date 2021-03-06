<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/perfil.css"> <!--carpeta donde se encuentra el estilo css-->


</head>

<body>

	
	<jsp:useBean id="sesionActual" class="ingsoft1920.em.Beans.DatoEmpleadoBean" scope="application"/>
	
	
	
  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        PERFIL
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu2" class="enlace">Inicio</a></li>
          <li><a href="/nomina2" class="enlace">N�mina</a></li>
          <li><a href="/turnos2" class="enlace">Turnos</a></li>
          <li><a href="/tareas2" class="enlace">Tareas</a></li>
          <li><a href="/ausencias2" class="enlace">Ausencias</a></li>
          <li><a href="/perfil2" class="activate-menu">Perfil</a></li>
          <li><a href="/registro2" class="enlace">Registro</a></li>
          <li><a href="/cerrar2" class="enlace">Cerrar Sesi�n</a></li>
        </ul>
      </div>

    </div>
  </header>



<body>

	
		
		<section id="publicaciones">
      		<article class="post">
        		
          			<h1 class="titulo-post">Nombre: <td>${empleado.nombre }<br></td></h1>
        		
      		</article>
		</section>
		
		<section id="publicaciones">
      		<article class="post">
        		
          			<h1 class="titulo-post">Tel�fono: <td>${empleado.telefono }<br></td></h1>
        		
      		</article>
		</section>
		
		<section id="publicaciones">
      		<article class="post">
        		
          			<h1 class="titulo-post">Correo: <td>${empleado.correo }<br></td></h1>
        		
      		</article>
		</section>
		
		<section id="publicaciones">
      		<article class="post">
        		
          			<h1 class="titulo-post">Rol: <td>${empleado.nombre_rol }<br></td></h1>
        		
      		</article>
		</section>
		
		<section id="publicaciones">
      		<article class="post">

          			<input type="submit" value="CAMBIO CONTRASE�A" name="accion" id="buttons" onclick="window.location='/contrasena';"/>
        		
      		</article>
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
  width: 99%;
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
  padding:10px;
  height: auto; overflow: hidden;
  border: 0px solid red; /*significa que es rojo*/
  margin-top: 0px;
  float:left;
}

  .post{ /*aplicar estilo a cada articulo. Espacios del texto*/
    width: 96%;
    height: auto; overflow: hidden;
    padding: 10px 7px;
    background: #fff;
    border-Left-style: solid;
    border-Left-width: 5px;
    border-Left-color: #0489B1;
    border-radius: 10px;
    box-shadow: 0px 0px 15px #ccc;/*color gris*/
    margin-bottom: 25px;
  }

.enlace-post{
 text-decoration: none;
}


.menu > li{

  position:relative;
  display: inline-inline-block;
  float:left;
}

.menu > li > a{
  display: block;
  padding: 5px 20px;
  color: #353535;
  font-family: 'Open sans';
  text-decoration: none;

}


.menu li a:hover{
  color: #CE7D35;


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