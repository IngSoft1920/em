package ingsoft1920.em.Model;

public class EmpleadoModelC3 {
	private int id_Empleado;
	private int id_Hotel;
	private String rol;
	
	//Modelo para la consulta3
	public EmpleadoModelC3(int id_Empleado, int id_Hotel,String rol) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Hotel=id_Hotel;
		this.rol=rol;
		}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public int getId_Hotel() {
		return id_Hotel;
	}
	
	public void setId_Hotel(int id_Hotel) {
		this.id_Hotel = id_Hotel;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	


}
