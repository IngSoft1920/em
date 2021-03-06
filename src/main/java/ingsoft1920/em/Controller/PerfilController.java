package ingsoft1920.em.Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.TurnoModel;

@Controller 
public class PerfilController {
	
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu2")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu2")
	public String menup(Model model) {
		return "menu";
	}
	@GetMapping("/turnos2")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos2")
	public String turnosp(Model model) {
		return "turnos";
	}
	@GetMapping("/nomina2")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina2")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil2")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(LoginController.id_empleado);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil2")
	public String perfilp(Model model) {
		return "perfilPrueba";
	}
	
	@GetMapping("/cerrar2")
	public String cerrarp1(Model model) {
		return "redirect:";
	}
	
	@PostMapping("/cerrar2")
	public String cerrarp(Model model) {
		return "redirect:";
	}
	
	@GetMapping("/tareas2")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas2")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	@GetMapping("/ausencias2")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencias2")
	public String ausenciasp(Model model) {
		return "ausencias";
	}
	
	@GetMapping("/registro2")
	public String registrop1(Model model, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, InterruptedException {
		java.sql.Time horaCheckout = HorarioDAO.horaCheckOut();
		java.sql.Time horaCheckin = HorarioDAO.horaCheckIn();
		request.setAttribute("horaCI", horaCheckin);
		request.setAttribute("horaCO", horaCheckout);
		
		// Para calcular el timepo trabajado a partir de la hora actual
				int horaA,minutosA,segundosA, horaC,minutosC,segundosC;
				horaC = horaCheckin.getHours();
				minutosC = horaCheckin.getMinutes();
				segundosC = horaCheckin.getSeconds();		
				Calendar calendario = Calendar.getInstance();
				horaA = calendario.get(Calendar.HOUR_OF_DAY);
				minutosA = calendario.get(Calendar.MINUTE);
				segundosA = calendario.get(Calendar.SECOND);		 
				int horaAenSeg = horaA*3600 + minutosA*60 + segundosA;
				int horaCenSeg = horaC*3600 + minutosC*60 + segundosC;
				int tiempoTrabajado = horaAenSeg - horaCenSeg;		
				int horaFinal=tiempoTrabajado/3600;
		        int minFinal=(tiempoTrabajado-(3600*horaFinal))/60;
		        int segFianl=tiempoTrabajado-((horaFinal*3600)+(minFinal*60));
		        String tiempoFinal = String.valueOf(horaFinal)+":"+ String.valueOf(minFinal)+":"+String.valueOf(segFianl);
		        request.setAttribute("tiempo", tiempoFinal);
		return "registro";
	}
	
	@PostMapping("/registro2")
	public String registrop(Model model) {
		return "registro";
	}
	
	@GetMapping("/contrasena")
	public String contrasenap1(Model model) {
		return "contrasena";
	}
	
	@PostMapping("/contrasena")
	public String contrasenap(Model model) {
		return "contrasena";
	}

	
}


