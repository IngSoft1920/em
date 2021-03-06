	package ingsoft1920.em.Controller;

	import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

	import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.LoginBean;
import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.DAO.BajaDAO;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.TurnoDAO;
	import ingsoft1920.em.DAO.VacacionesDAO;
import ingsoft1920.em.Model.AceptarModel;
import ingsoft1920.em.Model.TurnoModel;
	import ingsoft1920.em.Model.VacacionesModel;

	@Controller

		public class AceptarController {

		final static Logger logger = LogManager.getLogger(LoginController.class.getName());

		@GetMapping("/menu9")
		public String loginp(Model model) {
			return "menu";
		}

		@PostMapping("/menu9")
		public String menup(Model model) {
			return "menu";
		}

		@GetMapping("/nomina9")
		public String nominap1(Model model) {
			return "nomina";
		}

		@PostMapping("/nomina9")
		public String nominap(Model model) {
			return "nomina";
		}

		@GetMapping("/perfil9")
		public String perfilp1(Model model) {
			DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(LoginController.id_empleado);
			model.addAttribute("empleado", empleado);
			return "perfilPrueba";
		}

		@PostMapping("/perfil9")
		public String perfilp(Model model) {
			return "perfilPrueba";
		}

		@GetMapping("/cerrar9")
		public String cerrarp1(Model model) {
			return "redirect:";
		}

		@PostMapping("/cerrar9")
		public String cerrarp(Model model) {
			return "redirect:";
		}

		@GetMapping("/tareas9")
		public String tareasp1(Model model) {
			List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
			model.addAttribute("tareas", tareas);
			return "tareaPrueba";
		}

		@PostMapping("/tareas9")
		public String tareasp(Model model) {
			return "tareaPrueba";
		}
		
		@GetMapping("/turnos9")
		public String turnosp(Model model) {
			List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
			model.addAttribute("turnos", turnos);
			return "turnos";
		}

		@GetMapping("/ausencias9")
		public String ausenciasp1(Model model) {
			return "ausencias";
		}

		@PostMapping("/ausencias9")
		public String ausenciasp(Model model) {
			return "ausencias";
		}
		
		@GetMapping("/registro9")
		public String registro(Model model, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, InterruptedException {
			
			java.sql.Time horaCheckout = HorarioDAO.horaCheckOut();
			java.sql.Time horaCheckin = HorarioDAO.horaCheckIn();
			request.setAttribute("horaCI", horaCheckin);
			request.setAttribute("horaCO", horaCheckout);
			RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			
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
		
		@PostMapping("/registro9")
		public String registro(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
				Model model) {
			return "registro";
		}
		
		@GetMapping("/denegarBaja")
		public String eliminarBaja(Model model) {
			List<AceptarModel> bajas=BajaDAO.aceptar();
			model.addAttribute("bajas", bajas);
			List<AceptarModel> vacaciones = VacacionesDAO.aceptar();// esto saca nombre, tipo, fecha inicio y fecha fin de las vacaciones 
			model.addAttribute("vacaciones",vacaciones);
			return "aceptar";
		}
		
		@PostMapping("/denegarBaja/{parametro}")
		public String denegarBaja(Model model, @PathVariable("parametro") int id_bajas) {
			BajaDAO.denegarBaja(id_bajas);
			return "redirect:/denegarBaja";
		}
		
		@GetMapping("/aceptarBaja")
		public String aceptarBaja(Model model) {
			List<AceptarModel> bajas=BajaDAO.aceptar();
			model.addAttribute("bajas", bajas);
			List<AceptarModel> vacaciones = VacacionesDAO.aceptar();// esto saca nombre, tipo, fecha inicio y fecha fin de las vacaciones 
			model.addAttribute("vacaciones",vacaciones);
			return "aceptar";
		}
		
		@PostMapping("/aceptarBaja/{parametro}")
		public String aceptarBaja(Model model, @PathVariable("parametro") int id_bajas) {
			BajaDAO.aceptarBaja(id_bajas);
			return "redirect:/aceptarBaja";
		}
		
		
		@GetMapping("/denegarVacaciones")
		public String eliminarVacaciones(Model model) {
			List<AceptarModel> vacaciones=VacacionesDAO.aceptar();
			model.addAttribute("vacaciones", vacaciones);
			List<AceptarModel> bajas=BajaDAO.aceptar();
			model.addAttribute("bajas", bajas);
			return "aceptar";
		}
		@PostMapping("/denegarVacaciones/{parametro}")
		public String eliminarVacaciones(Model model, @PathVariable("parametro") int id_vacaciones) {
			VacacionesDAO.denegarVacaciones(id_vacaciones);
			return "redirect:/denegarVacaciones";
		}
		
		
		@GetMapping("/aceptarVacaciones")
		public String aceptarVacaciones(Model model) {
			List<AceptarModel> vacaciones=VacacionesDAO.aceptar();
			model.addAttribute("vacaciones", vacaciones);
			List<AceptarModel> bajas=BajaDAO.aceptar();
			model.addAttribute("bajas", bajas);
			return "aceptar";
		}
		@PostMapping("/aceptarVacaciones/{parametro}")
		public String aceptarVacaciones(Model model, @PathVariable("parametro") int id_vacaciones) {
			VacacionesDAO.aceptarVacaciones(id_vacaciones);
			return "redirect:/aceptarVacaciones";
		}
		
		

	}
