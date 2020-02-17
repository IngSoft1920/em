package ingsoft1920.em.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//TO-DO IMPORTAR PAQUETES NECESARIOS
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.DatoTurnoBean;
import ingsoft1920.em.Conector.ConectorBBDD;
@Controller
public class API {

	//TO-DO
	//API fnb Devolvemos camareros disponibles  
	@ResponseBody
	@GetMapping("/listaCamareros")
	public String getDatosCamareros() {
		JsonArray listaCamareros=new JsonArray();
		
		return "";
		
		}
	
	//TO-DO
	//POST TURNOS
	@ResponseBody
	@PostMapping("/creaTurno")
	//recibimos (id_turno,id_empleado,horario) que vamos a insertar en la tabla turnos 
	public void creaTurno(@RequestBody DatoTurnoBean nuevoTurno){
		 //TurnoDAO.insertarTurno(nuevoTurno);
	}
	
	
	//EJEMPLO OBTENCION EMPLEADOS BBDD
	@ResponseBody
	@GetMapping("/empleados")
	public String empleados() {
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="SELECT empleado.id_empleado,empleado.estado,rol.id_rol FROM empleado join rol on empleado.id_empleado=rol.id_empleado";
		List<DatoEmpleadoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JsonArray listaEmpleados=new JsonArray();
		
		for(DatoEmpleadoBean empleado:res) {
			listaEmpleados.add("NuevoEmpleado");
			listaEmpleados.add(empleado.getId_empleado());
			listaEmpleados.add(empleado.getEstado());
			listaEmpleados.add(empleado.getId_rol());
		}
		
		return listaEmpleados.toString();
	}
	
	
	
}
