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
	@RequestMapping(value = "/generarPDF1", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina1(){
	@RequestMapping(value = "/generarPDF/{parametro}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
		List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
	public ResponseEntity<InputStreamResource> generarNomina( @PathVariable("parametro") int mes){
		float horas,sueldo;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado);
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF2", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina2(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		
		horas=HorarioDAO.horasAlMes(LoginController.id_empleado, mes);
		sueldo=NominaDAO.verSueldo(LoginController.id_empleado);
		System.out.println(horas);
		if(horas<80 ) {
			sueldo=sueldo-100;
		}
		
		if(horas==0) {
			sueldo=0;
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
    
    @RequestMapping(value = "/generarPDF3", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina3(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    
    @RequestMapping(value = "/generarPDF4", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina4(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF5", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina5(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF6", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina6(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF7", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina7(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF8", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina8(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF9", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina9(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF10", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina10(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF11", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina11(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
    @RequestMapping(value = "/generarPDF12", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina12(){
	
    	List<NominaModel> nominas = NominaDAO.verNomina(LoginController.id_empleado,1);
		DatoEmpleadoBean empleado= EmpleadoDAO.sacaEmpleado(LoginController.id_empleado); 
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas,empleado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}

}
