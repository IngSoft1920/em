package ingsoft1920.em.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

import ingsoft1920.em.DAO.NominaDAO;
import ingsoft1920.em.Model.NominaModel;
import ingsoft1920.em.Servicios.GenerarPDF;

public class PDFController {
	
	@RequestMapping(value = "/gererarPDF", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public ResponseEntity<InputStreamResource> generarNomina(){
		
		List<NominaModel> nominas = NominaDAO.verNomina(1);
		
		ByteArrayInputStream gPDF = GenerarPDF.generarPDF(nominas);	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline; filename=generarPDF.pdf");
		
				
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(gPDF));
		
	}
	
	

}
