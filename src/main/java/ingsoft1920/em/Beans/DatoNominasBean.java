package ingsoft1920.em.Beans;

public class DatoNominasBean {
	int id_empleado;
	int nomina;
	
	public DatoNominasBean() {};
	
	public DatoNominasBean(int id_empleado,int nomina) {
		this.id_empleado=id_empleado;
		this.nomina=nomina;
	}

		public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public int getNomina() {
		return nomina;
	}
	public void getNomina(int nomina) {
		this.nomina=nomina;
	}
}
