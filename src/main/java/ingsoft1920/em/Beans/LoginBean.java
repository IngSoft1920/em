package ingsoft1920.em.Beans;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {

	String usuario;
	String password;
	int id_empleado;
	
	//En un bean siempre es necesario el constructor vacio
	public LoginBean() {}
	
	public LoginBean(String usuario,String password,int id_empleado) {
		this.usuario=usuario;
		this.password=password;
		this.id_empleado=id_empleado;
	}
	
	public boolean checkCamposValidos() {
		return true;
	}
	
	
	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
