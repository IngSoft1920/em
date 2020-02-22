package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class VacacionesController {

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
		return "perfil";
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
		return "tareas";
	}
	
	@PostMapping("/tareas5")
	public String tareasp(Model model) {
		return "tareas";
	}
	
	@GetMapping("/vacaciones5")
	public String vacacionesp1(Model model) {
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones5")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}
	
	@GetMapping("/bajas5")
	public String bajasp1(Model model) {
		return "bajas";
	}
	
	@PostMapping("/bajas5")
	public String bajasp(Model model) {
		return "bajas";
	}
}