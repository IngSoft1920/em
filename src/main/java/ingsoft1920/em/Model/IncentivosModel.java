package ingsoft1920.em.Model;

public class IncentivosModel {
	private int id_incentivo;
	private int id_empleado;
	private int valor;
	
	public IncentivosModel(int id_incentivo,int id_empleado,int valor) {
		this.id_incentivo=id_incentivo;
		this.id_empleado=id_empleado;
		this.valor=valor;
	}

	public int getId_incentivo() {
		return id_incentivo;
	}

	public void setId_incentivo(int id_incentivo) {
		this.id_incentivo = id_incentivo;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	

}
