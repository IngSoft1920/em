
package ingsoft1920.em.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {
    @Value("${wb.fileLocation}")
	private String fileLocation;
	@Value("${wb.fileDirection}")
	private String fileDirection;	

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody String hadleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		if(!file.isEmpty()) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileLocation + name)));
				stream.write(bytes);
				stream.close();
				return fileDirection + name;
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
