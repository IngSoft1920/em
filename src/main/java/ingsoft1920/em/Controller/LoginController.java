package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.em.Beans.LoginBean;;


@Controller
public class LoginController {
	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
//	@Autowired
//	LoginBean loginBean;
	
	@GetMapping("/login")
	public String login(Model model) {
		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean",loginBean);
		model.addAttribute("mensajeError","");
		return "login";
	}
	
	@PostMapping("/login")
	public String loginValida(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		
//		String usuarioValido= "usuario";
//		String passValida= "1234";		
//		String usuario = "";  
//		String pass = "";
//		TODO coger datos del formulario y checkearlos para entrar en el menú
		
		
		if (loginBean.checkCamposValidos() )
			return "menu";
		
		
		else {
			model.addAttribute("signupBean",loginBean);
			model.addAttribute("mensajeError","Usuario no valido");
			return "login";
		}
		
	}
}
