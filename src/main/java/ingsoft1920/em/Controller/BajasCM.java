package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.BajasBean;
import ingsoft1920.em.Beans.VacacionesBean;
import ingsoft1920.em.Servicios.HttpClient;

public class BajasCM {
	public static List<BajasBean> peticionPedirBaja(){
		try {
			HttpClient client = new HttpClient("http://localhost:7004/getBaja","GET");
			int respCode = client.getResponseCode();
			
			if(respCode==200) {
				String resp = client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				JsonArray id_BajaLista = obj.get("id_baja").getAsJsonArray();
				int[] id_Bajas = new int[id_BajaLista.size()];
				JsonArray id_EmpleadoLista = obj.get("id_empleado").getAsJsonArray();
				int[] id_Empleados = new int[id_EmpleadoLista.size()];
				JsonArray duracionBajaLista = obj.get("duracion").getAsJsonArray();
				String[] duracionBaja = new String[duracionBajaLista.size()];
				List<BajasBean> lista = new ArrayList<BajasBean>();
				
				for(int i=0;i<id_BajaLista.size();i++) {
					id_Bajas[i]=id_BajaLista.get(i).getAsInt();
					id_Empleados[i]=id_EmpleadoLista.get(i).getAsInt();
					duracionBaja[i]=duracionBajaLista.get(i).getAsString();
					lista.add(new BajasBean(id_Bajas[i],id_Empleados[i],duracionBaja[i]));
				}
				return lista;	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}

