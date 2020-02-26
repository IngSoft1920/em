package ingsoft1920.em.Model;

public class EmpleadoModelC2 {
	private int id_Empleado;
	private String nombre;
	private boolean estado;
	
	//Modelo para la consulta2
	public EmpleadoModelC2(int id_Empleado, String nombre, boolean estado) {
		super();
		this.id_Empleado=id_Empleado;
		this.nombre=nombre;
		this.estado=estado;
		}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
