package ingsoft1920.em.Controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.DAO.VacacionesDAO;
import ingsoft1920.em.Model.TurnoModel;
import ingsoft1920.em.Model.VacacionesModel;

@Controller
public class VacacionesController {

	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@GetMapping("/menu7")
	public String loginp(Model model) {
		return "menu";
	}

	@PostMapping("/menu7")
	public String menup(Model model) {
		return "menu";
	}

	@GetMapping("/nomina7")
	public String nominap1(Model model) {
		return "nomina";
	}

	@PostMapping("/nomina7")
	public String nominap(Model model) {
		return "nomina";
	}

	@GetMapping("/perfil7")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}

	@PostMapping("/perfil7")
	public String perfilp(Model model) {
		return "perfilPrueba";
	}

	@GetMapping("/cerrar7")
	public String cerrarp1(Model model) {
		return "login";
	}

	@PostMapping("/cerrar7")
	public String cerrarp(Model model) {
		return "login";
	}

	@GetMapping("/tareas7")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}

	@PostMapping("/tareas7")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/turnos7")
	public String turnosp(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}

	@GetMapping("/ausencias7")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}

	@PostMapping("/ausencias7")
	public String ausenciasp(Model model) {
		return "ausencias";
	}


	@GetMapping("/verVacaciones")
	public String verVacaciones(Model model){
		List<VacacionesModel> vacaciones = VacacionesDAO.sacaVacaciones(1);
		model.addAttribute("vacaciones", vacaciones);
		return "muestraVacaciones";
	}

	@PostMapping("/verVacaciones")
	public String verVacaciones1(Model model) {
		return "muestraVacaciones"; 
	}

	@GetMapping("/aniadeVacaciones")
	public String añadeBaja(Model model) {
		VacacionBean vacacion = new VacacionBean();
		model.addAttribute("vacaciones", vacacion);
		model.addAttribute("mensajeError", "");
		return "vacaciones";
	}

	@PostMapping("/aniadeVacaciones")
	public String añadeVacaciones1(VacacionBean vacaciones, Model model) throws ParseException {
		// TO-DO COMPROBAR CAMPOS VALIDOS
		int duracion;
		duracion = (int) ((vacaciones.getFecha_fin().getTime()-vacaciones.getFecha_inicio().getTime())/86400000);
		if (duracion > 0) { // para comprobar que la fechafinal sea mayor que la inicial
			int[] res;
			int diasRestantes = 0;
			res = VacacionesDAO.contVacaciones(1, duracion); // vacaciones.getIdEmpleado()
			diasRestantes = (int) ((res[0] / 30) * 2.5) - res[1]; // if(((dias/30)*2.5)<=duracion+vacacionesGastadas)
			model.addAttribute("diasRestantes", diasRestantes);
			System.out.println(diasRestantes);
			if (diasRestantes >= duracion) {
				VacacionesDAO.insertaVacaciones(1, duracion,vacaciones);
				VacacionesDAO.getIdVacaciones(1,vacaciones);
				//VacacionesCM.peticionPedirVacaciones(vacaciones);
				
			}
		}
		return "vacaciones";
	}

}
