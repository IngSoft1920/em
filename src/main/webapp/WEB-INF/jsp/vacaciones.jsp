<html lan="es">

<head>
 	<meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
 	<title> USUARIO  : </title> <!--Título-->
	<link rel="stylesheet" type="text/css" href="css/vacaciones.css"> <!--carpeta donde se encuentra el estilo css-->
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	


<script type="text/javascript">

$(function() {
    $("#inicio").datepicker({ dateFormat: "yy-mm-dd" }).val()
});


$(function() {
    $("#fin").datepicker({ dateFormat: "yy-mm-dd" }).val()
});


function mensaje(){

var todo_correcto=true;

if(document.getElementById('inicio').value==''){
todo_correcto=false;
}
if(document.getElementById('fin').value==''){
todo_correcto=false;
}

if(!todo_correcto){
alert('Debes rellenar todos los campos');
}

if(todo_corecto){

alert('Se ha enviado tu peticion correctamente');
}

}
</script>

</head>


<body>
	
  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        VACACIONES
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu7" class="enlace">Inicio</a></li>
          <li><a href="/nomina7" class="enlace">Nomina</a></li>
          <li><a href="/turnos7" class="enlace">Turnos</a></li>
          <li><a href="/tareas7" class="enlace">Tareas</a></li>
          <li><a href="/ausencias7" class="activate-menu">Ausencias</a></li>
          <li><a href="/perfil7" class="enlace">Perfil</a></li>
          <li><a href="/registro3" class="enlace">Registro</a></li>
          <li><a href="/cerrar7" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>

    </div>
  </header>
 
 	<u1>			
 	<b>dias restantes:</b> ${diasRestantes} <br>
	</u1>	

 
<form method="POST" 	action="aniadeVacaciones"	modelAttribute="VacacionBean">
 
  <section id="principal">
    <section id="publicaciones">
      <article class="post">
          <h1 class="titulo-post">Desde
            <td><input type="text" name="fecha_inicio" id="inicio" required></td>
          </h1>
      </article>
      </section>

    <section id="publicaciones">
      <article class="post">
          <h1 class="titulo-post">Hasta
            <td><input type="text" name="fecha_fin" id="fin" required></td>
          </h1>
      </article>
	</section>			
	
    <section id="publicaciones">
   	<input type="submit" value="Enviar" onClick="mensaje()">
   	</section>
	</section>
</form>



<input type="submit" value="Ver Vacaciones" onclick="window.location='/verVacaciones'" />

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
  border: 0px solid #fff;
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
  border: 0px solid #fff;
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
  
  
  
  </style>

  </html>
