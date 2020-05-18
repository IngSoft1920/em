<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/perfil.css"> <!--carpeta donde se encuentra el estilo css-->

<script type="text/javascript">
// Variable global por estar declarada sin hacer uso de var

function activar(){
   document.getElementById('in').disabled = false;
   document.getElementById('out').disabled = true;
   alert("Se ha guardado tu check-in correctamente")
 }

 function activar2(){
    document.getElementById('in').disabled = true;
    document.getElementById('out').disabled = false;
    alert("Se ha guardado tu check-out correctamente")
  }

	</script>
	
	
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
          <li><a href="/menu9" class="enlace">Inicio</a></li>
          <li><a href="/nomina9" class="enlace">Nomina</a></li>
          <li><a href="/turnos9" class="enlace">Turnos</a></li>
          <li><a href="/tareas9" class="enlace">Tareas</a></li>
          <li><a href="/ausencias9" class="activate-menu">Ausencias</a></li>
          <li><a href="/perfil9" class="enlace">Perfil</a></li>
          <li><a href="/registro9" class="enlace">Registro</a></li>
          <li><a href="/cerrar9" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>

    </div>
  </header>



<body>
	<u1>
		<c:forEach var="bajas" items="${bajas}">
		<section id="publicaciones">
      		<article class="post">
        			<h1 class="titulo-post">Solicitud de: <td>Bajas<br></td></h1>
          			<h1 class="titulo-post">Nombre: <td>${bajas.nombre}<br></td></h1>
          			<h1 class="titulo-post">Correo: <td>${bajas.correo}<br></td></h1>
          			<h1 class="titulo-post">Duracion: <td>${bajas.fecha_inicio} -> ${bajas.fecha_fin}<br></td></h1>
          			<h1 class="titulo-post">Motivo: <td>${bajas.tipo}<br></td></h1>
                   	<form action="/denegarBaja/${bajas.id}"  method="POST">
            		<input type="submit" value="Denegar"/>
            		</form>
            		<form action="/aceptarBaja/${bajas.id}"  method="POST">
            		<input type="submit" value="Aceptar"/>
            		</form>
        		
      		</article>
		</section>
		</c:forEach>
	</u1>
	
	<u1>
		<c:forEach var="vacaciones" items="${vacaciones}">
		<section id="publicaciones">
      		<article class="post">
        			<h1 class="titulo-post">Solicitud de: <td>Vacaciones<br></td></h1>
          			<h1 class="titulo-post">Nombre: <td>${vacaciones.nombre}<br></td></h1>
          			<h1 class="titulo-post">Correo: <td>${vacaciones.correo}<br></td></h1>
          			<h1 class="titulo-post">Duracion: <td>${vacaciones.fecha_inicio} - ${vacaciones.fecha_fin}<br></td></h1>
          			<form action="/denegarVacaciones/${vacaciones.id}"  method="POST">
            		<input type="submit" value="Denegar"/>
            		</form>
            		<form action="/aceptarVacaciones/${vacaciones.id}"  method="POST">
            		<input type="submit" value="Aceptar"/>
            		</form>
            
        		
      		</article>
		</section>
		</c:forEach>
	</u1>
	
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