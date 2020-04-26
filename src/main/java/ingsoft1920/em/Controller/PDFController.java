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

import ingsoft1920.em.DAO.HorarioDAO;
import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.Model.NominaModel;
import ingsoft1920.em.Servicios.GenerarPDF;

@Controller
public class PDFController {
	
	@RequestMapping(value = "/generarPDF/{parametro}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina( @PathVariable("parametro") int mes){
		float horas,sueldo;
		
		List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado);
		
		horas=HorarioDAO.horasAlMes(LoginController.id_empleado, mes);
		sueldo=NominaDAO.verSueldo(LoginController.id_empleado);
		if(horas<80) {
			sueldo=sueldo-100;
		}
		
		
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,sueldo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
	
	

}
