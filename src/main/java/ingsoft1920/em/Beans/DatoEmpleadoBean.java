package ingsoft1920.em.Beans;

public class DatoEmpleadoBean {
	int id_empleado;
	int estado;
	int id_rol;
	String nombre;
	public DatoEmpleadoBean() {}
	
	public DatoEmpleadoBean(int empleado_id,int estado_id,int rol_id,String nombre) {
		this.id_empleado=empleado_id;
		this.estado=estado_id;
		this.id_rol=rol_id;
		this.nombre=nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public void doWhatEver() {}
}
