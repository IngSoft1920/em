<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
</head>
<body>
	<h1>Visualizacion Nominas</h1>
	
	<u1>
		<c:forEach var="nominas" items="${nominas}">
			<li>
				<p>
					<b>id_nomina:</b> ${nominas.id_nomina} <br>
					<b>id_empleado:</b> ${nominas.id_empleado} <br>
					<b>id_incentivo:</b> ${nominas.id_incentivo} <br>
					<b>id_sueldo:</b> ${nominas.id_sueldo} <br>
					<b>valor:</b> ${nominas.valor} <br>
				</p>
			</li>
		</c:forEach>
	</u1>
					
					
    
</body>


</html>
