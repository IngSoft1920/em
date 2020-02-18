<html lan="es">
<head>
  <meta charset="utf-8">
  <title> USUARIO: </title>
 

</head>

<body>
  <header class="header">
    <div id="encabezado">
      <div id="logo">
        PORTAL EMPLEADOS
      </div>

      <div id="menu">
        <ul>
          <li><a href="#" class="activate-menu">Inicio</a></li>
          <li><a href="#" class="enlace">Nomina</a></li>
          <li><a href="#" class="enlace">Tareas</a></li>
          <li><a href="#" class="enlace">Perfil</a></li>
          <li><a href="#" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>
    </div>
  </header>



  <section id="principal1">

    <section id="publicaciones1">
      <article class="cuerpo-nomina">
        <a href="" class="enlace-nomina">
        <h2 class="nomina"> NOMINA </h2>
        </a>
        <img src="img/nomina.png" class="img-post1">
      </article>
    </section>

    <section id="sidebar1">
    </section>

  </section>






  <section id="principal2">

    <section id="publicaciones2">
      <article class="cuerpo-tarea">
        <a href="" class="enlace-tarea">
        <h2 class="tarea"> TAREAS </h2>
        </a>
        <img src="img/tareas.png" class="img-post2">
      </article>
    </section>


    <section id="sidebar2">
    </section>

  </section>





  <section id="principal3">

    <section id="publicaciones3">
      <article class="cuerpo-perfil">
        <a href="" class="enlace-perfil">
        <h2 class="perfil"> PERFIL </h2>
        </a>
        <img src="img/perfill.jpg" class="img-post3">
        
      </article>
    </section>


    <section id="sidebar3">
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
  color: #fff;
  border-radius: 5px 5px 0px 0px;
  padding: 10px;
}


/*----------contenido principal ------------*/

/*NOMINAAAAAAA*/
#principal1{ /*para cambiar el contenido de nomina*/
  width: 15%;
  height: auto; overflow: hidden;
  border: 0px solid;
  margin: 0px auto;
}

#publicaciones1{
  width: 500%;
  height: auto; overflow: hidden;
  border: 0px solid red; /*lo quiero quitar */
  margin-top: 10px;
}

.cuerpo-nomina{
  width: 99%;
  height: auto; overflow: hidden;
  padding: 15px;
  background: #fdfdfd;
  border-left-style: solid;
  border-left-width: 5px;
  border-left-color: #048981;
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
}

#publicaciones1 a .nomina:hover{ /*PARA QUE ME SUBRAYE EL TEXTO CUNDO PASO SOBE EL*/
  text-decoration: underline;
}

#publicaciones1 .img-post1{
  width: 150px;
  height: 100px;
  float: left;
  margin-top: 7px; /*PARA BAJAR LA IMAGEN*/
  margin-left: 17px; /*CENTRAR LA IMAGEN*/
}




/*TAREAAAASSSSSSS*/
#principal2{ /*para cambiar el contenido de nomina*/
  width: 15%;
  height: auto; overflow: hidden;
  border: 0px solid;
  margin: 0px auto;
}

#publicaciones2{
  width: 150%;
  height: auto; overflow: hidden;
  border: 0px solid red; /*lo quiero quitar */
  margin-top: 0px;
}


.cuerpo-tarea{
  width: 99%;
  height: auto; overflow: hidden;
  padding: 7px;
  background: #fdfdfd;
  border-left-style: solid;
  border-left-width: 5px;
  border-left-color: #048981;
  border-radius: 10px;
  margin-bottom: 35px;
}

.enlace-tarea{
  text-decoration: none;
}

#publicaciones2 a .tarea{ /*titulo-post*/
  color: #6e6e6e;
  font-size: 40px;
  font-family: 'calibri light';
}

#publicaciones2 a .tarea:hover{ /*PARA QUE ME SUBRAYE EL TEXTO CUNDO PASO SOBE EL*/
  text-decoration: underline;
}

#publicaciones2 .img-post2{
  width: 150px;
  height: 100px;
  float: left;
  margin-top: 7px; /*PARA BAJAR LA IMAGEN*/
  margin-left: 17px; /*CENTRAR LA IMAGEN*/
}


/*PERFILLLLLLLL*/
#principal3{ /*para cambiar el contenido de nomina*/
  width: 15%;
  height: auto; overflow: hidden;
  border: 0px solid;
  margin: 10px 1000px;
  float: left;

}

#publicaciones3{
  width: 500%;
  height: auto; overflow: hidden;
  border: 0px solid red; /*lo quiero quitar */
  margin-top: 10px;
}

.cuerpo-perfil{
  width: 99%;
  height: auto; overflow: hidden;
  padding: 15px;
  background: #fdfdfd;
  border-left-style: solid;
  border-left-width: 5px;
  border-left-color: #048981;
  border-radius: 10px;
  margin-bottom: 35px;
}

.enlace-perfil{
  text-decoration: none;
}

#publicaciones3 a .perfil{ /*titulo-post*/
  color: #6e6e6e;
  font-size: 40px;
  font-family: 'calibri light';
}

#publicaciones3 a .perfil:hover{ /*PARA QUE ME SUBRAYE EL TEXTO CUNDO PASO SOBE EL*/
  text-decoration: underline;
}

#publicaciones3 .img-post3{
  width: 150px;
  height: 100px;
  float: left;
  margin-top: 7px; /*PARA BAJAR LA IMAGEN*/
  margin-left: 17px; /*CENTRAR LA IMAGEN*/
}
          
            
    </style>


</html>