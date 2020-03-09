package ingsoft1920.em.Model;

public class VacacionesModel {
	private int id_Empleado;
	private int id_Vacaciones;
	private int duracion;
	private String estado;
	
	public VacacionesModel(int id_Empleado,int id_Vacaciones, int duracion,String estado) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Vacaciones=id_Vacaciones;
		this.duracion=duracion;
		this.estado=estado;
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
