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
          <li><a href="/menu" class="enlace">Inicio</a></li>
          <li><a href="/nomina" class="enlace">Nomina</a></li>
          <li><a href="/turnos" class="activate-menu">Turnos</a></li>
          <li><a href="/tareas" class="enlace">Tareas</a></li>
          <li><a href="/vacaciones" class="enlace">Vacaciones</a></li>
          <li><a href="/bajas" class="enlace">Bajas</a></li>
          <li><a href="/perfil" class="enlace">Perfil</a></li>
          <li><a href="/cerrar" class="enlace">Cerrar Sesion</a></li>
        </ul>
      </div>
    </div>
 </header>
  
	<h1>Visualizacion Turnos</h1>
	
	<u1>
		<c:forEach var="turnos" items="${turnos}">
			<li>
				<p>
					<b>id_empleado:</b> ${turnos.id_Empleado} <br>
					<b>id_turno:</b> ${turnos.id_Turno} <br>
					<b>horarioInicio:</b> ${turnos.horarioInicio} <br>
					<b>horarioFin:</b> ${turnos.horarioFin} <br>
					<b>diaSemana:</b> ${turnos.diaSemana} <br>
				</p>
			</li>
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
  color: #fff;
  border-radius: 5px 5px 0px 0px;
  padding: 10px;
}

</style>

</html>