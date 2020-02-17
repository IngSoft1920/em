package ingsoft1920.em.Model;

public class EmpleadoModel {
//esto instancia objetos 
	private int id_Empleado;
	private int id_Turno;
	private String id_Rol;
	private int estado;
	
	//Modelo para la consulta1
	public EmpleadoModelC1(int id_Empleado, int id_Turno) {
		this.id_Empleado=id_Empleado;
		this.id_Turno=id_Turno;
		}
	//Modelo para la consulta2
	public EmpleadoModelC2(int id_Empleado, String id_Rol, int estado) {
		this.id_Empleado=id_Empleado;
		this.id_Rol=id_Rol;
		this.estado=estado;
	}
}
