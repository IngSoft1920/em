package ingsoft1920.em.Beans;


import org.springframework.stereotype.Component;

@Component
public class DatoTurnoBean {
	int id_turno;
	int id_empleado;
	String horarioInicio;
	String horarioFin;
	String diaSemana;
	
	
	
	public String getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}


	public DatoTurnoBean() {};
	
	
	public DatoTurnoBean(int id_turno,int id_empleado,String horarioInicio,String horarioFin,String diaSemana) {
		this.id_turno=id_turno;
		this.id_empleado=id_empleado;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
		this.diaSemana=diaSemana;
	}

		public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public int getId_turno() {
		return id_turno;
	}


	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
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
