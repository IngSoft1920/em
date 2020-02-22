package ingsoft1920.em.Beans;

public class BajasBean {
	int id_baja; 
	int id_empleado; 
	String duracion;
	 
	public BajasBean() {}; 
	 
	public BajasBean(int id_baja,int id_empleado, String duracion) { 
		this.id_baja=id_baja; 
		this.id_empleado=id_empleado; 
		this.duracion=duracion;
	} 
	public int getId_baja() { 
		return id_baja; 
	} 
	public void setId_vacaciones(int id_baja) { 
		this.id_baja=id_baja; 
	} 
	public int getId_empleado() { 
		return id_empleado; 
	} 
 
	public void setId_empleado(int id_empleado) { 
		this.id_empleado=id_empleado; 
	} 
	public String getduracion() { 
		return duracion; 	
	} 
	public void setDuracion(String duracion) {
		this.duracion=duracion;
	}

}
