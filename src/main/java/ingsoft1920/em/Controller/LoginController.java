package ingsoft1920.em.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.HttpServletBean;
import javax.servlet.http.*;

import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.Beans.LoginBean;
import ingsoft1920.em.DAO.EmpleadoDAO;;

@Controller
public class LoginController extends HttpServlet{

static int id_empleado;
public static int id_hotel;
final static Logger logger = LogManager.getLogger(LoginController.class.getName());
EmpleadoDAO dao= new EmpleadoDAO();
DatoEmpleadoBean p=new DatoEmpleadoBean();
int r;
//	@Autowired
//	LoginBean loginBean;
	
	@GetMapping("/")
	public String login(Model model) {
		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean",loginBean);
		model.addAttribute("mensajeError","");
		return "login";
	}
	
	@PostMapping("/")
	public String loginValida(HttpServletRequest request, HttpServletResponse 
			response,Model model) {
		
		response.setContentType("text/html;charset=UTF-8");
		String accion=request.getParameter("accion");
		
		if(accion.equals("Ingresar")) {
			String correo=request.getParameter("usuario");
			String pass=request.getParameter("contrasenia");
			p.setCorreo(correo);
			p.setContrasenia(pass);
			r=dao.validar(p);
			
			if(r==1) {
				id_empleado=EmpleadoDAO.getIdEmpleado(pass, correo);
				id_hotel = EmpleadoDAO.getHotelId(pass,correo);
				return "menu";
			}
			
			else {
				
				return "login";
			}
		}
		return "login";

		}
		
	
}
