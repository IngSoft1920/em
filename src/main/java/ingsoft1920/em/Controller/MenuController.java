package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.LoginBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;

@Controller
public class MenuController {
	
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu")
	public String menu(Model model) {
		return "menu";
	}
		
	@GetMapping("/nomina")
	public String nomina(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina")
	public String nomina(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil")
	public String perfil(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "perfilPrueba";
	}
	
	@GetMapping("/cerrar")
	public String cerrar(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar")
	public String cerrar(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "login";
	}
	
	@GetMapping("/tareas")
	public String tareas(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas")
	public String tareas(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/turnos")
	public String turnos(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos")
	public String turnos(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "turnos";
	}
	
	@GetMapping("/ausencias")
	public String ausencias(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencias")
	public String ausencias(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "ausencias";
	}
	
}
