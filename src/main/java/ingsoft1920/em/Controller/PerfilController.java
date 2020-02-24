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
import ingsoft1920.em.Beans.LoginBean;
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
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil2")
	public String perfilp(Model model) {
		return "perfilPrueba";
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
	public String tareas(Model model) {
		//List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		List<ActividadBean> tareas=new ArrayList<ActividadBean>();
		tareas.add(new ActividadBean(1,1,"limpiar habitacion 1"));
		tareas.add(new ActividadBean(2,1,"limpiar habitacion 2"));
		tareas.add(new ActividadBean(3,1,"limpiar habitacion 3"));
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas2")
	public String tareas(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
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
	
	@GetMapping("/turnos2")
	public String turnos(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos2")
	public String turnos(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "turnos";
	}
	
}


