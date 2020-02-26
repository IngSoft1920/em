package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.NominaModel;
import ingsoft1920.em.Model.TurnoModel;


@Controller 
public class NominaController {

final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu3")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu3")
	public String menup(Model model) {
		return "menu";
	}
	
	@GetMapping("/nomina3")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina3")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil3")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil3")
	public String perfilp(Model model) {
		return "perfil";
	}
	
	@GetMapping("/cerrar3")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar3")
	public String cerrarp(Model model) {
		return "login";
	}
	
	@GetMapping("/tareas3")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas3")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/ejemplo")
	public String ejemplop1(Model model) {
		//model.addatribute (nombre atributo,objeto el bean o el model) ((importante tiene que ser igual que el del html))
		List<NominaModel>nominas=NominaDAO.verNomina(1);
		model.addAttribute("nominas", nominas);
		return "ejemplo";
	}
	
	@PostMapping("/ejemplo")
	public String ejemplop(Model model) {
		return "ejemplo";
	}
	
	@GetMapping("/vacaciones3")
	public String vacacionesp1(Model model) {
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones3")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}
	
	@GetMapping("/bajas3")
	public String bajasp1(Model model) {
		return "bajas";
	}
	
	@PostMapping("/bajas3")
	public String bajasp(Model model) {
		return "bajas";
	}
	
	@GetMapping("/turnos3")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos3")
	public String turnosp(Model model) {
		return "turnos";
	}
	
	
}


