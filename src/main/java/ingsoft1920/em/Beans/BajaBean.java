package ingsoft1920.em.Beans;

import org.springframework.stereotype.Component;

@Component
public class BajaBean {
	int id_baja;
	int id_empleado;
	int duracion;
	boolean estado;
	
	public BajaBean() {}
	
	public BajaBean(int id_baja, int id_empleado, int duracion, boolean estado) {
		this.id_baja = id_baja;
		this.id_empleado = id_empleado;
		this.duracion = duracion;
		this.estado = estado;
	}


	public int getId_baja() {
		return id_baja;
	}

	public void setId_baja(int id_baja) {
		this.id_baja = id_baja;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
