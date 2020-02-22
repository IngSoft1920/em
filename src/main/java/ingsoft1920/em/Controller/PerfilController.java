package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		return "perfil";
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
		return "tareas";
	}
	
	@PostMapping("/tareas2")
	public String tareasp(Model model) {
		return "tareas";
	}
	
}

