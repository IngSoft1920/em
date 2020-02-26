package ingsoft1920.em.Model;

import java.sql.Time;

public class TurnoModel {
	private int id_Empleado;
	private int id_Turno;
	private String horarioInicio;
	private String horarioFin;
	
	public TurnoModel(int id_Empleado, int id_Turno, String horarioInicio, String horarioFin) {
		super();
		this.id_Empleado=id_Empleado;
		this.id_Turno=id_Turno;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
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
