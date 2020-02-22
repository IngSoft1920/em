package ingsoft1920.em.Beans;

public class DatoEmpleadoBean {
	int id_empleado;
	boolean estado;
	int id_rol;
	String nombre;
	String telefono;
	String correo;
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DatoEmpleadoBean() {}
	
	public DatoEmpleadoBean(int empleado_id,boolean estado,int rol_id,String nombre) {
		this.id_empleado=empleado_id;
		this.estado=estado;
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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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
