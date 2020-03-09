package ingsoft1920.em.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
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
import ingsoft1920.em.DAO.BajaDAO;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.DAO.VacacionesDAO;
import ingsoft1920.em.Model.BajaModel;
import ingsoft1920.em.Model.EmpleadoModelC2;
import ingsoft1920.em.Model.EmpleadoModelC3;
import ingsoft1920.em.Model.TurnoModel;
import ingsoft1920.em.Model.VacacionesModel;
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
		List<EmpleadoModelC2>listaEmpleados=new ArrayList<EmpleadoModelC2>();
		listaEmpleados=EmpleadoDAO.sacaEmpleados2(id_rol);
		//Guardamos info de la consulta en formato JSON
		JsonArray listaIDEmpleados=new JsonArray();
		JsonArray listaEmpleadosNombres=new JsonArray();
		JsonArray listaEmpleadosEstado=new JsonArray();
		
		for(EmpleadoModelC2 empleado:listaEmpleados) {
			listaIDEmpleados.add(empleado.getId_Empleado());
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
		//sacamos el turno recibido
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		String horarioInicio=obj.get("horarioInicio").getAsString();
		String horarioFin=obj.get("horarioFin").getAsString();
		String diaSemana=obj.get("dia").getAsString();
		//Ejecutamos consulta insert
		TurnoDAO.añadirTurno(id_empleado, horarioInicio, horarioFin,diaSemana);
	}
	//TO-DO
	//API PARA DHO
	@ResponseBody
	@GetMapping("/seleccionaTurno")
	//Enviamos la lista de los turnos
	public String turnos() {
		List<TurnoModel> respuesta=new ArrayList<TurnoModel>();
		respuesta=TurnoDAO.enviarTurnos();
		
		JsonArray listaIDTurno=new JsonArray();
		JsonArray listaIDEmpleados=new JsonArray();
		JsonArray listaHorarioInicio=new JsonArray();
		JsonArray listaHorarioFin=new JsonArray();
		JsonArray listaDiaSemana=new JsonArray();
		for(TurnoModel turno:respuesta) {
			listaIDTurno.add(turno.getId_Turno());
			listaIDEmpleados.add(turno.getId_Turno());
			listaHorarioInicio.add(turno.getHorarioInicio());
			listaHorarioFin.add(turno.getHorarioFin());
			listaDiaSemana.add(turno.getDiaSemana());
		}
		
		JsonObject turno = new JsonObject();
		turno.add("id_turno",listaIDTurno);
		turno.add("id_empleado",listaIDTurno);
		turno.add("horarioInicio",listaHorarioInicio);
		turno.add("horarioFin",listaHorarioFin);
		turno.add("diaSemana",listaDiaSemana);
		
		return turno.toString();
	}
	
	//API AÑADIR EMPLEADO
	@ResponseBody
	@PostMapping("/creaEmpleado")
	//Recibimos id_empleado, nombre, telefono , correo
	public void creaEmpleado(@RequestBody String req) {
		//Creamos el objeto json con los parametros recibidos
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id").getAsInt();
		String nombre=obj.get("nombre").getAsString();
		String telefono=obj.get("telefono").getAsString();
		String correo=obj.get("email").getAsString();
		String rol=obj.get("ocupacion").getAsString();
		int id_hotel=obj.get("hotel").getAsInt();
		int valor=obj.get("valor").getAsInt();
		//fecha contratacion
		
		//Ejecutamos query
		EmpleadoDAO.añadirEmpleado(id_empleado, nombre, telefono, correo,id_hotel);
		EmpleadoDAO.añadirRol(rol,id_empleado);
		NominaDAO.asignarNomina(id_empleado, valor);
	}
	
	//API ELIMINAR EMPLEADO
	@ResponseBody
	@PostMapping("/eliminarEmpleado")
	//Recibimos correo
	public void eliminaEmpleado(@RequestBody String req) {
		//Creamos el objeto json con los parametros recibidos
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id").getAsInt();
		//Ejecutamos query
		EmpleadoDAO.eliminarEmpleado(id_empleado);
	}
	
	
	//API ENVIA BAJA
	@ResponseBody
	@GetMapping("/baja")
	//Enviamos informacion de la baja de un empleado recibimos id_empleado
	public String baja(@RequestBody String req) {
		//Obtenemos parametro recibido
		JsonObject obj = (JsonObject) JsonParser.parseString(req);
		int id_empleado=obj.get("id_empleado").getAsInt();
		List<BajaModel> respuesta=new ArrayList<BajaModel>();
		//QUERY
		respuesta=BajaDAO.BajaModelSacaBajas(id_empleado);
		//Guardamos resultado
		JsonArray listaIDEmpleado=new JsonArray();
		JsonArray listaIDBaja=new JsonArray();
		JsonArray listaDuracion=new JsonArray();
		JsonArray listaEstado=new JsonArray();
		for(BajaModel baja:respuesta) {
			listaIDEmpleado.add(baja.getId_Empleado());
			listaIDBaja.add(baja.getId_Baja());
			listaDuracion.add(baja.getDuracion());
			listaEstado.add(baja.getEstado());
		}
		//Transformamos a formato deseado
		JsonObject baja = new JsonObject();
		baja.add("id_empleado",listaIDEmpleado);
		baja.add("id_baja",listaIDBaja);
		baja.add("duracion",listaDuracion);
		baja.add("estado",listaEstado);
		
		return baja.toString();
		
	}
	
	//API ENVIA VACACIONES
		@ResponseBody
		@GetMapping("/vacaciones")
		//Enviamos informacion de las vacaciones de un empleado filtramos id_empleado
		public String vacaciones(@RequestBody String req) throws ParseException {
			//Obtenemos parametro recibido
			String res="";
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			int id_empleado=obj.get("id_empleado").getAsInt();
			List<VacacionesModel>consulta=new ArrayList<VacacionesModel>();
			//QUERY
			consulta=VacacionesDAO.sacaVacaciones(id_empleado);
			if (consulta!=null) {
			//Guardamos resultado
			JsonArray listaIDEmpleado=new JsonArray();
			JsonArray listaIDVacacion=new JsonArray();
			JsonArray listaDuracion=new JsonArray();
			JsonArray listaEstado=new JsonArray();
			for(VacacionesModel vacacion:consulta) {
				listaIDEmpleado.add(vacacion.getId_Empleado());
				listaIDVacacion.add(vacacion.getId_Vacaciones());
				listaDuracion.add(vacacion.getDuracion());
				listaEstado.add(vacacion.getEstado());
			}
			//Transformamos a formato deseado
			JsonObject vacacion = new JsonObject();
			vacacion.add("id_empleado",listaIDEmpleado);
			vacacion.add("id_vacacion",listaIDVacacion);
			vacacion.add("duracion",listaDuracion);
			vacacion.add("estado",listaEstado);
			res=vacacion.toString();
			}
			
			return res;
			
		}
		
		//API que recibe el estado de la ausencia (vacacion)
		@ResponseBody
		@PostMapping("vacaciones")
		public void cambiaEstadoVacacion(@RequestBody String req) {
			//Creamos el objeto json con los parametros recibidos
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			int id_ausencia=obj.get("id_ausencia").getAsInt();
			String estado=obj.get("resultado").getAsString();
			//Ejecutamos query
			VacacionesDAO.editaVacacion(id_ausencia,estado);
		}
		
		//API que recibe el estado de la ausencia (baja)
		@ResponseBody
		@PostMapping("baja")
		public void cambiaEstadoBaja(@RequestBody String req) {
			//Creamos el objeto json con los parametros recibidos
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			int id_ausencia=obj.get("id_ausencia").getAsInt();
			String estado=obj.get("resultado").getAsString();
			//Ejecutamos query
			BajaDAO.editaBaja(id_ausencia,estado);
		}
		
		
		
	
	//OBTENCION EMPLEADOS BBDD dado nombre
		@ResponseBody
		@GetMapping("/infoEmpleado")
		public String infoEmpleado(@RequestBody String req) {
			//Sacamos nombre del empleado
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			String nombre=obj.get("nombre").getAsString();
			//Preparamos query
			BeanListHandler<DatoEmpleadoBean> handler=new BeanListHandler<>(DatoEmpleadoBean.class);
			QueryRunner runner=new QueryRunner();
			String query="SELECT empleado.id_empleado,empleado.nombre,empleado.telefono,empleado.correo,rol.id_rol FROM empleado join rol on empleado.id_empleado=rol.id_empleado WHERE empleado.nombre=?";
			List<DatoEmpleadoBean> res=null;
			try {
				res=runner.query(ConectorBBDD.conectar(), query,handler,nombre);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JsonArray listaIDEmpleados=new JsonArray();
			JsonArray listaNombreEmpleados=new JsonArray();
			JsonArray listaTelefonoEmpleados=new JsonArray();
			JsonArray listaCorreoEmpleados=new JsonArray();
			JsonArray listaIDRolEmpleados=new JsonArray();
			
			
			for(DatoEmpleadoBean empleado:res) {
				listaIDEmpleados.add(empleado.getId_empleado());
				listaNombreEmpleados.add(empleado.getNombre());
				listaTelefonoEmpleados.add(empleado.getTelefono());
				listaCorreoEmpleados.add(empleado.getCorreo());
				listaIDRolEmpleados.add(empleado.getId_rol());
			}
			JsonObject empleado = new JsonObject();
			empleado.add("id_empleado",listaIDEmpleados);
			empleado.add("nombre",listaNombreEmpleados);
			empleado.add("telefono",listaTelefonoEmpleados);
			empleado.add("correo",listaCorreoEmpleados);
			empleado.add("id_rol",listaIDRolEmpleados);
			
			return empleado.toString();
			
		}
		//API para DHO, devolvemos lista de empleados
		@ResponseBody
		@GetMapping("/sacaEmpleadoHotel")
		//recibimos el id_hotel del que quiere obtener la lista de empleados
		public String getEmpleadoHotel(@RequestBody String req) {
			//convertimos el parámetro recibido a variable
			JsonObject obj = (JsonObject) JsonParser.parseString(req);
			int id_hotel=obj.get("id_hotel").getAsInt();
			//consulta sql
			List<EmpleadoModelC3> listaEmpleados = new ArrayList<EmpleadoModelC3>();
			listaEmpleados = EmpleadoDAO.sacaEmpleados3(id_hotel);
			//Guardamos la info de la consulta en formato JSON
			JsonArray listaIDEmpleados = new JsonArray();
			JsonArray listaIDHotel = new JsonArray();
			JsonArray listaRol = new JsonArray();
			
			for(EmpleadoModelC3 empleado:listaEmpleados) {
				listaIDEmpleados.add(empleado.getId_Empleado());
				listaIDHotel.add(empleado.getId_Hotel());
				listaRol.add(empleado.getRol());			
			}
			
			JsonObject empleado = new JsonObject();
			empleado.add("id_empleado", listaIDEmpleados);
			empleado.add("id_hotel", listaIDHotel);
			empleado.add("rol", listaRol);
			return empleado.toString();
		}
		
	
	
}
