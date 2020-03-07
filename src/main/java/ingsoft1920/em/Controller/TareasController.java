package ingsoft1920.em.Controller;



import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;

@Controller 
public class TareasController {

final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu5")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu5")
	public String menup(Model model) {
		return "menu";
	}
	
	@GetMapping("/nomina5")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina5")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil5")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil5")
	public String perfilp(Model model) {
		return "perfil";
	}
	
	@GetMapping("/cerrar5")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar5")
	public String cerrarp(Model model) {
		return "login";
	}
	
	@GetMapping("/tareas5")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas5")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/ausencias5")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencias5")
	public String ausenciasp(Model model) {
		return "ausencias";
	}

	@GetMapping("/turnos5")
	public String turnosp(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@GetMapping("/registro5")
	public String registrop1(Model model) {
		return "registro";
	}
	
	@PostMapping("/registro5")
	public String registrop(Model model) {
		return "registro";
	}
}