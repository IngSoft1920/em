package ingsoft1920.em.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ingsoft1920.em.Servicios.HttpClient;

@Controller
public class verPDFController {
	@RequestMapping(value = "/verPDF", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	
	public static ResponseEntity<InputStream> verPDF() throws Exception {
		InputStream is = null;
		HttpHeaders headers = null;
		try {			
			// Abrimos el archivo
			File file = new File("./files/");
			if (!file.exists()) {
				throw new Exception("PDF does not exist");
			}
			// Obtenemos el InputStream del fichero
			is = new FileInputStream(file);
			// Marcamos respuesta en cabecera
			headers = new HttpHeaders();
			headers.add("Content-Disposition","inline; filename=upload.pdf");
			
			

		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
                .body(is);
	}
}
	



			

