package ingsoft1920.em.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;

@Controller 
public class ContrasenaController {
	
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu8")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu8")
	public String menup(Model model) {
		return "menu";
	}
	@GetMapping("/turnos8")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos8")
	public String turnosp(Model model) {
		return "turnos";
	}
	@GetMapping("/nomina8")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina8")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil8")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(LoginController.id_empleado);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil8")
	public String perfilp(Model model) {
		return "perfilPrueba";
	}
	
	@GetMapping("/cerrar8")
	public String cerrarp1(Model model) {
		return "redirect:";
	}
	
	@PostMapping("/cerrar8")
	public String cerrarp(Model model) {
		return "redirect:";
	}
	
	@GetMapping("/tareas8")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas8")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/ausencias8")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencias8")
	public String ausenciasp(Model model) {
		return "ausencias";
	}
	
	@GetMapping("/registro8")
	public String registrop1(Model model) {
		return "registro";
	}
	
	@PostMapping("/registro8")
	public String registrop(Model model) {
		return "registro";
	}

	
	@GetMapping("/cambiocontrasenia")
	public String contraseña(Model model) {
		return "perfilPrueba";
		
	}
	
	@PostMapping("/cambiocontrasenia")
	public String contrasena1(HttpServletRequest request, HttpServletResponse 
			response) {
		response.setContentType("text/html;charset=UTF-8");
		String accion=request.getParameter("accion");
		if(accion.equals("Enviar")) {
			String contra=request.getParameter("inicio");
			String correo= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado).getCorreo();
			EmpleadoDAO.cambiarContraseña(correo, contra);	
		}

		return "perfilPrueba";
	}
	
}