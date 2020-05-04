package ingsoft1920.em.Controller;


import com.google.gson.JsonObject;

import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.Servicios.HttpClient;

public class VacacionesCM {
	public static void peticionPedirVacaciones(VacacionBean vacaciones,int ausencia_id,int empleado_id){
		try {
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/ausencia","POST");
			JsonObject obj = new JsonObject();
			obj.addProperty("ausencia_id", ausencia_id);
			obj.addProperty("motivo", "vacaciones");
			obj.addProperty("fecha_inicio", vacaciones.getFecha_inicio().toString());
			obj.addProperty("fecha_fin", vacaciones.getFecha_fin().toString());
			obj.addProperty("empleado_id", empleado_id);
			
			client.setRequestBody(obj.toString());
		
			int respCode = client.getResponseCode();
			
			if(respCode!=200) {
				System.out.println("Ha habido un error");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
