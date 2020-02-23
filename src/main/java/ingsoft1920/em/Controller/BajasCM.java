package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.VacacionBean;
import ingsoft1920.em.Servicios.HttpClient;

public class BajasCM {
	public static BajaBean peticionPedirBaja(){
		try {
			HttpClient client = new HttpClient("http://localhost:7004/getBaja","GET");
			int respCode = client.getResponseCode();
			BajaBean res=new BajaBean();
			if(respCode==200) {
				String resp = client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				res.setId_baja(obj.get("id_baja").getAsInt());
				res.setId_empleado(obj.get("id_empleado").getAsInt());
				res.setDuracion(obj.get("duracion").getAsString());
				res.setEstado(obj.get("estado").getAsBoolean());
				
				return res;	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}

