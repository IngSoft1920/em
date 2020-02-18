package ingsoft1920.em.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ingsoft1920.em.Conector.ConectorBBDD;
import ingsoft1920.em.Model.BajaModel;
import ingsoft1920.em.Model.EmpleadoModel;
import ingsoft1920.em.Model.EmpleadoModelC2;
import ingsoft1920.em.Model.VacacionesModel;

public class EmpleadoDAO {
	//TODAS las consultas a las bases de datos
	static Connection conn;
	public static EmpleadoModel sacaEmpleados(){
		//CONSULTA1-> Hay que enviar a dho todos los id_empleado con su id_turno
		if(conn==null) {
			conn=ConectorBBDD.conectar();
		}
		EmpleadoModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt=conn.createStatement();
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   if (rs.next()){
		      res = new EmpleadoModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Turno"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
		}
	public static EmpleadoModelC2 sacaEmpleados2() {
		//CONSULTA2-> Hay que enviar a fnb id_Empleado con su id_Rol y estado
		EmpleadoModelC2 res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM empleado");
		   if (rs.next()){
		      res = new EmpleadoModelC2 ( 
		      rs.getInt("id_Empleado"), 
		      rs.getString("id_Rol"),
		      rs.getBoolean("estado"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	public static BajaModel BajaModelSacaBajas() {
		//CONSULTA3-> Hay que enviar a cm las bajas con el id_empleado que la pide y su duraci�n
		BajaModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM bajas");
		   if (rs.next()){
		      res = new BajaModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Baja"),
		      rs.getString("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	
	public static VacacionesModel sacaBajas() {
		//CONSULTA4-> Hay que enviar a cm las vacacioens con el id_empleado que la pide y su duraci�n
		VacacionesModel res = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		  try { 
		   stmt = conn.createStatement() ;
		   rs = stmt.executeQuery("SELECT * FROM vacaciones");
		   if (rs.next()){
		      res = new VacacionesModel ( 
		      rs.getInt("id_Empleado"), 
		      rs.getInt("id_Vacaciones"),
		      rs.getString("duracion"));
		      }
          } 
		  catch (SQLException ex){ 
		   System.out.println("SQLException: " + ex.getMessage());
		  }
		  return res;
	}
	public static void añadirTurno(int id_Empleado) {
		//CONSULTA3-> Hay que enviar el turno sabiendo el id_empleado
		int id_turno;
		PreparedStatement stmt=null;
		
		
	}
}
