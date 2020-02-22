package ingsoft1920.em.Beans;

public class VacacionesBean {
	int id_vacaciones;
	int id_empleado;
	String vacacionesInicio;
	String vacacionesFin;
	
	public VacacionesBean() {};
	
	public VacacionesBean(int id_vacaciones,int id_empleado, String vacacionesInicio, String vacacionesFin) {
		this.id_vacaciones=id_vacaciones;
		this.id_empleado=id_empleado;
		this.vacacionesInicio=vacacionesInicio;
		this.vacacionesFin=vacacionesFin;
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
	public String getVacacionesInicio() {
		return vacacionesInicio;
	}
	public void setVacacionesInicio(String vacacionesInicio) {
		this.vacacionesInicio=vacacionesInicio;
	}
	public String getVacacionesFin() {
		return vacacionesFin;
	}

}
