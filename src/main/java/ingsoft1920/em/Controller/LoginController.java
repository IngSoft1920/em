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

	@GetMapping("/")
	public String loginp1(Model model) {
		return "login";
	}
	
	@PostMapping("/login") 
	public String loginValida(@Valid @ModelAttribute("loginBean") LoginBean loginBean, 
			Model model) { 
				 
		String usuario = loginBean.getUsuario();  // esta es la variable que muestra el usuario que ha hecho login
		System.out.println(usuario);
		String pass = loginBean.getPassword(); 
				 
		if (usuario.equals("usuario") && pass.equals("1234")) 
			return "/menu"; 
		 
		 
		else { 
			model.addAttribute("signupBean",loginBean); 
			model.addAttribute("mensajeError","Usuario o contraseña no validos"); 
			return "/login"; 
		} 
		 
	} 
	
}


