package ingsoft1920.em.Model;

public class VacacionesModel {
	private int id_Empleado;
	private int id_Vacaciones;
	private String duracion;
	
	public VacacionesModel(int id_Empleado,int id_Vacaciones, String duracion) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Vacaciones=id_Vacaciones;
		this.duracion=duracion;
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}
