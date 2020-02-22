package ingsoft1920.em.Beans;

public class BajasBean {
	int id_baja; 
	int id_empleado; 
	String bajaInicio; 
	String bajaFin; 
	 
	public BajasBean() {}; 
	 
	public BajasBean(int id_baja,int id_empleado, String bajaInicio, String bajaFin) { 
		this.id_baja=id_baja; 
		this.id_empleado=id_empleado; 
		this.bajaInicio=bajaInicio; 
		this.bajaFin=bajaFin; 
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
	public String getBajaInicio() { 
		return bajaInicio; 
	} 
	public void setVacacionesInicio(String bajaInicio) { 
		this.bajaInicio=bajaInicio; 
	} 
	public String getBajaFin() { 
		return bajaFin; 
	} 

}
