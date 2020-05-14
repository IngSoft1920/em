package ingsoft1920.em.Model;

import java.sql.Date;

import ingsoft1920.em.Beans.BajaBean;

public class AceptarModel {

	private String nombre;
	Date fecha_inicio;
	Date fecha_fin;
	private String tipo;
	
	public AceptarModel(String nombre, String tipo, Date fecha_inicio,Date fecha_fin) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	



}
