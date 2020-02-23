<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
</head>

<body>
	<h1>Visualizacion Tareas</h1>
	
	<u1>
		<c:forEach var="tareas" items="${tareas}">
			<li>
				<p>
					<b>id_tarea:</b> ${tareas.id_tarea} <br>
					<b>id_empleado:</b> ${tareas.id_empleado} <br>
					<b>id_incentivo:</b> ${tareas.descripcionTarea} <br>
				</p>
			</li>
		</c:forEach>
	</u1>
					
					
    
</body>


</html>