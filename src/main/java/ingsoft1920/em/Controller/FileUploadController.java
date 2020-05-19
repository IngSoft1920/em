
package ingsoft1920.em.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
   
	@PostMapping("/upload")
	public @ResponseBody String hadleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		if(!file.isEmpty()) {
			
			String name = file.getOriginalFilename();
			try {
				
				File f = new File("./files/"+name);
	            f.createNewFile();
	            OutputStream os = new FileOutputStream(f);
				IOUtils.copy(file.getInputStream(), os);
				os.close();				
				return "Succeed";
			}catch (Exception e) {
				response.setStatus((HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
				return "Failed to upload" + name + "->" + e.getMessage();
			}
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Empty file";
		}
	}
	
	
	

}
