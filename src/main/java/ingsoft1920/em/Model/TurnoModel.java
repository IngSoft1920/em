package ingsoft1920.em.Model;


public class TurnoModel {
	private int id_Empleado;
	private int id_Turno;
	private String horarioInicio;
	private String horarioFin;
	private String diaSemana;
	
	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public TurnoModel(int id_Empleado, int id_Turno, String horarioInicio, String horarioFin,String diaSemana) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Turno=id_Turno;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
		this.diaSemana=diaSemana;
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

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}

	

}
