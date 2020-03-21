package ingsoft1920.em.Model;

public class EmpleadoModelC4 {
	private int empleado_id;
	private int hotel_id;
	private String rol;
	private int sueldo;
	private int incentivo;
	
	public EmpleadoModelC4(int empleado_id,int hotel_id,String rol, int sueldo, int incentivo) {
		this.empleado_id=empleado_id;
		this.hotel_id=hotel_id;
		this.rol=rol;
		this.sueldo=sueldo;
		this.incentivo=incentivo;
	}

	public int getEmpleado_id() {
		return empleado_id;
	}

	public void setEmpleado_id(int empleado_id) {
		this.empleado_id = empleado_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(int incentivo) {
		this.incentivo = incentivo;
	}
	

}
