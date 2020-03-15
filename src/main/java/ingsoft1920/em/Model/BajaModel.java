package ingsoft1920.em.Model;

import java.sql.Date;

import javax.validation.Valid;

import ingsoft1920.em.Beans.BajaBean;

public class BajaModel {
	private int id_Empleado;
	private int id_Baja;
	private int duracion;
	private String estado;
	Date fecha_inicio;
	Date fecha_fin;
	
	public BajaModel(int id_Empleado,int id_Baja, int duracion,String estado,Date fecha_inicio,Date fecha_fin) {
		this.id_Empleado=id_Empleado;
		this.id_Baja=id_Baja;
		this.duracion=duracion;
		this.estado=estado;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
	}
	
	public BajaModel(BajaBean baja) {
		this.id_Empleado=baja.getId_empleado();
		this.id_Baja=baja.getId_baja();
		this.duracion=baja.getDuracion();
		this.estado=baja.getEstado();
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

	public int getId_Baja() {
		return id_Baja;
	}

	public void setId_Baja(int id_Baja) {
		this.id_Baja = id_Baja;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

}
