package ingsoft1920.em.Beans;

import org.springframework.stereotype.Component;

@Component
public class ActividadBean {
	int id_tarea;
	int id_empleado;
	String descripcionTarea;
	
	
	public ActividadBean() {}
	
	public ActividadBean(int id_tarea, int id_empleado, String descripcionTarea) {
		this.id_tarea = id_tarea;
		this.id_empleado = id_empleado;
		this.descripcionTarea = descripcionTarea;
	}
	
	public int getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getDescripcionTarea() {
		return descripcionTarea;
	}
	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}
	
	
}
