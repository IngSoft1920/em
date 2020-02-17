package ingsoft1920.em.Beans;

import java.sql.Time;

public class DatoTurnoBean {
	int id_turno;
	int id_empleado;
	Time tiempo;
	
	public DatoTurnoBean() {};
	
	@SuppressWarnings("deprecation")
	public DatoTurnoBean(int id_turno,int id_empleado) {
		this.id_turno=id_turno;
		this.id_empleado=id_empleado;
		//this.tiempo=new Time(this.tiempo.getHours(),this.tiempo.getMinutes(),this.tiempo.getSeconds());
	}

	public int getId_turno() {
		return id_turno;
	}

	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
/*
	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}
	*/
	
}
