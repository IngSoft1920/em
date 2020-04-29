package ingsoft1920.em.Beans;

public class NominasBean {
	private int id_nomina;
	private int id_empleado;
	private int id_incentivo;
	private int id_sueldo;
	private int valor;
	private String nombre;
	
	public NominasBean() {}
	
	public NominasBean(int id_nomina, int id_empleado, int id_incentivo, int id_sueldo, int valor) {
		this.id_nomina = id_nomina;
		this.id_empleado = id_empleado;
		this.id_incentivo = id_incentivo;
		this.id_sueldo = id_sueldo;
		this.valor = valor;
	}
	public int getId_nomina() {
		return id_nomina;
	}
	public void setId_nomina(int id_nomina) {
		this.id_nomina = id_nomina;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public int getId_incentivo() {
		return id_incentivo;
	}
	public void setId_incentivo(int id_incentivo) {
		this.id_incentivo = id_incentivo;
	}
	public int getId_sueldo() {
		return id_sueldo;
	}
	public void setId_sueldo(int id_sueldo) {
		this.id_sueldo = id_sueldo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
