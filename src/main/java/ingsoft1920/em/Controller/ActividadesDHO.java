package ingsoft1920.em.Controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Servicios.HttpClient;

public class ActividadesDHO {
	public static List<ActividadBean> peticionPedirTarea() {
		try {
			HttpClient client= new HttpClient("http://localhost:7001/getTarea","GET");
			int respCode = client.getResponseCode();
		
			if(respCode==200){
				String resp=client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				JsonArray id_TareaLista=obj.get("id_tarea").getAsJsonArray();
				int[] id_Tareas= new int[id_TareaLista.size()];
				JsonArray id_EmpleadoLista=obj.get("id_empleado").getAsJsonArray();
				int[] id_Empleados= new int[id_EmpleadoLista.size()];
				JsonArray id_DescripcionTareaLista=obj.get("descripcionTarea").getAsJsonArray();
				String[] id_Descripciones= new String[id_DescripcionTareaLista.size()];
				List<ActividadBean> lista=new ArrayList<ActividadBean>();
				
				for(int i=0;i<id_TareaLista.size();i++) {
					id_Tareas[i]=id_TareaLista.get(i).getAsInt();
					id_Empleados[i]=id_EmpleadoLista.get(i).getAsInt();
					id_Descripciones[i]=id_DescripcionTareaLista.get(i).getAsString();
					lista.add(new ActividadBean(id_Tareas[i], id_Empleados[i],id_Descripciones[i]));
				}
			return lista;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
