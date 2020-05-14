package ingsoft1920.em.Model;

import java.sql.Date;

import ingsoft1920.em.Beans.BajaBean;

public class AceptarModel {

	private String nombre;
	private int duracion;
	private String tipo;
	
	public AceptarModel(String nombre, String tipo, int duracion) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.duracion=duracion;
	}
	
//	public AceptarModel(BajaBean baja) {
//		this.nombre=baja.getId_empleado();
//		this.id_Baja=baja.getId_baja();
//		this.duracion=baja.getDuracion();
//		this.estado=baja.getEstado();
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	



}
