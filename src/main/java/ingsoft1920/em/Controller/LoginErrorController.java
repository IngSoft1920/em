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
import ingsoft1920.em.Beans.LoginErrorBean;

@Controller
public class LoginErrorController {
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/error")
	public String login(Model model) {
		LoginErrorBean loginErrorBean = new LoginErrorBean();
		model.addAttribute("loginBean",loginErrorBean);
		return "/login";
	}
	
	@PostMapping("/error")
	public String menu(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "/login";
 }
	

}
