package ingsoft1920.em.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.LoginBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;

@Controller
public class MenuController {
	
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
static boolean checkinDone = false;
	
	@GetMapping("/menu")
	public String menu(Model model) {
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
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(1);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil")
	public String perfil(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "perfilPrueba";
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
	
	@GetMapping("/tareas")
	public String tareas(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas")
	public String tareas(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/turnos")
	public String turnos(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos")
	public String turnos(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "turnos";
	}
	
	@GetMapping("/ausencias")
	public String ausencias(Model model)  {
		
		return "ausencias";
	}
	
	@PostMapping("/ausencias")
	public String ausencias(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "ausencias";
	}
	
	@GetMapping("/registro")
	public String registro(Model model, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, InterruptedException {
		
		java.sql.Time horaCheckout = HorarioDAO.horaCheckOut();
		java.sql.Time horaCheckin = HorarioDAO.horaCheckIn();
		request.setAttribute("horaCI", horaCheckin);
		request.setAttribute("horaCO", horaCheckout);
		RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) {
		return "registro";
	}
	
}
