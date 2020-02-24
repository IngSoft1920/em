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
public class PerfilController {
	
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu2")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu2")
	public String menup(Model model) {
		return "menu";
	}
	@GetMapping("/turnos2")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos2")
	public String turnosp(Model model) {
		return "turnos";
	}
	@GetMapping("/nomina2")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina2")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil2")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil2")
	public String perfilp(Model model) {
		return "perfil";
	}
	
	@GetMapping("/cerrar2")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar2")
	public String cerrarp(Model model) {
		return "login";
	}
	
	@GetMapping("/tareas2")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas2")
	public String tareasp(Model model) {
		return "tareas";
	}
	
	@GetMapping("/vacaciones2")
	public String vacacionesp1(Model model) {
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones2")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}
	
	@GetMapping("/bajas2")
	public String bajasp1(Model model) {
		return "bajas";
	}
	
	@PostMapping("/bajas2")
	public String bajasp(Model model) {
		return "bajas";
	}
	
}


