package ingsoft1920.em.Model;

public class EmpleadoModelC2 {
	private int id_Empleado;
	private String id_Rol;
	private int estado;
	
	//Modelo para la consulta2
	public EmpleadoModelC2(int id_Empleado, String id_Rol, int estado) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Rol=id_Rol;
		this.estado=estado;
		}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public String getId_Rol() {
		return id_Rol;
	}

	public void setId_Rol(String id_Rol) {
		this.id_Rol = id_Rol;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
