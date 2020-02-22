package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.VacacionesBean;
import ingsoft1920.em.Servicios.HttpClient;

public class VacacionesCM {
	public static List<VacacionesBean> peticionPedirVacaciones(){
		try {
			HttpClient client = new HttpClient("http://localhost:7004/getVacaciones","GET");
			int respCode = client.getResponseCode();
			
			if(respCode==200) {
				String resp = client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				JsonArray id_VacacionesLista = obj.get("id_vacaciones").getAsJsonArray();
				int[] id_Vacaciones = new int[id_VacacionesLista.size()];
				JsonArray id_EmpleadoLista = obj.get("id_empleado").getAsJsonArray();
				int[] id_Empleados = new int[id_EmpleadoLista.size()];
				JsonArray duracionVacacionesLista = obj.get("duracion").getAsJsonArray();
				String[] duracionVacaciones = new String[duracionVacacionesLista.size()];
				List<VacacionesBean> lista = new ArrayList<VacacionesBean>();
				
				for(int i=0;i<id_VacacionesLista.size();i++) {
					id_Vacaciones[i]=id_VacacionesLista.get(i).getAsInt();
					id_Empleados[i]=id_EmpleadoLista.get(i).getAsInt();
					duracionVacaciones[i]=duracionVacacionesLista.get(i).getAsString();
					lista.add(new VacacionesBean(id_Vacaciones[i],id_Empleados[i],duracionVacaciones[i]));
					
				}
				return lista;	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

}
