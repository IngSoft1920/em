package ingsoft1920.em.Beans;

import org.springframework.stereotype.Component;

@Component
public class ActividadBean {
	int id_tarea;
	int id_empleado;
	String descripcionTarea;
	String horarioInicio;
	String horarioFin;
	String fecha;
	String lugar;
	
	
	public ActividadBean() {}
	
	public ActividadBean(int id_tarea, int id_empleado, String descripcionTarea,String horarioInicio, String horarioFin,String fecha,String lugar) {
		this.id_tarea = id_tarea;
		this.id_empleado = id_empleado;
		this.descripcionTarea = descripcionTarea;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
		this.fecha=fecha;
		this.lugar=lugar;
	}
	
	
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
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
