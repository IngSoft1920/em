<html lan="es">

<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> USUARIO: </title>


</head>
<body>



  <section id="principal1">

    <section id="publicaciones1">
      <article class="cuerpo-nomina">
        <img src="/img/nominaejemplo.jpg" class="img-post1">
      </article>
      
      <input type="submit" name="" value="Regresar a menu" />
    </section>


  </section>
</body>

<div>
	<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		
		<h1>
			Numero de visitas ${DatoEmpleadoBean.empleado_id}
		</h1>
		<h1>
		Numero de visitas ${DatoEmpleadoBean.id_empleado}
		</h1>
		
		<h2>Horario de las visitas:</h2>
		
		<ol>
			<!-- Con esta etiqueta podemos iterar sobre un List de Java. El item que esta en la iteracion se guarda en 
			la variable hora, y la lista de items sobre los que iterar se pone en items
			Esto equivaldria en Java a:
			
			for each(String nombre : DatoEmpleadoBean.getNombre()){...}
			
			Notad que en jsp teneis que poner el nombre del campo de la clase, no el getter o setter. Spring
			automaticamente identifica el campo con el getter y lo ejecuta por vosotros. -->
			
			<c:forEach items="${DatoEmpleadoBean.id_empleado}" var="nombre">
			
			<li>
				${nombre}
			</li>
			
			</c:forEach>
		
		</ol>
	</div>
	
	<form:form method="POST" action="setNombre"
		modelAttribute="DatoEmpleadoBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="getNombre" path="getNombre" />
		<input type="submit" value="Set Nombre">
		<br>
	</form:form>


</html>
