package ingsoft1920.em.Model;

public class EmpleadoModel {
//esto instancia objetos 
	private int id_Empleado;
	private int id_Turno;
	
	//Modelo para la consulta1
	public EmpleadoModel(int id_Empleado, int id_Turno) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Turno=id_Turno;
		}
	
	public int getId_Empleado() {
		return id_Empleado;
	}
	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}
	public int getId_Turno() {
		return id_Turno;
	}
	public void setId_Turno(int id_Turno) {
		this.id_Turno = id_Turno;
	}
}
	