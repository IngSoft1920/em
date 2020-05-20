
package ingsoft1920.em.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;



@Controller
public class FileUploadController {

	@PostMapping("/upload/{parametro}")
	public @ResponseBody String hadleFileUpload(@RequestParam("file") MultipartFile file,@PathVariable("parametro") int id_baja, HttpServletRequest request, HttpServletResponse response) {
		if(!file.isEmpty()) {
			

			try {
				
				File f = new File("/hs/em/files/"+id_baja+".pdf");
	            f.createNewFile();
	            OutputStream os = new FileOutputStream(f);
				IOUtils.copy(file.getInputStream(), os);
				os.close();				
				return "Succeed";
			}catch (Exception e) {
				response.setStatus((HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
				return "Failed to upload" + id_baja + "->" + e.getMessage();
			}
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Empty file";
		}
	}
	
	
	

}
