package ingsoft1920.em.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.DAO.VacacionesDAO;
import ingsoft1920.em.Model.VacacionesModel;

@Controller
public class VacacionesController {

	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@GetMapping("/menu7")
	public String loginp(Model model) {
		return "menu";
	}

	@PostMapping("/menu7")
	public String menup(Model model) {
		return "menu";
	}

	@GetMapping("/nomina7")
	public String nominap1(Model model) {
		return "nomina";
	}

	@PostMapping("/nomina7")
	public String nominap(Model model) {
		return "nomina";
	}

	@GetMapping("/perfil7")
	public String perfilp1(Model model) {
		return "perfilPrueba";
	}

	@PostMapping("/perfil7")
	public String perfilp(Model model) {
		return "perfilPrueba";
	}

	@GetMapping("/cerrar7")
	public String cerrarp1(Model model) {
		return "login";
	}

	@PostMapping("/cerrar7")
	public String cerrarp(Model model) {
		return "login";
	}

	@GetMapping("/tareas7")
	public String tareasp1(Model model) {
		return "tareaPrueba";
	}

	@PostMapping("/tareas7")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}

	@GetMapping("/vacaciones7")
	public String vacacionesp1(Model model) {
		return "vacaciones";
	}

	@PostMapping("/vacaciones7")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}

	@GetMapping("/bajas7")
	public String bajasp1(Model model) {
		return "bajas";
	}

	@PostMapping("/bajas7")
	public String bajasp(Model model) {
		return "bajas";
	}

	@GetMapping("/verVacaciones")
	public String verVacaciones(Model model) {
		List<VacacionesModel> vacaciones = VacacionesDAO.sacaVacaciones(1);
		model.addAttribute("vacaciones", vacaciones);
		return "muestraVacaciones";
	}

	@PostMapping("/verVacaciones")
	public String verVacaciones1(Model model) {
		return "muestraVacaciones"; 
	}

	@GetMapping("/añadeVacaciones")
	public String añadeBaja(Model model) {
		VacacionBean vacacion = new VacacionBean();
		model.addAttribute("vacaciones", vacacion);
		model.addAttribute("mensajeError", "");
		return "vacaciones";
	}

	@PostMapping("/añadeVacaciones")
	public String añadeVacaciones1(BajaBean bajaBean, Model model) {
		// TO-DO COMPROBAR CAMPOS VALIDOS
		
		VacacionesDAO.insertaVacaciones(1,bajaBean.getDuracion());
		return "vacaciones";
	}
	
}
