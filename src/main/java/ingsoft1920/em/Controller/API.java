package ingsoft1920.em.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//TO-DO IMPORTAR PAQUETES NECESARIOS
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Conector.ConectorBBDD;
@Controller
public class API {

	
	//API fnb Devolvemos camareros disponibles  
	@ResponseBody
	@GetMapping("/listaCamareros")
	public String getDatosUsuario1() {
		
		//Declaramos una lista de empleados que sera lo que devolvamos
		JsonArray listaEmpleados=new JsonArray();
		
		//Iremos añadiendo empleados a la lista
		JsonObject empleado1 = new JsonObject();
		
		//TO-DO acceso BBDD para obtener propiedades
		empleado1.addProperty("empleado_id", "1");
		empleado1.addProperty("rol_id", "1");
		empleado1.addProperty("estado_id", "1");
		
		JsonObject obj2=new JsonObject();
		obj2.addProperty("empleado_id", "1");
		obj2.addProperty("rol_id", "1");
		obj2.addProperty("estado_id", "1");
		
		
		//tras obtener los empleados 
		listaEmpleados.add(empleado1);
		listaEmpleados.add(obj2);
		//Obtenemos la representacion en String del objeto JSON y la enviamos como respuesta
		return listaEmpleados.toString();
		
		}
	@ResponseBody
	@GetMapping("/empleados")
	public String empleados() {
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="SELECT * FROM empleado";
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JsonArray listaEmpleados=new JsonArray();
		
		List<DatoEmpleadoBean> res=null;
		
		for(DatoEmpleadoBean empleado:res) {
			listaEmpleados.add("NuevoEmpleado");
			listaEmpleados.add(empleado.getId_empleado());
			listaEmpleados.add(empleado.getEstado());
			listaEmpleados.add(empleado.getId_rol());
		}
		
		return listaEmpleados.toString();
	}
	
	
}
