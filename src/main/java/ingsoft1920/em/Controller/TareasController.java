package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller 
public class TareasController {

final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu4")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu4")
	public String menup(Model model) {
		return "menu";
	}
	
	@GetMapping("/nomina4")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina4")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil4")
	public String perfilp1(Model model) {
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil4")
	public String perfilp(Model model) {
		return "perfilPrueba";
	}
	
	@GetMapping("/cerrar4")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar4")
	public String cerrarp(Model model) {
		return "login";
	}
	
	@GetMapping("/tareas4")
	public String tareasp1(Model model) {
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas4")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/vacaciones4")
	public String vacacionesp1(Model model) {
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones4")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}
	
	@GetMapping("/bajas4")
	public String bajasp1(Model model) {
		return "bajas";
	}
	
	@PostMapping("/bajas4")
	public String bajasp(Model model) {
		return "bajas";
	}
	
}