package ingsoft1920.em.Controller;

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
import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;




@Controller 
public class AusenciasController {

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
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil4")
	public String perfilp(Model model) {
		return "perfil";
	}
	
	@GetMapping("/cerrar4")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar4")
	public String cerrarp(Model model) {
		return "login";
	}
	
	@GetMapping("/volver4")
	public String volverp1(Model model) {
		return "menu";
	}
	
	@PostMapping("/volver4")
	public String volverp(Model model) {
		return "menu";
	}
	
	@GetMapping("/ausencias4")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencias4")
	public String ausenciasp(Model model) {
		return "ausencias";
	}
	
	@GetMapping("/tareas4")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas4")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/turnos4")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos4")
	public String turnosp(Model model) {
		return "turnos";
	}
	
	@GetMapping("/vacaciones4")
	public String vacacionesp1(Model model) {
		HorarioDAO.checkin(1);
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones4")
	public String vacacionesp(Model model) {
		return "vacaciones";
	}
	
	
	@GetMapping("/bajas4")
	public String bajasp1(Model model) {
		HorarioDAO.checkout(1);
		return "bajas";
	}
	
	@PostMapping("/bajas4")
	public String bajasp(Model model) {
		return "bajas";
	}
	
	@GetMapping("/registro4")
	public String registrop1(Model model) {
		return "registro";
	}
	
	@PostMapping("/registro4")
	public String registrop(Model model) {
		return "registro";
	}
	
	@GetMapping("/checkin")
	public String checkin(Model model) {
		HorarioDAO.checkin(1);
		return "menu";
	}
	@PostMapping("/checkin")
	public String checkinp(Model model) {
		return "menu";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		HorarioDAO.checkout(1);
		return "menu";
	}
	@PostMapping("/checkout")
	public String checkoutp(Model model) {
		return "menu";
	}
	
	
}