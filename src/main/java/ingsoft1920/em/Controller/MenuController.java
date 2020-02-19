package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.em.Beans.LoginBean;

@Controller
public class MenuController {
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu")
	public String login(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu")
	public String menu(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
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
		return "perfil";
	}
	
	@PostMapping("/perfil")
	public String perfil(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "perfil";
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

}
