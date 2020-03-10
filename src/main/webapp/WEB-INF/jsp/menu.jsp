<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/perfil.css"> <!--carpeta donde se encuentra el estilo css-->


</head>

<body>

  <header class="header">
    <div id="encabezado">
      <div id="logo">
        PORTAL EMPLEADOS
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu" class="activate-menu">Inicio</a></li>
          <li><a href="/nomina" class="enlace">Nomina</a></li>
          <li><a href="/turnos" class="enlace">Turnos</a></li>
          <li><a href="/tareas" class="enlace">Tareas</a></li>
          <li><a href="/ausencias" class="enlace">Ausencias</a></li>
          <li><a href="/perfil" class="enlace">Perfil</a></li>
          <li><a href="/registro" class="enlace">Registro</a></li>
          <li><a href="/cerrar" class="enlace">Cerrar Sesion</a></li>
          <li><a href="/volver" class="enlace">Volver</a></li>
        </ul>
      </div>
    </div>
  </header>



  <div id="principal1">

    <div id="publicaciones1">
      <article class="cuerpo-nomina">
        <a href="/nomina" class="enlace-nomina">
        <h2 class="nomina"> NOMINA </h2>
        </a>
        <img src="/img/nomina.jpg" class="img-post1">
      </article>
    </div>

    <div id="sidebar1">
    </div>




    <div id="publicaciones2">
      <article class="cuerpo-tarea">
        <a href="/perfil" class="enlace-tarea">
        <h2 class="tarea"> PERFIL </h2>
        </a>
        <img src="/img/perfill.jpg" class="img-post2">
      </article>
    </div>


    <div id="sidebar2">
    </div>

  </div>

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
  color: #fff;
  border-radius: 5px 5px 0px 0px;
  padding: 10px;
}


/*----------contenido principal ------------*/

/*NOMINAAAAAAA*/
#principal1{ /*para cambiar el contenido de nomina*/
  padding:10px;
  
}

#publicaciones1{
  width: 300px;
  float:left;
  padding:10px;
  margin:80px; /*NOMINAAAAAAA*/
  margin-left:150px;
}

#publicaciones2{
  width: 330px;
  float:left;
  padding:10px;
  margin:40px;
  margin-left:290px;
}


.cuerpo-nomina{
  width: 99%;
  height: auto; overflow: hidden;
  padding: 15px;
  background: #fdfdfd;
  border-style: solid;
  border-width: 5px;
  border-color: #048981;
  border-radius: 10px;
  margin-bottom: 35px;
}

.enlace-nomina{
  text-decoration: none;
}

#publicaciones1 a .nomina{ /*titulo-post*/
  color: #6e6e6e;
  font-size: 40px;
  font-family: 'calibri light';
  margin-left: 35px; /*CENTRAR LA IMAGEN*/
}

#publicaciones1 a .nomina:hover{ /*PARA QUE ME SUBRAYE EL TEXTO CUNDO PASO SOBE EL*/
  text-decoration: underline;
}

#publicaciones1 .img-post1{
  width: 150px;
  height: 100px;
  float: left;
  margin-top: 7px; /*PARA BAJAR LA IMAGEN*/
  margin-left: 70px; /*CENTRAR LA IMAGEN*/
}

/*TAREAAAASSSSSSS*/


.cuerpo-tarea{
  width: 99%;
  height: auto; overflow: hidden;
  padding: 15px;
  background: #fdfdfd;
  border-style: solid;
  border-width: 5px;
  border-color: #048981;
  border-radius: 10px;
  margin-bottom: 5px;
  margin-left:0px;
}

.enlace-tarea{
  text-decoration: none;
}

#publicaciones2 a .tarea{ /*titulo-post*/
  color: #6e6e6e;
  font-size: 40px;
  font-family: 'calibri light';
  margin-left: 45px; /*CENTRAR LA IMAGEN*/
}

#publicaciones2 a .tarea:hover{ /*PARA QUE ME SUBRAYE EL TEXTO CUNDO PASO SOBE EL*/
  text-decoration: underline;
}

#publicaciones2 .img-post2{
  width: 150px;
  height: 100px;
  float: left;
  margin-top: 7px; /*PARA BAJAR LA IMAGEN*/
  margin-left: 90px; /*CENTRAR LA IMAGEN*/
}


          
            
    </style>


</html>
