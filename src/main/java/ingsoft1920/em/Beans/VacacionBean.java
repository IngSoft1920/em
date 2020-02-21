package ingsoft1920.em.Beans;

public class VacacionBean {
	int id_vacacion;
	int id_empleado;
	String duracion;
	boolean estado;
	
	public VacacionBean() {}
	
	public VacacionBean(int id_vacacion, int id_empleado, String duracion, boolean estado) {
		this.id_vacacion = id_vacacion;
		this.id_empleado = id_empleado;
		this.duracion = duracion;
		this.estado = estado;
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
