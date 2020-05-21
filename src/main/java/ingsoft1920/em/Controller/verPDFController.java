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
	@ResponseBody
	@GetMapping("/verPDF/{id_baja}")
	public static void verPDF(@PathVariable("id_baja")int id_baja,HttpServletResponse response) {
		
		try {
			
			//Abrir fichero pedido
			File file = new File("/hs/em/files/"+id_baja+".pdf");
			if(!file.exists())
				throw new Exception("PDF does not exists");
			
			//Obtenemos InputStream del fichero
			InputStream is = new FileInputStream(file);
			//Marcamos respuesta en cabecera
			response.setContentType("application/pdf");
			response.setContentLength((int) file.length());
			response.setStatus(HttpStatus.OK.value());
			// Ponemos el strem del fichero en el stream de la respuesta
			IOUtils.copy(is, response.getOutputStream());
			// Flusheamos buffer para permitir que cliente empiece a recibir info
			response.flushBuffer();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			response.setStatus(HttpStatus.CONFLICT.value());
			response.setContentType("text/plain");
			try {
				PrintWriter w = response.getWriter();
				w.println(ex.getLocalizedMessage());
				response.setContentType("aplication/pdf");
				response.flushBuffer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
