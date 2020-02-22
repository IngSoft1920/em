package ingsoft1920.em.Beans;

public class VacacionesBean {
	int id_vacaciones;
	int id_empleado;
	String duracion;
	
	public VacacionesBean() {};
	
	public VacacionesBean(int id_vacaciones,int id_empleado, String duracion) {
		this.id_vacaciones=id_vacaciones;
		this.id_empleado=id_empleado;
		this.duracion=duracion;
	}
	public int getId_vacaciones() {
		return id_vacaciones;
	}
	public void setId_vacaciones(int id_vacaciones) {
		this.id_vacaciones=id_vacaciones;
	}
	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado=id_empleado;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion=duracion;
	}

}
