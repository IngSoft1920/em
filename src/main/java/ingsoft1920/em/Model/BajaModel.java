package ingsoft1920.em.Model;

import javax.validation.Valid;

import ingsoft1920.em.Beans.BajaBean;

public class BajaModel {
	private int id_Empleado;
	private int id_Baja;
	private String duracion;
	private boolean estado;
	
	public BajaModel(int id_Empleado,int id_Baja, String duracion,boolean estado) {
		this.id_Empleado=id_Empleado;
		this.id_Baja=id_Baja;
		this.duracion=duracion;
		this.estado=estado;
	}
	
	public BajaModel(BajaBean baja) {
		this.id_Empleado=baja.getId_empleado();
		this.id_Baja=baja.getId_baja();
		this.duracion=baja.getDuracion();
		this.estado=baja.isEstado();
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	

}
