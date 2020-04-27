<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
</head>

<body>
<header class="header">
    <div id="encabezado">
      <div id="logo">
        PORTAL EMPLEADOS
      </div>

      <div id="menu">
        <ul>
          <li><a href="/menu5" class="enlace">Inicio</a></li>
          <li><a href="/nomina5" class="enlace">Nomina</a></li>
          <li><a href="/turnos5" class="enlace">Turnos</a></li>
          <li><a href="/tareas5" class="activate-menu">Tareas</a></li>
          <li><a href="/ausencias5" class="enlace">Ausencias</a></li>
          <li><a href="/perfil5" class="enlace">Perfil</a></li>
          <li><a href="/registro5" class="enlace">Registro</a></li>
          <li><a href="/cerrar5" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>
    </div>
 </header>
 

<div class="main-container">
	<table>	
          <thead>
          <tr>
            <th class="text-center">HORA INICIO</th>
            <th class="text-center">HORA FIN</th>
            <th class="text-center">DESCRIPCION TAREA</th>
            <th class="text-center">LUGAR TAREA</th>
            <th class="text-center">Estado</th>
            
          </tr>
          </thead>

			
		<c:forEach var="tareas" items="${tareas}">
			
          <tbody>
          <tr>
            
            <td> ${tareas.horarioInicio} <br></td>
            <td> ${tareas.horarioFin} <br></td>
            <td> ${tareas.descripcionTarea}  <br></td>
            <td> ${tareas.lugar}  <br></td>
            <td><input type="submit" value="Terminada ${tareas.id_tarea}" onclick="window.location='/eliminarTarea/' ${tareas.id_tarea};" /></td>
            
          </tr>
          </tbody>
	
		</c:forEach>
	
    </table>					
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

#main-container{
margin:50px auto;
border:1px solid #075F68;
width:80%;
}

table{
text-align: center;
padding-left:180px;
width:80%;
}

th,td{
padding: 20px;
border:1px solid #075F68;
}

thead{
background-color: #0B8894;
border-bottom: solid 5px #075F68;
color:white;
}

td:ntd-child(even){
background-color: #0B8894;
}


</style>

</html>