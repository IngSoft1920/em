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
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/getTarea/1","GET");
			int respCode = client.getResponseCode();
		
			if(respCode==200){
				//parseamos respuesta
				String resp=client.getResponseBody();
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				//obtenemos los 3 campos
				JsonArray id_TareaLista=obj.get("id_TareaLista").getAsJsonArray();
				int[] id_Tareas= new int[id_TareaLista.size()];
				
				int id_empleado=obj.get("empleado_id").getAsInt();
				
				JsonArray id_DescripcionTareaLista=obj.get("descripcionLista").getAsJsonArray();
				String[] id_Descripciones= new String[id_DescripcionTareaLista.size()];
				
				JsonArray horaInicio=obj.get("horaInicio").getAsJsonArray();
				String[] horasInicio= new String[horaInicio.size()];
				
				JsonArray horaFin=obj.get("horaFin").getAsJsonArray();
				String[] horasFin= new String[horaFin.size()];

				JsonArray dia=obj.get("dia").getAsJsonArray();
				String[] dias= new String[dia.size()];
				
				//Creamos objeto de salida
				List<ActividadBean> lista=new ArrayList<ActividadBean>();
				//Añadimos la info
				for(int i=0;i<id_TareaLista.size();i++) {
					id_Tareas[i]=id_TareaLista.get(i).getAsInt();
					id_Descripciones[i]=id_DescripcionTareaLista.get(i).getAsString();
					horasInicio[i]=horaInicio.get(i).getAsString();
					horasFin[i]=horaFin.get(i).getAsString();
					dias[i]=dia.get(i).getAsString();
					lista.add(new ActividadBean(id_Tareas[i], id_empleado,id_Descripciones[i],horasInicio[i],horasFin[i],dias[i]));
				}
			return lista;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
