package ingsoft1920.em.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
import ingsoft1920.em.DAO.VacacionesDAO;
import ingsoft1920.em.Model.TurnoModel;




@Controller 
public class AusenciasController extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(LoginController.id_empleado);
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
	public String vacacionesp1(Model model) throws ParseException {
		HorarioDAO.checkin(LoginController.id_empleado);
		int[] res;
		int diasRestantes = 0;
		res = VacacionesDAO.contVacaciones(LoginController.id_empleado,0); // vacaciones.getIdEmpleado()
		diasRestantes = (int) ((res[0] / 30) * 2.5) - res[1]; // if(((dias/30)*2.5)<=duracion+vacacionesGastadas)
		model.addAttribute("diasRestantes", diasRestantes);
		return "vacaciones";
	}
	
	@PostMapping("/vacaciones4")
	public String vacacionesp(Model model) {
	
		return "vacaciones";
	}
	
	
	@GetMapping("/bajas4")
	public String bajasp1(Model model) {
		HorarioDAO.checkout(LoginController.id_empleado);
		return "bajas";
	}
	
	@PostMapping("/bajas4")
	public String bajasp(Model model) {
		return "bajas";
	}
	
	@GetMapping("/aceptar")
	public String aceptar(Model model) {
		return "aceptar";
	}
	
	@PostMapping("/aceptar")
	public String aceptar1(Model model) {
		return "aceptar";
	}
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("/registro4")
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
	
	@PostMapping("/registro4")
	public String registrop(Model model) {
		return "registro";
	}
	
	@GetMapping("/checkin")
	/**
	 *@see HttpServlet#doGet( HttpServletRequest request, HttpServletResponse response)
	 */
	public String checkin(Model model, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, InterruptedException {	
		HorarioDAO.checkin(LoginController.id_empleado);
		
		java.sql.Time horaCheckin = HorarioDAO.horaCheckIn();	
		String horaCheckout = "Todavía no realizado";
		request.setAttribute("horaCI", horaCheckin);
		request.setAttribute("horaCO", horaCheckout);

		//RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		
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
	@PostMapping("/checkin")
	public String checkinp(Model model) {
		return "registro";
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/checkout")
	/**
	 *@see HttpServlet#doGet( HttpServletRequest request, HttpServletResponse response)
	 */
	public String checkout(Model model, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, InterruptedException  {
		HorarioDAO.checkout(LoginController.id_empleado);
		java.sql.Time horaCheckout = HorarioDAO.horaCheckOut();
		java.sql.Time horaCheckin = HorarioDAO.horaCheckIn();
		request.setAttribute("horaCI", horaCheckin);
		request.setAttribute("horaCO", horaCheckout);
		//RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		
		// Para calcular el timepo trabajado desde el checkout
				int horaA,minutosA,segundosA, horaC,minutosC,segundosC;
				horaC = horaCheckin.getHours();
				minutosC = horaCheckin.getMinutes();
				segundosC = horaCheckin.getSeconds();		
				horaA = horaCheckout.getHours();
				minutosA = horaCheckout.getMinutes();
				segundosA = horaCheckout.getSeconds();		 
				int horaAenSeg = horaA*3600 + minutosA*60 + segundosA;
				int horaCenSeg = horaC*3600 + minutosC*60 + segundosC;
				int tiempoTrabajado = horaAenSeg - horaCenSeg;		
				int horaFinal=tiempoTrabajado/3600;
		        int minFinal=(tiempoTrabajado-(3600*horaFinal))/60;
		        int segFianl=tiempoTrabajado-((horaFinal*3600)+(minFinal*60));
		        String tiempoFinal = String.valueOf(horaFinal)+":"+ String.valueOf(minFinal)+":"+String.valueOf(segFianl);
		        request.setAttribute("tiempo", tiempoFinal);
		        
		 // Meter horas trabajadas en la BBDD
		 HorarioDAO.horasTrabajadas(LoginController.id_empleado);       
		return "registro";
	}
	@PostMapping("/checkout")
	public String checkoutp(Model model) {
		return "registro";
	}
	
	
}