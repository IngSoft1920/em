<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 
<%@ page import="org.apache.commons.fileupload.disk.*" %> 
<%@ page import="org.apache.commons.fileupload.servlet.*" %> 
<%@ page import="org.apache.commons.io.*" %> 
<%@ page import="java.io.*" %> 
<html lan="es"> 
<head> 
<meta charset="utf-8""> 
</head> 
<body> 
<script type="text/javascript"> 
 
    //FileItemFactory es una interfaz para crear FileItem 
    FileItemFactory factory = new DiskFileItemFactory(); 
    //ServletFileUpload esta clase convierte los input file a FileItem 
    ServletFileUpload upload = new ServletFileUpload(factory); 
    //sacando los FileItem del ServletFileUpload en una lista  
    List items = upload.parseRequest(request); 
    /* 
      request es la HttpServletRequest que recibimos del formulario 
      Los items obtenidos ser�n cada uno de los campos del formulario 
      tanto campos normales como ficheros subidos 
    */  
     
    //Se recorren todos los items, que son de tipo FileItem 
    for(Object item : items){ 
        //FileItem representa un archivo en memoria que puede ser pasado al disco duro 
        FileItem uploaded = (FileItem) item; 
        /*  
           Hay que comprobar si es un campo de formulario.  
           Si no lo es, se guarda el fichero subido donde nos interese 
        */ 
        if (!uploaded.isFormField()){ 
            //No es campo de formulario, guardamos el fichero 
            File fichero = new File("C:\Users\alici\Desktop\ejemplo", uploaded.getName()); 
            uploaded.write(archivo_server); 
        } 
    } 
             
             
            	 
     </script>    	 
</body> 
</html>
