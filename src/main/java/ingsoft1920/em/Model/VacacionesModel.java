package ingsoft1920.em.Model;

import java.sql.Date;

public class VacacionesModel {
	private int id_Empleado;
	private int id_Vacaciones;
	private int duracion;
	private String estado;
	Date fecha_inicio; 
	Date fecha_fin; 
	
	public VacacionesModel(int id_Empleado,int id_Vacaciones, int duracion,String estado,Date fecha_inicio,Date fecha_fin) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Vacaciones=id_Vacaciones;
		this.duracion=duracion;
		this.estado=estado;
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



	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public int getId_Vacaciones() {
		return id_Vacaciones;
	}

	public void setId_Vacaciones(int id_Vacaciones) {
		this.id_Vacaciones = id_Vacaciones;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
