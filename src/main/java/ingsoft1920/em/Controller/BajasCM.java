package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.BajasBean;
import ingsoft1920.em.Servicios.HttpClient;

public class BajasCM {
	public static List<BajasBean> peticionPedirBaja(){
		try {
			HttpClient client = new HttpClient("http://localhost:7004/getVacaciones","GET");
			int respCode = client.getResponseCode();
			
			if(respCode==200) {
				String resp = client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				JsonArray id_BajaLista = obj.get("id_baja").getAsJsonArray();
				int[] id_Bajas = new int[id_BajaLista.size()];
				JsonArray id_EmpleadoLista = obj.get("id_empleado").getAsJsonArray();
				int[] id_Empleados = new int[id_EmpleadoLista.size()];
				JsonArray ListaInicioBaja = obj.get("bajaInicio").getAsJsonArray();
				String[] inicioBaja = new String[ListaInicioBaja.size()];
				JsonArray ListaFinBaja = obj.get("bajaFin").getAsJsonArray();
				String[] finBaja = new String[ListaFinBaja.size()];
				List<BajasBean> lista = new ArrayList<BajasBean>();
				
				for(int i=0;i<id_BajaLista.size();i++) {
					id_Bajas[i]=id_BajaLista.get(i).getAsInt();
					id_Empleados[i]=id_EmpleadoLista.get(i).getAsInt();
					inicioBaja[i]=ListaInicioBaja.get(i).getAsString();
					finBaja[i]=ListaFinBaja.get(i).getAsString();
				}
				return lista;	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}

