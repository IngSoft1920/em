package ingsoft1920.em.Model;

public class BajaModel {
	private int id_Empleado;
	private int id_Baja;
	private String duracion;
	
	public BajaModel(int id_Empleado,int id_Baja, String duracion) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Baja=id_Baja;
		this.duracion=duracion;
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
