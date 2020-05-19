package ingsoft1920.em.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import ingsoft1920.em.Servicios.HttpClient;

@Controller
public class verPDFController {
	@ResponseBody
	@GetMapping("/verPDF/{parameter}")
	public static FileInputStream verPDF(@PathVariable("parameter") String name, HttpServletResponse response) throws Exception {
		try {			
			// Abrimos el archivo
			File file = new File("./files/"+name);
			if (!file.exists()) {
				throw new Exception("PDF does not exist");
			}
			String fname = file.getName();
			if(fname == name) {
			// Obtenemos el InputStream del fichero
			InputStream is = new FileInputStream(file);
			// Marcamos respuesta en cabecera
			response.setContentType("application/pdf");
			response.setStatus(HttpStatus.OK.value());
			// Ponemos el stream del fichero en el stream de la respuesta
			IOUtils.copy(is, response.getOutputStream());
			// Flusheamos buffer para permitir que cliente empiece a recivir info
			response.flushBuffer();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			response.setStatus(HttpStatus.CONFLICT.value());
			response.setContentType("text/plain");
			try {
				PrintWriter w = response.getWriter();
				w.println(e.getLocalizedMessage());
				response.setContentType("application/pdf");
				response.flushBuffer();
			} catch (IOException er) {
				er.printStackTrace();
			}

		}
		return new FileInputStream(new File("./file"+name));
	}
}
	



			

