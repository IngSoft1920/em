package ingsoft1920.em.Beans;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BajaBean {
	int id_baja;
	int id_empleado;
	int duracion;
	String estado;
	Date fecha_inicio;
	Date fecha_fin;
	String tipo;
	
	public BajaBean() {}
	
	public BajaBean(int id_baja, int id_empleado, int duracion, String estado,Date fecha_inicio, Date fecha_fin, String tipo) {
		this.id_baja = id_baja;
		this.id_empleado = id_empleado;
		this.duracion = duracion;
		this.estado = estado;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
		this.tipo=tipo;
	}

	
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getId_baja() {
		return id_baja;
	}

	public void setId_baja(int id_baja) {
		this.id_baja = id_baja;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
