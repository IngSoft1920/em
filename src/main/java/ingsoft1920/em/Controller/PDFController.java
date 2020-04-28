package ingsoft1920.em.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.Model.NominaModel;
import ingsoft1920.em.Servicios.GenerarPDF;
import io.micrometer.core.ipc.http.HttpSender.Method;

@Controller
public class PDFController {
	@RequestMapping(value = "/generarPDF/{parametro}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina( @PathVariable("parametro") int mes){
		float horas,sueldo;
		sueldo=-1;
		List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		horas=HorarioDAO.horasAlMes(LoginController.id_empleado, mes);
		if(horas==0) {
			sueldo=0;
		}
		if(horas<80) {
			sueldo=sueldo-100;
		}
		
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,sueldo,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		//List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado);
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
   

}
