
<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO: </title>
  <link rel="stylesheet" type="text/css" href="css/estilonom.css"> <!--carpeta donde se encuentra el estilo css-->



	<script>
	function elige() {
         var lista = document.getElementById("colores")
         if (lista.selectedIndex == null || lista.selectedIndex == 0) { 
            alert("No se ha podido realizar tu peticion; \n Debes elegir un mes de la lista.")
            return false
            }
         	
         }
	
	</script>
</head>

<body>

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
          <li><a href="/ausencias3" class="enlace">Ausencias</a></li>
          <li><a href="/perfil3" class="enlace">Perfil</a></li>
          <li><a href="/registro3" class="enlace">Registro</a></li>
          <li><a href="/cerrar3" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>

    </div>
  </header>

  <section id="principal">
    
          <h2> -> Para visualizar la nomina elige un mes: </h2><br/>
        

        <table border="tabla">


          <tbody>
          <tr>
            <td>

              <nav class="nav">
              <ul class="menu">

              <li><a> Elige un mes </a>
                  <ul class="submenu">
                      <li><a href="/generarPDF1?n=1">Enero</a></li>
                      <li><a href="/generarPDF2">Febrero</a></li>
                      <li><a href="/generarPDF3">Marzo</a></li>
                      <li><a href="/generarPDF4">Abril</a></li>
                      <li><a href="/generarPDF5">Mayo</a></li>
                      <li><a href="/generarPDF6">Junio</a></li>
                      <li><a href="/generarPDF7">Julio</a></li>
                      <li><a href="/generarPDF8">Agosto</a></li>
                      <li><a href="/generarPDF9">Septiembre</a></li>
                      <li><a href="/generarPDF10">Octubre</a></li>
                      <li><a href="/generarPDF11">Noviembre</a></li>
                      <li><a href="/generarPDF12">Diciembre</a></li>
                  </ul>
              </li>

              </ul>
              </nav>

            </td>
          </tr>
          </tbody>

        </table>
 

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
  width: 60%;
  height: 90%; overflow: hidden;
  border: 0px solid; /* si no le ponemos nada significa negro*/
  margin: 0px auto;
  padding:15px;
}

h2{
color:#585858;

}

.enlace-post{
 text-decoration: none;
 width:90%;
 padding: 5px;
 height: 5px;
 color: #01a9db;

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