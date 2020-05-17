<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificaciÃ³n de caracteres especiales -->
  <title> USUARIO  : </title> <!--TÃ­tulo-->
  <link rel="stylesheet" type="text/css" href="css/perfil.css"> <!--carpeta donde se encuentra el estilo css-->
</head>

<body>


	<jsp:useBean id="sesionActual" class="ingsoft1920.em.Beans.DatoEmpleadoBean" scope="application"/>

	
	
  <header class="header"> <!-- La parte de arriba de la pÃ¡gina web-->
    <div id="encabezado">
      <div id="logo">
        PERFIL
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu2" class="enlace">Inicio</a></li>
          <li><a href="/nomina2" class="enlace">Nómina</a></li>
          <li><a href="/turnos2" class="enlace">Turnos</a></li>
          <li><a href="/tareas2" class="enlace">Tareas</a></li>
          <li><a href="/ausencias2" class="activate-menu">Ausencias</a></li>
          <li><a href="/perfil2" class="enlace">Perfil</a></li>
          <li><a href="/registro3" class="enlace">Registro</a></li>
          <li><a href="/cerrar2" class="enlace">Cerrar Sesión</a></li>
        </ul>
      </div>

    </div>
  </header>

	<u1>
		<c:forEach var="baja" items="${bajas}">
		<section id="publicaciones">
      		<article class="post">
			
				<p>
					<b>ID BAJA:</b> ${baja.id_Baja} <br>
					<b>DURACION:</b> ${baja.duracion} DIAS<br>
					<b>ESTADO:</b> ${baja.estado} <br>
					<b>TIPO:</b> ${baja.tipo} <br>
					<b>FECHA INICIO:</b> ${baja.fecha_inicio} <br>
					<b>FECHA FIN:</b> ${baja.fecha_fin} <br>
										
				</p>
			        		
      		</article>
			Añadir justificante:
			<form method="post" enctype="multipart/form-data" action="/upload">
				<div class="form-group">
					<spring:message code="fileToUpload" />
					<br> <input type="file" name="file" class="btn btn-default">
					<br />
					<spring:message code="upload" var="upload" />
					<input type="submit" class="btn btn-default" value="Enviar${upload }">
					<spring:message code="pressHere" />
				</div>

			</form>


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
    background: #fdfdfd;
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
