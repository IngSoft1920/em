package ingsoft1920.em.Controller;

import com.google.gson.JsonObject;
import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Servicios.HttpClient;

public class BajasCM {
	public static void peticionPedirBaja(int id_empleado,int ausencia_id,BajaBean baja){
		try {
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/ausencia","POST");
			JsonObject obj = new JsonObject();
			obj.addProperty("ausencia_id", ausencia_id);
			obj.addProperty("motivo", "baja");
			obj.addProperty("fecha_inicio", baja.getFecha_inicio().toString());
			obj.addProperty("fecha_fin", baja.getFecha_fin().toString());
			obj.addProperty("empleado_id", id_empleado);
			
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

