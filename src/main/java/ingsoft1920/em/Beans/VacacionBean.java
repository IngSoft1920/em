package ingsoft1920.em.Beans;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class VacacionBean {
	int id_vacacion;
	int id_empleado;
	String duracion;
	Date fecha_inicio;
	Date fecha_fin;
	boolean estado;
	
	public VacacionBean() {}
	
	public VacacionBean(int id_vacacion, int id_empleado, String duracion, boolean estado, Date fecha_inicio, Date fecha_fin) {
		this.id_vacacion = id_vacacion;
		this.id_empleado = id_empleado;
		this.duracion = duracion;
		this.estado = estado;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
	}

	
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getId_vacacion() {
		return id_vacacion;
	}

	public void setId_vacacion(int id_vacacion) {
		this.id_vacacion = id_vacacion;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
