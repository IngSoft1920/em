<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
</head>
<body>
	<h1>Visualizacion Turnos</h1>
	
	<u1>
		<c:forEach var="turnos" items="${turnos}">
			<li>
				<p>
					<b>id_empleado:</b> ${turnos.id_Empleado} <br>
					<b>id_turno:</b> ${turnos.id_Turno} <br>
					<b>horarioInicio:</b> ${turnos.horarioInicio} <br>
					<b>horarioFin:</b> ${turnos.horarioFin} <br>
				</p>
			</li>
		</c:forEach>
	</u1>
					
</body>

</html>