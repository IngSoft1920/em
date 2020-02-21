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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.DatoTurnoBean;
import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.Conector.ConectorBBDD;
@Controller
public class API {

	//API fnb Devolvemos camareros disponibles  
	@ResponseBody
	@GetMapping("/empleadoTipo")
	//recibimos el rol del empleado que quiere obtener el cliente
	public String getDatosCamareros(@RequestBody String req) {
		//convertimos parametro recibido a variable
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_rol=obj.get("id_rol").getAsInt();
		//consulta sql
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="select empleado.id_empleado,empleado.nombre,empleado.estado from empleado join rol on empleado.id_empleado=rol.id_empleado where rol.id_rol=?";
		List<DatoEmpleadoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler,id_rol);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//recogemos informacion y procesamos json
		JsonArray listaIDEmpleados=new JsonArray();
		JsonArray listaEmpleadosNombres=new JsonArray();
		JsonArray listaEmpleadosEstado=new JsonArray();
		
		for(DatoEmpleadoBean empleado:res) {
			listaIDEmpleados.add(empleado.getId_empleado());
			listaEmpleadosNombres.add(empleado.getNombre());
			listaEmpleadosEstado.add(empleado.getEstado());
		}
		
		JsonObject empleado = new JsonObject();
		empleado.add("id_empleado",listaIDEmpleados);
		empleado.add("nombre",listaEmpleadosNombres);
		empleado.add("estado",listaEmpleadosEstado);
		return empleado.toString();
		}
	
	//API PARA DHO
	@ResponseBody
	@PostMapping("/creaTurno")
	//recibimos (id_turno,id_empleado,horario) que vamos a insertar en la tabla turnos 
	public void creaTurno(@RequestBody String req){
		 //TurnoDAO.insertarTurno(nuevoTurno);
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		String horarioInicio=obj.get("horarioInicio").getAsString();
		String horarioFin=obj.get("horarioFin").getAsString();
		QueryRunner runner=new QueryRunner();
		String query="Insert into turno (id_empleado,horarioInicio,horarioFin) values(?,?,?)";
		try {
			int numRows=runner.update(ConectorBBDD.conectar(),query,id_empleado,horarioInicio,horarioFin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//API PARA DHO
	@ResponseBody
	@GetMapping("/seleccionaTurno")
	//Enviamos la lista de los turnos
	public String turnos() {
		BeanListHandler<DatoTurnoBean> handler=new BeanListHandler<>(DatoTurnoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="SELECT * FROM turno";
		List<DatoTurnoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JsonArray listaIDTurno=new JsonArray();
		JsonArray listaIDEmpleados=new JsonArray();
		JsonArray listaHorarioInicio=new JsonArray();
		JsonArray listaHorarioFin=new JsonArray();
		for(DatoTurnoBean turno:res) {
			listaIDTurno.add(turno.getId_turno());
			listaIDEmpleados.add(turno.getId_empleado());
			listaHorarioInicio.add(turno.getHorarioInicio());
			listaHorarioFin.add(turno.getHorarioFin());
		}
		
		JsonObject turno = new JsonObject();
		turno.add("id_turno",listaIDTurno);
		turno.add("id_empleado",listaIDTurno);
		turno.add("horarioInicio",listaHorarioInicio);
		turno.add("horarioFin",listaHorarioFin);
		
		return turno.toString();
	}
	
	//API AÑADIR EMPLEADO
	@ResponseBody
	@PostMapping("/añadirEmpleado")
	//Recibimos id_empleado, nombre, telefono , correo
	public void añadeEmpleado(@RequestBody String req) {
		//Creamos el objeto json con los parametros recibidos
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		String nombre_empleado=obj.get("nombre").getAsString();
		String telefono_empleado=obj.get("telefono").getAsString();
		String correo_empleado=obj.get("correo").getAsString();
		//Ejecutamos query
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="INSERT INTO empleado (id_empleado,nombre,telefono,correo) VALUES (?,?,?,?);";
		List<DatoEmpleadoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler,id_empleado,nombre_empleado,telefono_empleado,correo_empleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//API ELIMINAR EMPLEADO
	@ResponseBody
	@PostMapping("/eliminarEmpleado")
	//Recibimos correo
	public void eliminaEmpleado(@RequestBody String req) {
		//Creamos el objeto json con los parametros recibidos
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		String correo_empleado=obj.get("correo").getAsString();
		//Ejecutamos query
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="DELETE FROM empleado WHERE correo=?";
		List<DatoEmpleadoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler,correo_empleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//API ASIGNAR NOMINA
	@ResponseBody
	@PostMapping("/asignaNomina")
	//Recibimos una nomina con un valor
	public void asignaNomina(@RequestBody String req) {
		//Creamos el objeto json con los parametros recibidos
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		int valor=obj.get("valor").getAsInt();
		//Ejecutamos query
		BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
		QueryRunner runner=new QueryRunner();
		String query="INSERT INTO nomina (id_empleado,valor) VALUES (?,?)";
		List<DatoEmpleadoBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler,id_empleado,valor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//API ENVIA BAJA
	@ResponseBody
	@GetMapping("/baja")
	//Enviamos informacion de la baja de un empleado recibimos id_empleado
	public String baja(@RequestBody String req) {
		//Obtenemos parametro recibido
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		//QUERY
		BeanListHandler<BajaBean> handler=new BeanListHandler<>(BajaBean.class);
		QueryRunner runner=new QueryRunner();
		String query="SELECT (id_baja,duracion,estado) FROM baja WHERE id_empleado=?";
		List<BajaBean> res=null;
		try {
			res=runner.query(ConectorBBDD.conectar(), query,handler,id_empleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Guardamos resultado
		JsonArray listaIDBaja=new JsonArray();
		JsonArray listaDuracion=new JsonArray();
		JsonArray listaEstado=new JsonArray();
		for(BajaBean baja:res) {
			listaIDBaja.add(baja.getId_baja());
			listaDuracion.add(baja.getDuracion());
			listaEstado.add(baja.isEstado());
		}
		//Transformamos a formato deseado
		JsonObject baja = new JsonObject();
		baja.add("id_baja",listaIDBaja);
		baja.add("duracion",listaDuracion);
		baja.add("estado",listaEstado);
		
		return baja.toString();
		
	}
	
	//API ENVIA VACACIONES
		@ResponseBody
		@GetMapping("/vacaciones")
		//Enviamos informacion de las vacaciones de un empleado filtramos id_empleado
		public String vacaciones(@RequestBody String req) {
			//Obtenemos parametro recibido
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			int id_empleado=obj.get("id_empleado").getAsInt();
			//QUERY
			BeanListHandler<VacacionBean> handler=new BeanListHandler<>(VacacionBean.class);
			QueryRunner runner=new QueryRunner();
			String query="SELECT (id_baja,duracion,estado) FROM vacaciones WHERE id_empleado=?";
			List<VacacionBean> res=null;
			try {
				res=runner.query(ConectorBBDD.conectar(), query,handler,id_empleado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//Guardamos resultado
			JsonArray listaIDVacacion=new JsonArray();
			JsonArray listaDuracion=new JsonArray();
			JsonArray listaEstado=new JsonArray();
			for(VacacionBean vacacion:res) {
				listaIDVacacion.add(vacacion.getId_vacacion());
				listaDuracion.add(vacacion.getDuracion());
				listaEstado.add(vacacion.isEstado());
			}
			//Transformamos a formato deseado
			JsonObject vacacion = new JsonObject();
			vacacion.add("id_vacacion",listaIDVacacion);
			vacacion.add("duracion",listaDuracion);
			vacacion.add("estado",listaEstado);
			
			return vacacion.toString();
			
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
		JsonArray listaIDEmpleados=new JsonArray();
		JsonArray listaEstadoEmpleados=new JsonArray();
		JsonArray listaIDRolEmpleados=new JsonArray();
		
		
		for(DatoEmpleadoBean empleado:res) {
			listaIDEmpleados.add(empleado.getId_empleado());
			listaEstadoEmpleados.add(empleado.getEstado());
			listaIDRolEmpleados.add(empleado.getId_rol());
		}
		
		JsonObject empleado = new JsonObject();
		empleado.add("id_empleado",listaIDEmpleados);
		empleado.add("estado",listaEstadoEmpleados);
		empleado.add("id_rol",listaIDRolEmpleados);
		
		return empleado.toString();
	}
	
	
	
}
