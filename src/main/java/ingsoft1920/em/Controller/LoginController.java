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
import ingsoft1920.em.Beans.LoginBean;


@Controller
public class LoginController {
	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	//@Autowired
	//LoginBean loginBean;
	
	@GetMapping("/login")
	public String login(Model model) {
		//LoginBean loginBean = new LoginBean();
		//model.addAttribute("loginBean",loginBean);
		//model.addAttribute("mensajeError","");
		return "login";
	}
//	
//	@PostMapping("/login")
//	public String signupPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
//			Model model) {
//		
//		if(loginBean.checkCamposValidos()) {
//			//Podemos utilizar los metodos debug, info, warn y error para loggear mensajes
//			//Hay que evitar el uso de System.out.println(), ya que NO SE GUARDA UNA VEZ SE ACABA
//			//LA EJECUCION
//			logger.info("Peticion de Signup recibida correctamente y con campos validos");
//		
//				return "menu";
//
//	}
//		return "login";
	//}
}
